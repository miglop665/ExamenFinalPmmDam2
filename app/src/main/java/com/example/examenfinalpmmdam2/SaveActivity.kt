package com.example.examenfinalpmmdam2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SaveActivity : AppCompatActivity() {
    private lateinit var txvVideojuegos: TextView
    private lateinit var botonVolver: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)

        txvVideojuegos = findViewById(R.id.txvvideojuegos)
        botonVolver = findViewById(R.id.botonvolver)

        var db = DBManager(this)

        var videojuegos = db.lectura()
        var listaVideojuegos:String =""
        for (videojuego in videojuegos){
            listaVideojuegos += videojuego.toString() +"\n"
        }
        txvVideojuegos.text = listaVideojuegos

        botonVolver.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}
