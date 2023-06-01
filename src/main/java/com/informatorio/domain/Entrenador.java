package com.informatorio.domain;

public class Entrenador extends Persona {
    private int edad;

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }



    public Entrenador() {
        
    }

    public Entrenador(String nombre, String apellido, int edad) {
        super(nombre, apellido);
        this.edad = edad;
    }


}
