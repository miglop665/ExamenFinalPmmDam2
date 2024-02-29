package com.example.examenfinalpmmdam2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var edtNombre: EditText
    private lateinit var edtValoracion: EditText
    private lateinit var botonSiguiente: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtNombre = findViewById(R.id.edtnombre)
        edtValoracion = findViewById(R.id.edtvaloracion)
        botonSiguiente = findViewById(R.id.botonsiguiente)


        botonSiguiente.setOnClickListener {
            if(!edtNombre.text.isNullOrBlank() && !edtValoracion.text.isNullOrBlank()){
                if(edtValoracion.text.toString().toFloat() >= 0.00){
                    val intent = Intent(this,SecondActivity::class.java)
                    intent.putExtra("videojuego", Videojuego(edtNombre.text.toString(),edtValoracion.text.toString().toFloat(),null,null))
                    startActivity(intent)
                }else{
                    Toast.makeText(this,"La valoracion no puede ser negativa", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"Introduzca todos los datos antes de continuar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}