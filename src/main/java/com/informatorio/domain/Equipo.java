package com.informatorio.domain;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String nombre;
    private List<Jugador> jugadores = new ArrayList<>();
    private String fechaCreacion;
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

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
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

    public Equipo(String nombre, String fechaCreacion, Entrenador entrenador) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
        this.fechaCreacion = fechaCreacion;
        this.entrenador = entrenador;
    }

    @Override
    public String toString() {
        String str = "Equipo: " + getNombre() + "\n";
        str += "Entrenador: " + getEntrenador().getNombre() + " " + getEntrenador().getApellido() + "\n";
        str += "Jugadores: " + "\n";
        for (Jugador jugador : jugadores) {
            str += jugador.getNumeroCamiseta() + " | " + jugador.getNombre() + " " + jugador.getApellido() + " | "
                    + jugador.getPosicion()
                    + "\n";
        }
        return str;
    }
}
