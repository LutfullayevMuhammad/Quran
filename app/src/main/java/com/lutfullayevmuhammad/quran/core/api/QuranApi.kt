package com.lutfullayevmuhammad.quran.core.api

import com.lutfullayevmuhammad.quran.core.models.sura.SuraResponse
import com.lutfullayevmuhammad.quran.core.models.suraDetails.SuraDetailsResponse
import com.lutfullayevmuhammad.quran.core.models.suraDetailsAudios.SuraDetailsAudioResponse
import com.lutfullayevmuhammad.quran.core.models.suraDetailsTranslations.SuraDetailsTranslationsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface QuranApi {


    @GET("api/v4/chapters")
    suspend fun suraList(
        @Query("language") language: String
    ): Response<SuraResponse?>

    @GET("api/v4/quran/verses/uthmani")
    suspend fun detailsSura(
        @Query("chapter_number") chapterNumber: String
    ): Response<SuraDetailsResponse?>

    @GET("api/v4/quran/translations/45")
    suspend fun detailsSuraTranslations(
        @Query("chapter_number") chapterNumber: String
    ): Response<SuraDetailsTranslationsResponse?>

    @GET("api/v4/recitations/3/by_chapter/{chapter_number}")
    suspend fun detailsSuraAudio(
        @Path("chapter_number") chapterNumber: String,
        @Query("page") page: String
    ): Response<SuraDetailsAudioResponse?>


}