package com.apilaravel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.apilaravel.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter:CancionAdapter
    private var cancionesList = mutableListOf<CancionData>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        canciones()
    }

    private fun initRecyclerView() {
        adapter = CancionAdapter(cancionesList)
        binding.rvCanciones.layoutManager = LinearLayoutManager(this)
        binding.rvCanciones.adapter = adapter
    }

    fun canciones(){
        //En esta parte se crea procesos en segundo plano debajo del proceso principal
        CoroutineScope(Dispatchers.IO).launch {
            val texto = findViewById<TextView>(R.id.textView01)
            val can: Response<List<CancionData>>
            can = CancionObject.getCancion().create(CancionApi::class.java).obtenerCanciones()
            val objcancion = can.body()!!
            //la informacion obtenida pase al primer plano
            runOnUiThread{
                if(can.isSuccessful){
                    //texto.text = "Artista: " + objcancion[6].artista
                    cancionesList = objcancion.toMutableList()
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }
}