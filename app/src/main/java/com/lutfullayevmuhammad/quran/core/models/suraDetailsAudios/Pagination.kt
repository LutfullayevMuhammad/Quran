package com.lutfullayevmuhammad.quran.core.models.suraDetailsAudios


import com.google.gson.annotations.SerializedName

data class Pagination(
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("current_page")
    val currentPage: Int,
    @SerializedName("next_page")
    val nextPage: Any,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_records")
    val totalRecords: Int
)