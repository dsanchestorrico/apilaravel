package com.apilaravel

interface IOnItemClickListener {
    fun onItemClick(cancionData: CancionData, accion: String, position:Int)
}