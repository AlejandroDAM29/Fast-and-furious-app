package com.example.pacdirecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Galeria : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_galeria)
    }



    fun atras(vista:View){
        onBackPressed()
    }




}