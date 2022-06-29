package com.apilaravel

import android.content.DialogInterface
import android.content.Intent
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.apilaravel.databinding.ItemBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class CancionViewHolder (val view: View, val listener:IOnItemClickListener): RecyclerView.ViewHolder(view){

    private val binding = ItemBinding.bind(view)

    var listCovers = listOf<Int>(
        R.drawable.c00,
        R.drawable.c01,
        R.drawable.c02,
        R.drawable.c03,
        R.drawable.c04,
        R.drawable.c05,
        R.drawable.c06,
        R.drawable.c07,
        R.drawable.c08,
    )

    fun bind(cancion:CancionData, position:Int){
        val cover = (0..7).random()
        val urlImage = "https://los40.com/los40/imagenes/2017/04/06/album/1491501684_617106_1491503106_album_normal.jpg"
        //binding.ivCover.setImageResource(listCovers[0])
        Picasso.get().load(urlImage).into(binding.ivCover)
        binding.tvArtista.text = cancion.artista
        binding.tvTitle.text = cancion.titulo
        binding.mbRemove.setOnClickListener{
            listener.onItemClick(cancion, "delete", position)
        }
        binding.mbEdit.setOnClickListener{
            listener.onItemClick(cancion, "edit", position)
        }

    }

    private fun showMessage(title: CharSequence) {
        Toast.makeText(this.view.context, title, Toast.LENGTH_SHORT).show()
    }
}

