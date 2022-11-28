package com.lutfullayevmuhammad.quran.core.models.suraDetails


import com.google.gson.annotations.SerializedName

data class Verse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("verse_key")
    val verseKey: String,
    @SerializedName("text_uthmani")
    val textUthmani: String
)