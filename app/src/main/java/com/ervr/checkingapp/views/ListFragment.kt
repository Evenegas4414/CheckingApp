package com.ervr.checkingapp.views

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ervr.checkingapp.R
import com.ervr.checkingapp.viewmodels.ItemViewModel

class ListFragment : Fragment(R.layout.fragment_list) {

    private val itemViewModel: ItemViewModel by viewModels()

    private lateinit var rvItems: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        rvItems = view.findViewById(R.id.rvItems)

        val adapter = ItemListAdapter(R.layout.item_list_element)
        rvItems.adapter = adapter
        rvItems.layoutManager = LinearLayoutManager(requireContext())

        itemViewModel.getAllItems()?.observe(viewLifecycleOwner) { items ->
            items?.let { adapter.setProductList(it) }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_delete_all -> {
                itemViewModel.deleteAllItems()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
