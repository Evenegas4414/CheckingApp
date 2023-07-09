package com.ervr.checkingapp.data

import android.app.Application
import androidx.lifecycle.LiveData
import com.ervr.checkingapp.data.ItemDao
import com.ervr.checkingapp.models.AppDatabase
import com.ervr.checkingapp.models.Item
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemRepository(application: Application) {

    private var itemDao: ItemDao?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val allItems: LiveData<List<Item>>?

    init {
        val db: AppDatabase? =
            AppDatabase.getDatabase(application)
        itemDao = db?.itemDao()
        allItems = itemDao?.getAllItems()
    }

    fun insertItem(newItem: Item) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(newItem)
        }
    }

    private fun asyncInsert(item: Item) {
        itemDao?.insert(item)
    }

    fun deleteAllItem() {
        coroutineScope.launch(Dispatchers.IO) {
            asyncDelete()
        }
    }

    private fun asyncDelete() {
        itemDao?.deleteAllItems()
    }

}