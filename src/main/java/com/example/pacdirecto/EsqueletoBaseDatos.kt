package com.example.pacdirecto

import android.provider.BaseColumns

class EsqueletoBaseDatos {

    object EsqueletoBaseDatos : BaseColumns {
        const val TABLE_NAME = "Coches"
        const val COLUMNA_CIUDAD = "Ciudad"
        const val COLUMNA_NOMBRE = "Nombre"


    const val SQL_CREATE_ENTRIES =
         "CREATE TABLE ${EsqueletoBaseDatos.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${EsqueletoBaseDatos.COLUMNA_CIUDAD} TEXT," +
                "${EsqueletoBaseDatos.COLUMNA_NOMBRE} TEXT)"

        const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${EsqueletoBaseDatos.TABLE_NAME}"
    }
}