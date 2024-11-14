package com.example.ejercicioexamen.models

import android.app.Notification
import android.graphics.Color
import android.widget.Toast
import java.time.LocalDate

enum class Urgencia(val Color: Int) {
    ALTO(Color.RED), MEDIO(Color.parseColor("ORANGE")), BAJO(Color.GREEN)
}

class Tarea(
    nombre: String,
    completado: Boolean,
    var fechaLimite: LocalDate?,
    var urgencia: Urgencia,
    var notification: Notification?
) :
    Actividad(nombre, completado), Recordatorio {
    override fun programarRecordatorio() {
        //Toast.makeText(requireContext, "Mensajito" ,100)
    }

    override fun cancelarRecordatorio() {
        //Toast.makeText(requireContext, "Mensajito" ,100)
        notification = null
    }

    override fun mostrarDetalle(): String {
        return "Tarea(nombre=$nombre, completado=$completado,fechaLimite=$fechaLimite, urgencia=$urgencia, notification=$notification)"
    }

    inner class Notificacion(var fecha_hora: LocalDate) {

    }
}