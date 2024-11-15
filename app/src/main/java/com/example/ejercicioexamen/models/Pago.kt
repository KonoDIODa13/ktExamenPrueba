package com.example.ejercicioexamen.models

import android.content.Context
import android.widget.Toast
import java.time.LocalDate

class Pago(
    nombre: String,
    completado: Boolean,
    var cantidad: Double,
    var fecha_pago: LocalDate,
    var metodoPago: String
) : Actividad(nombre, completado) {

    fun procesarPago(context: Context) {
        this.marcarComoCompletada()
        Toast.makeText(context, "Pago realizado con éxito", Toast.LENGTH_SHORT)
    }

    override fun mostrarDetalle(): String {
        return "Pago(nombre=$nombre, completado=$completado, cantidad=$cantidad, fecha_pago=$fecha_pago, metodoPago=$metodoPago)"
    }


}