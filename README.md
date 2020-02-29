[![](https://jitpack.io/v/norulab/android-exoplayer-fullscreen.svg)](https://jitpack.io/#norulab/android-exoplayer-fullscreen)

# Fullscreen Exoplayer

Using exoplayer with fullscreen option (in Kotlin)

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
	implementation 'com.github.norulab:android-exoplayer-fullscreen:1.0.0'
	}
```

## Demonstration

Step1. Make a layout like this one
```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:keepScreenOn="true"
    tools:context=".MainActivity">

     <RelativeLayout
         android:layout_width="match_parent"
         android:layout_height="300dp">

          <com.google.android.exoplayer2.ui.PlayerView
              android:id="@+id/playerView"
              android:layout_width="match_parent"
              android:layout_height="match_parent" />

     </RelativeLayout>

     <com.google.android.exoplayer2.ui.PlayerView
         android:id="@+id/playerViewFullscreen"
         android:visibility="gone"
         android:layout_width="match_parent"
         android:layout_height="match_parent" />

</RelativeLayout>
```

Step2. Test this code using two exo PlayerView
```
player.preparePlayer(playerView, playerViewFullscreen)
player.setSource(applicationContext, "http://html5videoformatconverter.com/data/images/happyfit2.mp4")
player.playWhenReady = true
```


## Contributing

You're contribution is welcome here!

## Authors

* **Jérôme CLAMENT-SANZ** - *Code* - [jewom](https://github.com/jewom)
* **Christophe ROMANA** - *Code* - [liltof](https://github.com/liltof)

## License

This project is licensed under nothing :)

