package com.lutfullayevmuhammad.quran.core.models.suraDetailsTranslations


import com.google.gson.annotations.SerializedName

data class SuraDetailsTranslationsResponse(
    @SerializedName("translations")
    val translations: ArrayList<Translation>,
    @SerializedName("meta")
    val meta: Meta
)