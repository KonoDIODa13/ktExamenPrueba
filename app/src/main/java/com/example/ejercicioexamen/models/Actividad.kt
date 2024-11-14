package com.example.ejercicioexamen.models

abstract class Actividad(var nombre: String, var completado: Boolean = false) {
    fun marcarComoCompletada() {
        completado = true;
    }

    abstract fun mostrarDetalle(): String
}