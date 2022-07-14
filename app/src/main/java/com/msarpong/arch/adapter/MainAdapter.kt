package com.msarpong.arch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.msarpong.arch.data.ListItem
import com.msarpong.arch.databinding.ItemListBinding

class MainAdapter : ListAdapter<ListItem, ListViewHolder>(DiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

class ListViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
    val name = binding.name
    private val first = binding.First
    fun bind(item: ListItem) {
        name.text = item.name
        first.text = item.First
    }
}

class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<ListItem>() {
    override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
        return oldItem == newItem
    }
}