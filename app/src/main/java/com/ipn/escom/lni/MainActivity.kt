package com.ipn.escom.lni

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ipn.escom.lni.ui.navigation.AppLNINavigation
import com.ipn.escom.lni.ui.theme.LaNocheDeLasIdeasTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var mediaPlayer : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mediaPlayer = MediaPlayer.create(this, R.raw.auido_fondo)
        mediaPlayer.isLooping = true
        mediaPlayer.start()

        enableEdgeToEdge()
        setContent {
            LaNocheDeLasIdeasTheme {
                AppLNINavigation()
            }
        }
    }
}