package com.example.ejercicioexamen

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var grupoRadios: RadioGroup
    private lateinit var crearTarea: RadioButton
    private lateinit var crearCita: RadioButton
    private lateinit var crearPago: RadioButton
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        grupoRadios = findViewById(R.id.radioGroup)
        crearTarea = findViewById(R.id.rbCrearTarea)
        crearCita = findViewById(R.id.rbCrearCita)
        crearPago = findViewById(R.id.rbCrearPago)
        tvResultado = findViewById(R.id.tvResultato)

        grupoRadios.setOnCheckedChangeListener { rg, idRadioButton ->
            val botonSeleccionado: RadioButton = findViewById(rg.checkedRadioButtonId)
            when (botonSeleccionado.text) {
                "Crear Tarea" -> {
                    var intencion = Intent(Intent(this, CreacionActivity::class.java))
                    startActivity(intencion)
                }

                "Crear Cita" -> {
                    tvResultado.text = "Crear una Cita"
                }

                "Crear Pago" -> {
                    tvResultado.text = "Crear un Pago"
                }

            }
        }
    }
}