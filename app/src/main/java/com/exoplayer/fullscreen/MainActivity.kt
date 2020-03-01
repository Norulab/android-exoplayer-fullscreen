package com.exoplayer.fullscreen

import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.*
import com.norulab.exofullscreen.MediaPlayer
import com.norulab.exofullscreen.preparePlayer
import com.norulab.exofullscreen.setSource
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val player: SimpleExoPlayer by lazy { SimpleExoPlayer.Builder(applicationContext).build() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MediaPlayer.initialize(applicationContext)
        player.preparePlayer(playerView, true)
        player.setSource(applicationContext, "http://html5videoformatconverter.com/data/images/happyfit2.mp4")
        MediaPlayer.startPlayer()
    }

    public override fun onPause() {
        super.onPause()
        MediaPlayer.pausePlayer()
    }

    public override fun onDestroy() {
        MediaPlayer.stopPlayer()
        super.onDestroy()
    }
}