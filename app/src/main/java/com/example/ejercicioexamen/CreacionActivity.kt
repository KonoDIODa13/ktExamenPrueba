package com.example.ejercicioexamen

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicioexamen.models.Actividad
import com.example.ejercicioexamen.models.Tarea
import java.time.LocalDate

class CreacionActivity : AppCompatActivity() {
    private lateinit var titulo: TextView
    private lateinit var nombre: EditText
    private lateinit var rgCompletado: RadioGroup
    private lateinit var calendario: CalendarView
    private lateinit var fecha: LocalDate
    private lateinit var rgUrgencia: RadioGroup
    private lateinit var rgNotificacion: RadioGroup
    private lateinit var btnCrear: Button

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tipo = intent.extras?.getString("tipo")
        var completado: Boolean = false
        var urgencia: Tarea.Urgencia = Tarea.Urgencia.BAJO
        var notificacion = null;
        setContentView(R.layout.creacion_layout)
        titulo = findViewById(R.id.titulo)
        titulo.text = "Crear $tipo"
        calendario = findViewById(R.id.cvCalendario)
        rgCompletado.setOnCheckedChangeListener { rg, checkedId ->
            var radio: RadioButton = findViewById(rg.checkedRadioButtonId)
            when (radio.text) {
                "Si Completado" -> completado = true
                "No Completado" -> completado = false
            }
        }
        calendario.setOnDateChangeListener { view, year, month, dayOfMonth ->
            fecha = LocalDate.of(year, month, dayOfMonth)
        }
        if (tipo.equals("Tarea")) {
            rgUrgencia.visibility = View.VISIBLE
            rgNotificacion.visibility = View.VISIBLE
            btnCrear = findViewById(R.id.crear)
            btnCrear.text = titulo.text
            rgUrgencia.setOnCheckedChangeListener { rg, checkedId ->
                var radio: RadioButton = findViewById(rg.checkedRadioButtonId)
                when (radio.text) {
                    "BAJO" -> urgencia = Tarea.Urgencia.BAJO
                    "MEDIA" -> urgencia = Tarea.Urgencia.MEDIO
                    "ALTA" -> urgencia = Tarea.Urgencia.ALTO
                }
            }
        }
        btnCrear.setOnClickListener {
            val arrTareaString = ArrayList<String>()
            arrTareaString.add(nombre.text.toString())
            arrTareaString.add(fecha.toString())
            var tarea: Tarea = Tarea(nombre.text.toString(), completado, fecha, urgencia, null)
            var intencion = Intent(Intent(this, CreacionActivity::class.java))
            startActivity(intencion)
        }

    }
}