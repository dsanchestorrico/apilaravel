package com.apilaravel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CancionAdapter(val canciones:List<CancionData>): RecyclerView.Adapter<CancionViewHolder>() {
    private lateinit var myListener:IOnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CancionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CancionViewHolder(layoutInflater.inflate(R.layout.item, parent, false), myListener)
    }

    override fun onBindViewHolder(holder: CancionViewHolder, position: Int) {
        val item = canciones[position]
        holder.bind(item,position)
    }

    override fun getItemCount(): Int  = canciones.size

    fun setOnClickListener(listener: IOnItemClickListener){
        myListener = listener
    }

}