package com.informatorio.services.Equipo.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.informatorio.domain.Entrenador;
import com.informatorio.domain.Equipo;
import com.informatorio.domain.Jugador;
import com.informatorio.services.Entrenador.EntrenadorService;
import com.informatorio.services.Entrenador.impl.EntrenadorServiceImpl;
import com.informatorio.services.Equipo.EquipoService;
import com.informatorio.services.Jugador.JugadorService;
import com.informatorio.services.Jugador.impl.JugadorServiceImpl;

public class EquipoServiceImpl implements EquipoService {

    private static List<Jugador> jugadores = new ArrayList<>();
    private static List<Equipo> equipos = new ArrayList<>();
    private static EntrenadorService entrenadorService = new EntrenadorServiceImpl();
    private static JugadorService jugadorService = new JugadorServiceImpl();

    @Override
    public void crearEquipo() {
        Scanner scanner = new Scanner(System.in);

        boolean crearEquipo = true;

        while (crearEquipo) {

            // Creacion de Equipo
            System.out.print("INGRESE EL NOMBRE DEL EQUIPO: ");
            String equipoNombre = scanner.next();

            System.out.print("INGRESE LA FECHA DE CREACION DEL EQUIPO: ");
            String equipoFechaCreacion = scanner.next();

            // Creacion de Entrenador
            Entrenador entrenador = entrenadorService.crearEntrenador();
            Equipo equipo = new Equipo(equipoNombre, equipoFechaCreacion, entrenador);

            boolean crearJugador = true;

            // Creacion de jugadores
            while (crearJugador) {
                Jugador jugador = jugadorService.crearJugador(equipo);
                jugadores.add(jugador);
                System.out.print("DESEA CREAR MAS JUGADORES? (Y/N): ");
                String respuesta = scanner.next();
                if (respuesta.equalsIgnoreCase("Y")) {
                    System.out.println("///////////////////////");
                    continue;
                } else {
                    break;
                }
            }

            // Agregar lista de jugadores al Equipo
            equipo.setJugadores(jugadores);

            // Agregar Equipo a la lista de equipos
            equipos.add(equipo);

            System.out.println("DESEA CREAR MAS EQUIPOS? (Y/N): ");
            String respuesta = scanner.next();
            if (respuesta.equalsIgnoreCase("Y")) {
                System.out.println("///////////////////////");
                continue;
            } else {
                break;
            }

        }
        scanner.close();
    }
}
