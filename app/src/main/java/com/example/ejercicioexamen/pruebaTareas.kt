package com.example.ejercicioexamen

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.ejercicioexamen.models.Actividad
import com.example.ejercicioexamen.models.Cita
import com.example.ejercicioexamen.models.Pago
import com.example.ejercicioexamen.models.Persona
import com.example.ejercicioexamen.models.Tarea
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
fun main() {
    val persona = Persona("Ana", "1234679")
    val persona2 = Persona("Juan", "1234679")
    val persona3 = Persona("Me kagen", "1234679")
    val persona4 = Persona("TOO", "1234679")
    val personas = ArrayList<Persona>()
    personas.add(persona)
    personas.add(persona2)
    personas.add(persona3)

    val tarea1 = Tarea("Examen", false, LocalDate.now(), Tarea.Urgencia.BAJO, null)
    val tarea2 = Tarea("Examen2", true, LocalDate.now(), Tarea.Urgencia.MEDIO, null)
    val tarea3 = Tarea("Examen3", false, LocalDate.now(), Tarea.Urgencia.ALTO, null)

    val cita = Cita("Cita", false, LocalDate.now(), "mikasa", null)
    val cita2 = Cita("citadel", true, LocalDate.now(), "TUKASA", personas)

    val pago = Pago("PagatelaCuenta", false, 100.00, LocalDate.now(), "BIZUM")
    val pago2 = Pago("pagoElBus", true, 147.00, LocalDate.now(), "EFECTIVO")

    var actividades = ArrayList<Actividad>()
    actividades.add(tarea1)
    actividades.add(tarea2)
    actividades.add(tarea3)
    actividades.add(cita)
    actividades.add(cita2)
    actividades.add(pago)
    actividades.add(pago2)

    var pagos = ArrayList<Pago>()
    pagos.add(pago)
    pagos.add(pago2)

    val tareasUrgentes = actividades.filtrar { actividad ->
        actividad is Tarea && actividad.urgencia == Tarea.Urgencia.ALTO
    }

    val citasDeAna =
        actividades.filtrar { actividad -> actividad is Cita && actividad.personas?.contains(persona) ?: false }

    val pagosRealizados =
        actividades.filtrar { actividad -> actividad is Pago && actividad.completado }

    tareasUrgentes.forEach { actividad: Actividad ->
        println(actividad.mostrarDetalle())
    }

    citasDeAna.forEach { actividad -> println(actividad.mostrarDetalle()) }

    pagosRealizados.forEach { actividad -> println(actividad.mostrarDetalle()) }

    val totalPagosCompletados =
        pagos.calcularTotal { pago -> if (pago.completado) pago.cantidad else 0.0 }
    val totalPagos2024 = pagos.calcularTotal { pago ->
        if (pago.fecha_pago.isBefore(
                LocalDate.of(
                    2025,
                    1,
                    1
                )
            ) && pago.fecha_pago.isAfter(
                LocalDate.of(
                    2023,
                    12,
                    31
                )
            )
        ) pago.cantidad
        else 0.00
    }
    println(totalPagosCompletados)
println(totalPagos2024)

}