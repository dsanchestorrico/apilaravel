package com.apilaravel

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.apilaravel.databinding.ItemBinding
import com.squareup.picasso.Picasso
import kotlin.random.Random

class CancionViewHolder (val view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemBinding.bind(view)

    var listCovers = listOf<Int>(
        R.drawable.c01,
        R.drawable.c02,
        R.drawable.c03,
        R.drawable.c04,
        R.drawable.c05,
        R.drawable.c06,
        R.drawable.c07,
        R.drawable.c08,
    )


    fun bind(cancion:CancionData){
        val cover = (0..7).random()
        binding.ivCover.setImageResource(listCovers[cover])
        binding.tvArtista.text = cancion.artista
        binding.tvTitle.text = cancion.titulo
    }
}