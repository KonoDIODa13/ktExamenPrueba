package com.example.ejercicioexamen.models

import java.time.LocalDate

class Cita(
    nombre: String,
    completado: Boolean,
    var fecha_hora: LocalDate,
    var lugar: String,
    val personas: ArrayList<Persona>?
) : Actividad(nombre, completado) {

    fun agregarPersonaCita(persona: Persona) {
        personas!!.add(persona)
    }

    override fun mostrarDetalle(): String {
        return "Cita(nombre=$nombre, completado=$completado, fecha_hora=$fecha_hora, lugar='$lugar', personas=$personas)"
    }

}