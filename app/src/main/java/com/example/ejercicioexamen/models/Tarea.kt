package com.example.ejercicioexamen.models

import android.content.Context
import android.graphics.Color
import android.widget.Toast
import java.time.LocalDate
class Tarea(
    nombre: String,
    completado: Boolean,
    var fechaLimite: LocalDate?,
    var urgencia: Urgencia,
    var notificacion: Notificacion?
) :
    Actividad(nombre, completado), Recordatorio {

    // Enum para urgencia
    enum class Urgencia(val color: String) {
        ALTO("Rojo"),
        MEDIO("Naranja"),
        BAJO("Verde");

        fun obtenerColor(): String {
            return color
        }
    }

    override fun programarRecordatorio(context: Context) {
        notificacion!!.activo = true
        Toast.makeText(
            context,
            "Recordatorio preparado: ${notificacion!!.mostrarNotificacion()}",
            Toast.LENGTH_SHORT
        )
    }

    override fun cancelarRecordatorio(context: Context) {
        if (notificacion!!.activo) {
            Toast.makeText(
                context,
                "Cancelado el recordatorio: ${notificacion!!.mostrarNotificacion()}",
                Toast.LENGTH_SHORT
            )
        }
    }

    override fun mostrarDetalle(): String {
        return "Tarea(nombre=$nombre, completado=$completado,fechaLimite=$fechaLimite, urgencia=$urgencia, notification=$notificacion)"
    }

    inner class Notificacion(var fecha_hora: LocalDate, var activo: Boolean) {

        fun mostrarNotificacion(): String {
            return "la Tarea será el dia ${fecha_hora} que se encuentra en el estado $activo"
        }
    }
}