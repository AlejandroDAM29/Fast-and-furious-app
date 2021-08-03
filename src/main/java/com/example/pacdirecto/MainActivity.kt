package com.example.pacdirecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





    }

    /*
    * MÉTODOS PARA IR A LAS OTRAS ACTIVITIES
    * ---------------------------------------------------------------------------------------------*/

    //Ir a BBDD
    fun ir_BBDD(vista: View){
        var irBase = Intent(this, BaseDatos::class.java)
        startActivity(irBase)
    }

    //Ir a Camara
    fun ir_camara(vista: View){
        var irBase = Intent(this, Camara::class.java)
        startActivity(irBase)
    }
    //Ir a Galeria
    fun ir_galeria(vista: View){
        var irBase = Intent(this, Galeria::class.java)
        startActivity(irBase)
    }
    //Ir a pararMusica
    fun pararMusica(vista: View){
        var irBase = Intent(this, ServicioMusica::class.java)
        this.stopService(irBase)
    }
    //Ir a playMusica
    fun playMusica(vista: View){
        var irBase = Intent(this, ServicioMusica::class.java)
        this.startService(irBase)
    }



}