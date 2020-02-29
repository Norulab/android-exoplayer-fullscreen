package com.exoplayer.fullscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.*
import com.norulab.exofullscreen.preparePlayer
import com.norulab.exofullscreen.setSource
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val player: SimpleExoPlayer by lazy { SimpleExoPlayer.Builder(applicationContext).build() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        player.preparePlayer(playerView)
        player.setSource(applicationContext, "http://html5videoformatconverter.com/data/images/happyfit2.mp4")
        player.playWhenReady = true
    }

    public override fun onPause() {
        super.onPause()
        player.playWhenReady = false
    }

    public override fun onDestroy() {
        player.release()
        super.onDestroy()
    }
}