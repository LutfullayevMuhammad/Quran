package com.lutfullayevmuhammad.quran.core.models.suraDetailsTranslations


import com.google.gson.annotations.SerializedName

data class Translation(
    @SerializedName("resource_id")
    val resourceId: Int,
    @SerializedName("text")
    val text: String
)