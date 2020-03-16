package com.chuckerteam.chucker.internal.ui.storage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chuckerteam.chucker.databinding.ChuckerListItemStorageBinding
import com.chuckerteam.chucker.internal.data.entity.StorageTuple

internal class StorageAdapter : RecyclerView.Adapter<StorageAdapter.StorageViewHolder>(){

    private var data: List<String> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StorageViewHolder {
        val viewbinding = ChuckerListItemStorageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StorageViewHolder(viewbinding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: StorageViewHolder, position: Int) =
            holder.bind(data[position])

    fun setData(data:List<String>){
        this.data = data
        notifyDataSetChanged()
    }

    inner class StorageViewHolder(
            private val itemBinding: ChuckerListItemStorageBinding
    ):RecyclerView.ViewHolder(itemBinding.root){
        internal fun bind(tuple: String){
            with(itemBinding){
                storagename.text = tuple
            }
        }
    }
}