package com.lutfullayevmuhammad.quran.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lutfullayevmuhammad.quran.R
import com.lutfullayevmuhammad.quran.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}