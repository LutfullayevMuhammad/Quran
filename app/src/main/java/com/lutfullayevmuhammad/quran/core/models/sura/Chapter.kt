package com.lutfullayevmuhammad.quran.core.models.sura


import com.google.gson.annotations.SerializedName

data class Chapter(
    @SerializedName("id")
    val id: Int,
    @SerializedName("revelation_place")
    val revelationPlace: String,
    @SerializedName("revelation_order")
    val revelationOrder: Int,
    @SerializedName("bismillah_pre")
    val bismillahPre: Boolean,
    @SerializedName("name_simple")
    val nameSimple: String,
    @SerializedName("name_complex")
    val nameComplex: String,
    @SerializedName("name_arabic")
    val nameArabic: String,
    @SerializedName("verses_count")
    val versesCount: Int,
    @SerializedName("pages")
    val pages: List<Int>,
    @SerializedName("translated_name")
    val translatedName: TranslatedName
)