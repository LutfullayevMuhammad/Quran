package com.lutfullayevmuhammad.quran.core.adapters.details

import android.annotation.SuppressLint
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.recyclerview.widget.RecyclerView
import com.lutfullayevmuhammad.quran.R
import com.lutfullayevmuhammad.quran.core.models.suraDetails.Verse
import com.lutfullayevmuhammad.quran.core.models.suraDetailsAudios.AudioFile
import com.lutfullayevmuhammad.quran.core.models.suraDetailsTranslations.Translation
import com.lutfullayevmuhammad.quran.databinding.ItemDetailsBinding
import java.io.IOException


class DetailsAdapterHolder(val binding: ItemDetailsBinding) :
    RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bindDataArabic(ayahArabic: Verse) {
        binding.ayahNumber.text = ayahArabic.verseKey
        binding.ayahArabic.text = ayahArabic.textUthmani
    }

    @SuppressLint("SetTextI18n")
    fun bindDataTranslations(
        ayahTranslation: Translation
    ) {
        binding.ayahTranslations.text = ayahTranslation.text
    }

//    @SuppressLint("SetTextI18n")
//    fun bindDataAudio(suraAudio: AudioFile) {
//
//        binding.audioCard2.setOnClickListener {
//            if (playPause == false) {
//                binding.audioPauseOrStopBtnIcon.setImageResource(R.drawable.audio_pause_btn_icon)
//                playAudio(suraAudio)
//                playPause = true
//            } else if (playPause == true) {
//                binding.audioPauseOrStopBtnIcon.setImageResource(R.drawable.audio_stop_btn_icon)
//                if (mediaPlayer!!.isPlaying) {
//                    mediaPlayer!!.pause()
//                }
//                playPause = false
//            }
//        }
//
//    }

    var mediaPlayer: MediaPlayer? = null

    private fun playAudio(audioData: AudioFile) {
        val audioUrl = "https://verses.quran.com/${audioData.url}"

        // initializing media player
        mediaPlayer = MediaPlayer()

        // below line is use to set the audio
        // stream type for our media player.
        mediaPlayer?.setAudioStreamType(AudioManager.STREAM_MUSIC)

        // below line is use to set our
        // url to our media player.
        try {
            mediaPlayer?.setDataSource(audioUrl)
            // below line is use to prepare
            // and start our media player.
            mediaPlayer?.prepare()
            mediaPlayer?.start()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

}