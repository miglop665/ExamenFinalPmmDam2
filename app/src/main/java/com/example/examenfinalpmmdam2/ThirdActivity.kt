package com.example.examenfinalpmmdam2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {
    private lateinit var txvVideojuego: TextView
    private lateinit var botonVolver: Button
    private lateinit var botonGuardar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        txvVideojuego = findViewById(R.id.txvvideojuego)
        botonVolver = findViewById(R.id.botonvolver)
        botonGuardar = findViewById(R.id.botonguardar)


        var db = DBManager(this)
        val videojuego = intent.getSerializableExtra("videojuego") as Videojuego
        txvVideojuego.text = videojuego.toString()

        botonVolver.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        botonGuardar.setOnClickListener {
            val intent = Intent(this,SaveActivity::class.java)
            db.escribir(videojuego)
            startActivity(intent)
        }
    }
}