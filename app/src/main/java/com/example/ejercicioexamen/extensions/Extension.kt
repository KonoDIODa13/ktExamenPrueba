package com.example.ejercicioexamen.extensions

import android.content.Intent
import com.example.ejercicioexamen.models.Actividad
import com.example.ejercicioexamen.models.Pago


fun ArrayList<Actividad>.filtrar(filtro: (Actividad) -> Boolean): ArrayList<Actividad> {
    return this.filter(filtro) as ArrayList<Actividad>
}

fun ArrayList<Pago>.calcularTotal(criterio: (Pago) -> Double): Double {
    return this.sumOf(criterio)
}

