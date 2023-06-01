package com.informatorio.domain;

public class Jugador extends Persona {
    private long dni;
    private int altura;
    private Posicion posicion;
    private int goles;
    private int partidosJugados;
    private boolean esCapitan;
    private int numeroCamiseta;
    private Equipo equipo;

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public boolean isEsCapitan() {
        return esCapitan;
    }

    public void setEsCapitan(boolean esCapitan) {
        this.esCapitan = esCapitan;
    }

    public int getNumeroCamiseta() {
        return numeroCamiseta;
    }

    public void setNumeroCamiseta(int numeroCamiseta) {
        this.numeroCamiseta = numeroCamiseta;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Jugador(String nombre, String apellido, long dni, int altura, String posicion, int goles, int partidosJugados, boolean esCapitan, int numeroCamiseta, Equipo equipo) {
        super(nombre, apellido);
        this.dni = dni;
        this.altura = altura;
        this.posicion = new Posicion(posicion);
        this.goles = goles;
        this.partidosJugados = partidosJugados;
        this.esCapitan = esCapitan;
        this.numeroCamiseta = numeroCamiseta;
        this.equipo = equipo;

    }

    public Jugador() {
        
    }
    
}
