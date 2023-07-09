package com.ervr.checkingapp.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.ervr.checkingapp.R
import com.ervr.checkingapp.models.Item

class ItemListAdapter(private val itemLayout: Int) :
    RecyclerView.Adapter<ItemListAdapter.ViewHolder>() {
    private var itemList: List<Item>? = null
    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val itemNombre = holder.itemNombre
        val itemPrecio = holder.itemPrecio
        val itemCantidad = holder.itemCantidad
        val itemTotal = holder.itemTotal
        itemList.let {
            itemNombre.text = it!![listPosition].nombre
            itemPrecio.text = "$" + it[listPosition].precio.toInt().toString()
            itemCantidad.text = it[listPosition].cantidad.toString()
            itemTotal.text = "$" + it[listPosition].total.toInt().toString()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            itemLayout, parent, false)
        return ViewHolder(view)
    }
    fun setProductList(items: List<Item>) {
        itemList = items
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return if (itemList == null) 0 else itemList!!.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemNombre: TextView = itemView.findViewById(R.id.itemNombre)
        var itemPrecio: TextView = itemView.findViewById(R.id.itemPrecio)
        var itemCantidad: TextView = itemView.findViewById(R.id.itemCantidad)
        var itemTotal: TextView = itemView.findViewById(R.id.itemTotal)
    }
}