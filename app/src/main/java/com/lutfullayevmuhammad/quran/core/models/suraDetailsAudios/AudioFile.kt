package com.lutfullayevmuhammad.quran.core.models.suraDetailsAudios


import com.google.gson.annotations.SerializedName

data class AudioFile(
    @SerializedName("verse_key")
    val verseKey: String,
    @SerializedName("url")
    val url: String
)