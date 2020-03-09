package com.norulab.exofullscreen

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.net.Uri
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util

@SuppressLint("SourceLockedOrientationActivity")
fun SimpleExoPlayer.preparePlayer(playerView: PlayerView, forceLandscape:Boolean = false) {
    (playerView.context as AppCompatActivity).apply {
        val playerViewFullscreen = PlayerView(this)
        val layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        playerViewFullscreen.layoutParams = layoutParams
        playerViewFullscreen.visibility = View.GONE
        playerViewFullscreen.setBackgroundColor(Color.BLACK)
        (playerView.rootView as ViewGroup).apply { addView(playerViewFullscreen, childCount) }
        val fullScreenButton: ImageView = playerView.findViewById(R.id.exo_fullscreen_icon)
        val normalScreenButton: ImageView = playerViewFullscreen.findViewById(R.id.exo_fullscreen_icon)
        fullScreenButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_fullscreen_open))
        normalScreenButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_fullscreen_close))
        fullScreenButton.setOnClickListener {
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
            supportActionBar?.hide()
            if (forceLandscape)
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            playerView.visibility = View.GONE
            playerViewFullscreen.visibility = View.VISIBLE
            PlayerView.switchTargetView(this@preparePlayer, playerView, playerViewFullscreen)
        }
        normalScreenButton.setOnClickListener {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
            supportActionBar?.show()
            if (forceLandscape)
                requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            normalScreenButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_fullscreen_close))
            playerView.visibility = View.VISIBLE
            playerViewFullscreen.visibility = View.GONE
            PlayerView.switchTargetView(this@preparePlayer, playerViewFullscreen, playerView)
        }
        playerView.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIXED_HEIGHT
        playerView.player = this@preparePlayer
    }
}
fun SimpleExoPlayer.setSource(context: Context, url: String){
    val dataSourceFactory: DataSource.Factory = DefaultDataSourceFactory(context, Util.getUserAgent(context, "app"))
    val videoSource: MediaSource =
            if (url.endsWith("m3u8") || url.endsWith("m3u"))
                ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(Uri.parse(url))
            else
                HlsMediaSource.Factory(dataSourceFactory).createMediaSource(Uri.parse(url))
    this.prepare(videoSource)
}