package com.apilaravel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.apilaravel.databinding.ActivityDetalleCancionBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class DetalleCancionActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetalleCancionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleCancionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveCancionButton.setOnClickListener {
            onClickSaveCancion()
        }
    }

    private fun onClickSaveCancion() {
        val cancion: CancionData = CancionData(
            titulo = binding.tituloEditText.text.toString(),
            artista = binding.artistaEditText.text.toString(),
            album = binding.albumEditText.text.toString(),
            year = binding.yearEditText.text.toString(),
            genero = binding.generoEditText.text.toString(),
            formato = binding.formatoEditText.text.toString(),
            image = binding.imagenEditText.text.toString(),
            duracion = binding.duracionEditText.text.toString()
        )

        binding.progressbar.visibility = View.VISIBLE
        CoroutineScope(Dispatchers.IO).launch {
            val response: Response<Void> =
                CancionObject.ApiAdapter().saveCancion(cancion)

            // pasa el proceso al primer plano
            runOnUiThread {
                binding.progressbar.visibility = View.GONE

                if (response.isSuccessful) {
                    Toast.makeText(
                        this@DetalleCancionActivity,
                        "Guardado correctamente",
                        Toast.LENGTH_SHORT
                    ).show()
                    onBackPressed()
                }
            }
        }

    }
}