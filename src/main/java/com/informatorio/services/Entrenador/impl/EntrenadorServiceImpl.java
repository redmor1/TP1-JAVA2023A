package com.informatorio.services.Entrenador.impl;

import java.util.Scanner;

import com.informatorio.domain.Entrenador;
import com.informatorio.services.Entrenador.EntrenadorService;

public class EntrenadorServiceImpl implements EntrenadorService {

    @Override
    public Entrenador crearEntrenador() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("INGRESE EL NOMBRE DEL ENTRENADOR: ");
        String entrenadorNombre = scanner.next();

        System.out.print("INGRESE EL APELLIDO DEL ENTRENADOR: ");
        String entrenadorApellido = scanner.next();

        System.out.print("INGRESE LA EDAD DEL ENTRENADOR: ");
        int entrenadorEdad = Integer.parseInt(scanner.next());

        Entrenador entrenador = new Entrenador(entrenadorNombre, entrenadorApellido, entrenadorEdad);

        scanner.close();
        return entrenador;
    }
    
}
