package com.apilaravel

data class CancionData(
    val id:Int,
    val archivo:String,
    val artista:String,
    val titulo:String,
    val album:String,
    val year:String,
    val formato:String,
    val genero:String,
    val image:String,
    val duracion:String,
    val numero_reproduccion:String,
    val created_at:String,
    val updated_at:String,
)
