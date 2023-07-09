package com.ervr.checkingapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ervr.checkingapp.models.Item

@Dao
interface ItemDao {
    @Query("SELECT * FROM items")
    fun getAllItems(): LiveData<List<Item>>

    @Insert
    fun insert(item: Item)

    @Query("DELETE FROM items")
    fun deleteAllItems()
}
