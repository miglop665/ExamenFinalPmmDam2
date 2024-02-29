package com.example.examenfinalpmmdam2

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

// Clase DatabaseHelper
class DBManager (context: Context) : SQLiteOpenHelper(context, DATABASE, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE = "videojuegos.db"
        private const val TABLA_NAME = "Videojuegos"
        private const val KEY_ID = "_Id"
        private const val COLUMN_NOMBRE = "nombre"
        private const val COLUMN_VALORACION = "valoracion"
        private const val COLUMN_DESARROLLADORA = "desarrolladora"
        private const val COLUMN_ANO= "año"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = "CREATE TABLE $TABLA_NAME ($KEY_ID INTEGER PRIMARY KEY, $COLUMN_NOMBRE TEXT, $COLUMN_VALORACION NUMBER, $COLUMN_DESARROLLADORA TEXT,$COLUMN_ANO INTEGER)"
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLA_NAME")
        onCreate(db)
    }

    fun escribir(videojuego: Videojuego):Long{
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NOMBRE, videojuego.getNombre())
            put(COLUMN_VALORACION,videojuego.getValoracion())
            put(COLUMN_DESARROLLADORA, videojuego.getDesarrolladora())
            put(COLUMN_ANO, videojuego.getAno())
        }
        val id= db.insert(TABLA_NAME, null, values)
        db.close()
        return id
    }


    @SuppressLint("Range")
    fun lectura(): ArrayList<Videojuego> {
        val lectura = ArrayList<Videojuego>()
        val selectQuery = "SELECT * FROM $TABLA_NAME"
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor.moveToFirst()) {
            do {
                val nombre = cursor.getString(cursor.getColumnIndex(COLUMN_NOMBRE))
                val valoracion = cursor.getFloat(cursor.getColumnIndex(COLUMN_VALORACION))
                val desarrolladora = cursor.getString(cursor.getColumnIndex(COLUMN_DESARROLLADORA))
                val ano = cursor.getInt(cursor.getColumnIndex(COLUMN_ANO))
                var videojuego = Videojuego(nombre,valoracion,desarrolladora,ano)
                lectura.add(videojuego)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return lectura
    }

}
