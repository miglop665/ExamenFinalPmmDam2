package com.example.examenfinalpmmdam2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    private lateinit var edtDesarrolladora: EditText
    private lateinit var edtAno: EditText
    private lateinit var botonSiguiente: Button
    private lateinit var botonVolver: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        edtDesarrolladora = findViewById(R.id.edtdesarrolladora)
        edtAno = findViewById(R.id.edtaño)
        botonSiguiente = findViewById(R.id.botonsiguiente)
        botonVolver = findViewById(R.id.botonvolver)


        botonSiguiente.setOnClickListener {
            if(!edtDesarrolladora.text.isNullOrBlank() && !edtAno.text.isNullOrBlank()){
                if(edtAno.text.toString().toInt() in 1900..2024){
                    val intent = Intent(this,ThirdActivity::class.java)
                    val videojuego = intent.getSerializableExtra("videojuego") as Videojuego
                    videojuego.setDesarrolladora(edtDesarrolladora.text.toString())
                    videojuego.setAno(edtAno.text.toString().toInt())
                    if(!videojuego.getNombre().isNullOrBlank() && !videojuego.getValoracion().toString().isNullOrBlank() && !videojuego.getDesarrolladora().isNullOrBlank() && !videojuego.getAno().toString().isNullOrBlank()){
                        intent.putExtra("videojuego", videojuego)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this,"Error inesperado", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(this,"El año no debe estar comprendido entre 1900 y 2024", Toast.LENGTH_SHORT).show()
                }

            }else{
                Toast.makeText(this,"Introduzca todos los datos antes de continuar", Toast.LENGTH_SHORT).show()
            }
        }
        botonVolver.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

        }
    }
}