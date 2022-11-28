package com.lutfullayevmuhammad.quran.core.models.suraDetailsAudios


import com.google.gson.annotations.SerializedName

data class SuraDetailsAudioResponse(
    @SerializedName("audio_files")
    val audioFiles: AudioFile,
    @SerializedName("pagination")
    val pagination: Pagination
)