package com.example.pacdirecto

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.pacdirecto.EsqueletoBaseDatos.EsqueletoBaseDatos.COLUMNA_CIUDAD
import com.example.pacdirecto.EsqueletoBaseDatos.EsqueletoBaseDatos.COLUMNA_NOMBRE
import com.example.pacdirecto.EsqueletoBaseDatos.EsqueletoBaseDatos.TABLE_NAME

class BaseDatos : AppCompatActivity() {

    lateinit var b_Ingreso:Button
    lateinit var b_Consulta:Button
    lateinit var t_Ciudad:EditText
    lateinit var t_nombre:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_datos)

        var mensaje = Toast.makeText(applicationContext,"Ingresa datos o consulta con el nombre de la persona a través de la ciudad", Toast.LENGTH_LONG)
        mensaje.setGravity(Gravity.CENTER,0,0)
        mensaje.show()


        var ayudante = Helper(this)

        b_Ingreso = findViewById(R.id.boton_ingreso)
        b_Consulta = findViewById(R.id.boton_consulta)
        t_Ciudad =  findViewById(R.id.ciudad_bases)
        t_nombre = findViewById(R.id.nombre_bases)







        //Ingresar datos
        b_Ingreso.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                val db = ayudante.writableDatabase

                val values = ContentValues().apply {
                    put(COLUMNA_CIUDAD, t_Ciudad.getText().toString())
                    put(COLUMNA_NOMBRE, t_nombre.getText().toString())
                }

                val newRowId = db?.insert(TABLE_NAME, null, values)
            }
        })






        //Consultar datos
        b_Consulta.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {

                val db = ayudante.readableDatabase

                val projection = arrayOf(COLUMNA_NOMBRE)

                val selection = "${COLUMNA_CIUDAD} = ?"
                val selectionArgs = arrayOf(t_Ciudad.getText().toString())

                val cursor = db.query(
                        TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        null
                )

                with(cursor) {
                    //Mientras que cursor siga teniendo datos, se adelantará una posición en el cursor
                    while (moveToNext()) {
                        t_nombre.setText(cursor.getString(0))
                    }//Termina bucle while

                }


            }

        })



    }









    fun atras(view: View?){
        onBackPressed()
    }
}