[![](https://jitpack.io/v/norulab/android-exoplayer-fullscreen.svg)](https://jitpack.io/#norulab/android-exoplayer-fullscreen)

# Fullscreen Exoplayer

Using ExoPlayer with fullscreen option (Android/Kotlin)

<img src="https://github.com/Norulab/android-exoplayer-fullscreen/blob/master/exofullscreen_screen.png" width="550" height="300">


## Getting Started

Step 1. Add the JitPack repository to your root build.gradle at the end of repositories:

```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

Step 2. Add the dependency

```
dependencies {
	implementation 'com.google.android.exoplayer:exoplayer:2.11.3'
	implementation 'com.github.norulab:android-exoplayer-fullscreen:1.1.6'
}
```

## Demonstration

Step1. Add you ExoPlayer to your Layout
```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

     <com.google.android.exoplayer2.ui.PlayerView
         android:id="@+id/playerViewFullscreen"
         android:visibility="gone"
         android:layout_width="match_parent"
         android:layout_height="300dp" />

</RelativeLayout>
```

Step2. Use the library
```
val player = SimpleExoPlayer.Builder(context).build()
player.preparePlayer(playerView)
player.setSource(applicationContext, "http://html5videoformatconverter.com/data/images/happyfit2.mp4")
```

That's it!


## Options

If you want to force the landscape :
```
player.preparePlayer(playerView, true)
```

You can use the MediaPlayer object to initialise the player and start/pause/stop the player :
```
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MediaPlayer.initialize(applicationContext)
        MediaPlayer.exoPlayer?.preparePlayer(playerView, true)
        MediaPlayer.exoPlayer?.setSource(applicationContext, "http://html5videoformatconverter.com/data/images/happyfit2.mp4")
        MediaPlayer.startPlayer()
    }

    public override fun onPause() {
        super.onPause()
        MediaPlayer.pausePlayer()
    }

    public override fun onStop() {
        MediaPlayer.stopPlayer()
        super.onDestroy()
    }
}
```

## Contributing

You're contribution is welcome here!

## Authors

* **Jérôme CLAMENT-SANZ** - *Code* - [jewom](https://github.com/jewom)
* **Christophe ROMANA** - *Code* - [liltof](https://github.com/liltof)

## License

This project is licensed under nothing :)

