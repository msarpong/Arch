package com.msarpong.arch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.msarpong.arch.data.ListItem
import com.msarpong.arch.databinding.ItemListBinding

class MainAdapter : RecyclerView.Adapter<ListViewHolder>() {

    private val DIFF_CALLBACK: DiffUtil.ItemCallback<ListItem> =
        object : DiffUtil.ItemCallback<ListItem>() {
            override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
                return oldItem == newItem
            }
        }

    private val mDiffer: AsyncListDiffer<ListItem> = AsyncListDiffer(this, DIFF_CALLBACK)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
//        val item = getItem(position)
//        holder.bind(item)
        holder.bind(mDiffer.currentList[position])
    }

    override fun getItemCount(): Int {
        return mDiffer.currentList.size;
    }

    fun submitList(list: List<ListItem>) {
        return mDiffer.submitList(list)
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