package com.ervr.checkingapp.views

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ervr.checkingapp.R
import com.ervr.checkingapp.models.Item
import com.ervr.checkingapp.viewmodels.ItemViewModel

class AddFragment : Fragment(R.layout.fragment_add) {

    private val itemViewModel: ItemViewModel by viewModels()

    // Declare your EditTexts and Button
    private lateinit var etItemNombre: EditText
    private lateinit var etItemPrecio: EditText
    private lateinit var etItemCantidad: EditText
    private lateinit var btnGuardar: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize your EditTexts and Button
        etItemNombre = view.findViewById(R.id.etItemNombre)
        etItemPrecio = view.findViewById(R.id.etItemPrecio)
        etItemCantidad = view.findViewById(R.id.etItemCantidad)
        btnGuardar = view.findViewById(R.id.btnGuardar)

        btnGuardar.setOnClickListener {
            val nombre = etItemNombre.text.toString()
            val precio = etItemPrecio.text.toString().toDouble()
            val cantidad = etItemCantidad.text.toString().toInt()
            val total = precio * cantidad

            val newItem = Item(nombre = nombre, precio = precio, cantidad = cantidad, total = total)

            itemViewModel.insertItem(newItem)

            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }
    }
}
