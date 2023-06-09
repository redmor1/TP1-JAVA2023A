package com.informatorio.services.Jugador.impl;

import java.util.Scanner;

import com.informatorio.domain.Equipo;
import com.informatorio.domain.Jugador;
import com.informatorio.services.Jugador.JugadorService;

public class JugadorServiceImpl implements JugadorService {

    @Override
    public Jugador crearJugador(Equipo equipo) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("////////////////////");
        System.out.println("CREAR JUGADOR");
        System.out.println("////////////////////");
        System.out.print("INGRESE EL DNI: ");
        long jugadorDni = scanner.nextLong();

        System.out.print("INGRESE EL NOMBRE: ");
        String jugadorNombre = scanner.next();

        System.out.print("INGRESE EL APELLIDO: ");
        String jugadorApellido = scanner.next();

        System.out.print("INGRESE EL ALTURA: ");
        String jugadorAltura = scanner.next();

        System.out.print("INGRESE EL POSICION (Arquero/Defensor/Mediocampista/Delantero): ");
        String jugadorPosicion = scanner.next();

        System.out.print("INGRESE CANTIDAD DE GOLES: ");
        int jugadorGoles = Integer.parseInt(scanner.next());

        System.out.print("INGRESE CANTIDAD DE PARTIDOS JUGADOS: ");
        int jugadorPartidosJugados = Integer.parseInt(scanner.next());

        System.out.print("ES CAPITAN? (true/false): ");
        String jugadorEsCapitanStr = scanner.next();
        boolean jugadorEsCapitan = Boolean.parseBoolean(jugadorEsCapitanStr);

        System.out.print("INGRESE SU NUMERO DE CAMISETA: ");
        int jugadorNumeroCamiseta = Integer.parseInt(scanner.next());

        Jugador jugador = new Jugador(jugadorNombre, jugadorApellido, jugadorDni, jugadorAltura, jugadorPosicion,
                jugadorGoles, jugadorPartidosJugados, jugadorEsCapitan, jugadorNumeroCamiseta, equipo);

        System.out.println("///////////////////////");

        System.out.println("JUGADOR CREADO EXITOSAMENTE");

        System.out.println("///////////////////////");

        return jugador;

    }

}
