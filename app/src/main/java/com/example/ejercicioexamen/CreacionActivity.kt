package com.example.ejercicioexamen

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDate

class CreacionActivity : AppCompatActivity() {
    private lateinit var titulo: TextView
    private lateinit var calendario: CalendarView
    private lateinit var btnCrear: Button
    private lateinit var fecha: LocalDate

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tipo = intent.extras?.getString("tipo")
        setContentView(R.layout.creacion_layout)
        titulo = findViewById(R.id.titulo)
        titulo.text = "Crear $tipo"
        if (tipo.equals("Tarea")) {
            calendario = findViewById(R.id.cvCalendario)
            calendario.visibility= View.VISIBLE
            btnCrear = findViewById(R.id.crear)
            btnCrear.text = titulo.text

        }
        /*
        btnCrear.setOnClickListener {
            //Toast.makeText(this, fecha.date.toString(), Toast.LENGTH_SHORT)
            fecha.setOnClickListener{
                titulo.text = fecha.
            }

        }
        */
        calendario.setOnDateChangeListener { view, year, month, dayOfMonth ->
            fecha = LocalDate.of(year, month, dayOfMonth)
        }
        btnCrear.setOnClickListener {
            //titulo.text=fecha.toString()
        }

    }
}