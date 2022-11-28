package com.lutfullayevmuhammad.quran.core.models.suraDetailsTranslations


import com.google.gson.annotations.SerializedName

data class Filters(
    @SerializedName("resource_id")
    val resourceId: Int,
    @SerializedName("chapter_number")
    val chapterNumber: String
)