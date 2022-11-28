package com.lutfullayevmuhammad.quran.core.adapters.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lutfullayevmuhammad.quran.core.models.sura.Chapter
import com.lutfullayevmuhammad.quran.core.models.suraDetails.Verse
import com.lutfullayevmuhammad.quran.core.models.suraDetailsAudios.AudioFile
import com.lutfullayevmuhammad.quran.core.models.suraDetailsTranslations.Translation
import com.lutfullayevmuhammad.quran.databinding.ItemDetailsBinding

class DetailsAdapter : RecyclerView.Adapter<DetailsAdapterHolder>() {

    var dataArabic = ArrayList<Verse>()
        set(value) {
            field.addAll(value)
            notifyItemRangeInserted(dataArabic.size - value.size, value.size)
        }

    var dataTranslations = ArrayList<Translation>()
        set(value) {
            field.addAll(value)
            notifyItemRangeInserted(dataTranslations.size - value.size, value.size)
        }

    var dataAudio = ArrayList<AudioFile>()
        set(value) {
            field.addAll(value)
            notifyItemRangeInserted(dataAudio.size - value.size, value.size)
        }

    var onScrollEnd: (() -> Unit)? = null

    var onItemClick: ((Verse) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsAdapterHolder =
        DetailsAdapterHolder(
            ItemDetailsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: DetailsAdapterHolder, position: Int) {
        holder.bindDataArabic(dataArabic[position])
        holder.bindDataTranslations(dataTranslations[position])
//        holder.bindDataAudio(dataAudio[position])
//        if (position == dataAudio.size - 1) {
//            onScrollEnd?.invoke()
//        }

        holder.binding.root.setOnClickListener {
            onItemClick?.invoke(dataArabic[position])
        }
    }

    override fun getItemCount(): Int = dataArabic.size

}