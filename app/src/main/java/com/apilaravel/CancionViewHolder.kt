package com.apilaravel

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.apilaravel.databinding.ItemBinding
import com.squareup.picasso.Picasso

class CancionViewHolder (val view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemBinding.bind(view)

    fun bind(cancion:CancionData){
        binding.tvArtista.text = cancion.artista
        binding.tvAlbum.text = cancion.album
        binding.tvTitle.text = cancion.titulo
    }
}

