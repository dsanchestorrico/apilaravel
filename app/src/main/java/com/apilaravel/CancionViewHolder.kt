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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class CancionViewHolder (val view: View, val listener:IOnItemClickListener): RecyclerView.ViewHolder(view){

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

    fun bind(cancion:CancionData, position:Int){
        val cover = (0..7).random()
        binding.ivCover.setImageResource(listCovers[cover])
        binding.tvArtista.text = cancion.artista
        binding.tvTitle.text = cancion.titulo
        binding.mbRemove.setOnClickListener{
            listener.onItemClick(cancion, "delete", position)
        }

    }

    private fun showMessage(title: CharSequence) {
        Toast.makeText(this.view.context, title, Toast.LENGTH_SHORT).show()
    }
}

