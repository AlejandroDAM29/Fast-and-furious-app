package com.example.pacdirecto

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class ServicioMusica: Service() {

    var reproductor: MediaPlayer?=null


    override fun onCreate(){
        super.onCreate()
        reproductor = MediaPlayer.create(this,R.raw.cancion_fondo)
        reproductor?.setVolume(100F,100F)
        reproductor?.isLooping = true
    }



    override fun onStartCommand(intent: Intent?,flags: Int, startId: Int): Int{
        reproductor?.start()
        return START_STICKY
    }




    //No hay que tocarlo
    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onDestroy(){
        super.onDestroy()

        if(reproductor?.isPlaying==true){
            reproductor?.stop()
        }

    }






}