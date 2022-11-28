package com.lutfullayevmuhammad.quran.core.models.suraDetailsTranslations


import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("translation_name")
    val translationName: String,
    @SerializedName("author_name")
    val authorName: String,
    @SerializedName("filters")
    val filters: Filters
)