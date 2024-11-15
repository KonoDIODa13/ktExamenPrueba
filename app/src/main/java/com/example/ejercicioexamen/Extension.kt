package com.example.ejercicioexamen

import com.example.ejercicioexamen.models.Actividad


fun ArrayList<Actividad>.filtrar(filtro: (Actividad) -> Boolean): ArrayList<Actividad> {
    return this.filter(filtro) as ArrayList<Actividad>
}

