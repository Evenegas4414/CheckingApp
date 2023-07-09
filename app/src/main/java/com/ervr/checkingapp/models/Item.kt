package com.ervr.checkingapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "itemId")
    val id: Int = 0,
    @ColumnInfo(name = "itemNombre")
    val nombre: String,
    @ColumnInfo(name = "itemPrecio")
    val precio: Double,
    @ColumnInfo(name = "itemCantidad")
    val cantidad: Int,
    @ColumnInfo(name = "itemTotal")
    val total: Double
)