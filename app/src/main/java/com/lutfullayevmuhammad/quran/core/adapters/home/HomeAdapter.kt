package com.lutfullayevmuhammad.quran.core.adapters.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lutfullayevmuhammad.quran.core.models.sura.Chapter
import com.lutfullayevmuhammad.quran.databinding.ItemHomeBinding

class HomeAdapter : RecyclerView.Adapter<HomeAdapterHolder>() {

    var data = ArrayList<Chapter>()
        set(value) {
            field.addAll(value)
            notifyItemRangeInserted(data.size - value.size, value.size)
        }
    var onScrollEnd: (() -> Unit)? = null

    var onItemClick: ((Chapter) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapterHolder =
        HomeAdapterHolder(
            ItemHomeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: HomeAdapterHolder, position: Int) {
        holder.bindData(data = data[position])
//        if (position == data.size - 1) {
//            onScrollEnd?.invoke()
//        }

        holder.binding.root.setOnClickListener {
            onItemClick?.invoke(data[position])
        }
    }

    override fun getItemCount(): Int = data.size

}