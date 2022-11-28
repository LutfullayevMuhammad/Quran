package com.lutfullayevmuhammad.quran.core.models.error


import com.google.gson.annotations.SerializedName

data class UniversalError(
    @SerializedName("status")
    val status: Int,
    @SerializedName("error")
    val error: String
)