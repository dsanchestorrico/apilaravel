package com.apilaravel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.apilaravel.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter:CancionAdapter
    private val cancionesList = mutableListOf<CancionData>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        // no defini el root al cambiar el binding LOL!!!!
        setContentView(binding.root)
        initRecyclerView()
        canciones()
    }

    private fun initRecyclerView() {
        Log.d("TEST","SUFFLE: "+ Arrays.toString(cancionesList.toTypedArray()))
        adapter = CancionAdapter(cancionesList)
        binding.rvCanciones.layoutManager = LinearLayoutManager(this)
        binding.rvCanciones.adapter = adapter
    }

    fun canciones(){
        CoroutineScope(Dispatchers.IO).launch {
            val can: Response<List<CancionData>>
            can = CancionObject.getCancion().create(CancionApi::class.java).obtenerCanciones()
            val objcancion = can.body()!!
            runOnUiThread{
                if(can.isSuccessful){
                    val clist = objcancion
                    cancionesList.clear()
                    cancionesList.addAll(clist)
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }
}