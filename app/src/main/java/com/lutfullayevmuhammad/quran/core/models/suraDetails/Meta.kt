package com.lutfullayevmuhammad.quran.core.models.suraDetails


import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("filters")
    val filters: Filters
)