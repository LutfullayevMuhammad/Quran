package com.lutfullayevmuhammad.quran.core.models.sura


import com.google.gson.annotations.SerializedName

data class SuraResponse(
    @SerializedName("chapters")
    val chapters: ArrayList<Chapter>
)