package com.lutfullayevmuhammad.quran.core.adapters.home

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.lutfullayevmuhammad.quran.core.models.sura.Chapter
import com.lutfullayevmuhammad.quran.databinding.ItemHomeBinding

class HomeAdapterHolder(val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bindData(data: Chapter) {
        binding.ayahNumber.text = data.id.toString()
        binding.suraName.text = data.nameSimple
        binding.suraNameArabic.text = data.nameArabic
        binding.suraTotalAyah.text = "Sura ${data.revelationPlace} - ${data.versesCount} Аятов"
    }

}