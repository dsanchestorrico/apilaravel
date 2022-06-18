package com.apilaravel

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

//una interfaz no crea instancias muy similar a una clase abstracta, es como una plantilla

interface CancionApi {
    @GET("api/cancion")
    suspend fun obtenerCanciones(): Response<List<CancionData>>


    @POST("api/cancion")
    suspend fun saveCancion(@Body cancion: CancionData): Response<Void>
    //suspend esta muy relacionada con las coroutine (2  procesos en ejecucion paralelamente)
    //suspend esta funcion se va a ejecutar en un hilo separado
}
