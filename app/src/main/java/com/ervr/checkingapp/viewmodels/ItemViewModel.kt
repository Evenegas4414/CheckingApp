package com.ervr.checkingapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.ervr.checkingapp.data.ItemRepository
import com.ervr.checkingapp.models.Item

class ItemViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ItemRepository = ItemRepository(application)
    private val allProducts: LiveData<List<Item>>?

    init {
        allProducts = repository.allItems
    }

    fun insertItem(item: Item) {
        repository.insertItem(item)
    }
    fun deleteAllItems() {
        repository.deleteAllItem()
    }

    fun getAllItems(): LiveData<List<Item>>? {
        return allProducts
    }


}