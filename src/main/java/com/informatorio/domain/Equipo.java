package com.informatorio.domain;

import java.util.List;
import java.time.LocalDate;

public class Equipo {
    private String nombre;
    private List<Jugador> jugadores;
    private LocalDate fechaCreacion;
    private Entrenador entrenador;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public Equipo() {

    }

    public Equipo(String nombre, List<Jugador> jugadores, LocalDate fechaCreacion, Entrenador entrenador) {
        this.nombre = nombre;
        this.jugadores = jugadores;
        this.fechaCreacion = fechaCreacion;
        this.entrenador = entrenador;
    }
}
