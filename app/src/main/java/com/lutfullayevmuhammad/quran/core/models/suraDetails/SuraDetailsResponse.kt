package com.lutfullayevmuhammad.quran.core.models.suraDetails


import com.google.gson.annotations.SerializedName

data class SuraDetailsResponse(
    @SerializedName("verses")
    val verses: ArrayList<Verse>,
    @SerializedName("meta")
    val meta: Meta
)