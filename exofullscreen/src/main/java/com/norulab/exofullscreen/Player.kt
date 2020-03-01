package com.norulab.exofullscreen

import android.content.Context
import com.google.android.exoplayer2.SimpleExoPlayer

object MediaPlayer{

    var exoPlayer: SimpleExoPlayer? = null

    fun initialize(context: Context?){
        if (context != null)
            exoPlayer = SimpleExoPlayer.Builder(context).build()
    }

    fun pausePlayer() {
        exoPlayer?.playWhenReady = false
        exoPlayer?.playbackState
    }

    fun startPlayer() {
        exoPlayer?.playWhenReady = true
        exoPlayer?.playbackState
    }

    fun stopPlayer() {
        exoPlayer?.stop()
    }

}