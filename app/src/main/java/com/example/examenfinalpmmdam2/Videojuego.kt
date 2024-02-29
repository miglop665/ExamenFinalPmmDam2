package com.example.examenfinalpmmdam2

import java.io.Serializable

class Videojuego(
    private var nombre:String,
    private var valoracion:Float,
    private var desarrolladora: String?,
    private var ano: Int?

):Serializable{

    fun getNombre():String{
        return nombre
    }
    fun getValoracion():Float{
        return valoracion
    }
    fun getDesarrolladora(): String? {
        return desarrolladora
    }
    fun getAno(): Int? {
        return ano
    }

    fun setDesarrolladora(desarrolladora: String) {
        this.desarrolladora = desarrolladora
    }

    fun setAno(ano: Int) {
        this.ano = ano
    }

    override fun toString(): String {
        return "Nombre: $nombre valoracion: $valoracion Desarrolladora: $desarrolladora Año: $ano"
    }
}