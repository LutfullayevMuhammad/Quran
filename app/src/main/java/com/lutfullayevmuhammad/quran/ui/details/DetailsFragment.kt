package com.lutfullayevmuhammad.quran.ui.details

import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.lutfullayevmuhammad.quran.R
import com.lutfullayevmuhammad.quran.core.adapters.details.DetailsAdapter
import com.lutfullayevmuhammad.quran.core.helper.ViewModelProviderFactory
import com.lutfullayevmuhammad.quran.core.models.suraDetailsAudios.AudioFile
import com.lutfullayevmuhammad.quran.core.utils.VerticalItemDecoration
import com.lutfullayevmuhammad.quran.databinding.DetailsFragmentBinding
import dagger.android.support.DaggerFragment
import java.io.IOException
import javax.inject.Inject
import kotlin.math.roundToInt

class DetailsFragment : DaggerFragment() {

    private val binding by lazy {
        DetailsFragmentBinding.inflate(layoutInflater)
    }

    private var adapter = DetailsAdapter()
    var pageNumber = 1
    private var playPause = false

    @Inject
    lateinit var vmProviderFactory: ViewModelProviderFactory
    private val viewModel: DetailsViewModel by viewModels { vmProviderFactory }

    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val size = resources.getDimension(R.dimen._12db)
        val decoration = VerticalItemDecoration(size.roundToInt())
        binding.detailsList.addItemDecoration(decoration)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.detailsList.adapter = adapter
//        binding.detailsList.layoutManager = LinearLayoutManager(requireContext())

        viewModel.suraDetails(args.id)
        viewModel.suraDetailsTranslations(args.id)
        viewModel.suraDetailsDesc("ru")
//        viewModel.suraDetailsAudio(args.id, pageNumber.toString())
//        pageNumber++

        viewModel.detailsLiveData.observe(viewLifecycleOwner) {
            adapter.dataArabic = it.verses
        }

//        adapter.onItemClick = {
//            viewModel.detailsAudioLiveData.observe(viewLifecycleOwner) { audio ->
//                if (audio.audioFiles.verseKey == it.verseKey) {
//                    if (playPause == false) {
//                        playAudio(audio.audioFiles)
//                        playPause = true
//                    } else if (playPause == true) {
//                        if (mediaPlayer!!.isPlaying) {
//                            mediaPlayer!!.pause()
//                        }
//                        playPause = false
//                    }
//                }
//                viewModel.suraDetailsAudio(args.id, pageNumber.toString())
//                pageNumber++
//            }
//        }

        viewModel.detailsDescLiveData.observe(viewLifecycleOwner) {
            it.chapters.forEach {
                if (args.id == it.id.toString()) {
                    binding.suraName.text = it.nameSimple
                    binding.suraAyah.text =
                        "Sura ${it.revelationPlace} - ${it.versesCount} Аятов"

                    if (it.bismillahPre == false)
                        binding.basmalaCard.visibility = View.GONE
                    else
                        binding.basmalaCard.visibility = View.VISIBLE

                }
            }
        }

//        viewModel.detailsAudioLiveData.observe(viewLifecycleOwner) {
//            adapter.dataAudio = it.audioFiles
//        }

        viewModel.detailsTranslationsLiveData.observe(viewLifecycleOwner) {
            adapter.dataTranslations = it.translations
            binding.detailsList.adapter = adapter
            binding.detailsList.layoutManager = LinearLayoutManager(requireContext())
        }

//        adapter.onScrollEnd = {
//            viewModel.suraDetailsAudio(args.id, pageNumber.toString())
//            viewModel.detailsAudioLiveData.observe(viewLifecycleOwner){
//                adapter.dataAudio = it.audioFiles
//            }
//            pageNumber++
//        }

        viewModel.errorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it?.error, Toast.LENGTH_SHORT).show()
        }
        viewModel.networkErrorLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "networkErrorLiveData", Toast.LENGTH_SHORT).show()
        }

        binding.backButton.setOnClickListener {
            requireActivity().onBackPressed()
        }

    }

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