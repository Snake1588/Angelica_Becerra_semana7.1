package com.angelica_becerra_semana71

import android.app.Activity
import android.content.Context
import android.os.AsyncTask
import android.widget.ListView
import android.widget.Toast
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class FetchFeriadosTask(private val context: Context) : AsyncTask<Void, Void, List<Feriado>>() {

    override fun doInBackground(vararg params: Void?): List<Feriado>? {
        try {
            val url = URL("https://apis.digital.gob.cl/fl/feriados/2024")
            val connection = url.openConnection() as HttpURLConnection
            connection.inputStream.use { inputStream ->
                val reader = BufferedReader(InputStreamReader(inputStream))
                return Gson().fromJson(reader, Array<Feriado>::class.java).toList()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    override fun onPostExecute(result: List<Feriado>?) {
        super.onPostExecute(result)
        if (result != null) {
            val listView = (context as Activity).findViewById<ListView>(R.id.feriados_list_view)
            val adapter = FeriadoAdapter(context, result)
            listView.adapter = adapter
        } else {
            Toast.makeText(context, "Error al obtener datos de la API", Toast.LENGTH_SHORT).show()
        }
    }
}
