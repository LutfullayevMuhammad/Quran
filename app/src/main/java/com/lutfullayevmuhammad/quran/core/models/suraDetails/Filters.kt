package com.lutfullayevmuhammad.quran.core.models.suraDetails


import com.google.gson.annotations.SerializedName

data class Filters(
    @SerializedName("chapter_number")
    val chapterNumber: String
)