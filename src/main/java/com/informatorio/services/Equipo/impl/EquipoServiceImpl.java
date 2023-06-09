package com.informatorio.services.Equipo.impl;

import java.util.ArrayList;
import java.util.Iterator;
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

    @Override
    public void buscarJugador() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("INGRESE EL NOMBRE DEL JUGADOR: ");
        String jugadorNombre = scanner.next();
        System.out.print("INGRESE EL APELLIDO DEL JUGADOR: ");
        String jugadorApellido = scanner.next();
        System.out.print("INGRESE LA POSICION DEL JUGADOR: ");
        String jugadorPosicion = scanner.next();
        System.out.print("EL JUGADOR ES CAPITAN? (Y/N): ");
        String jugadorEsCapitanStr = scanner.next();
        boolean jugadorEsCapitan = Boolean.parseBoolean(jugadorEsCapitanStr);
        System.out.print("INGRESE EL EQUIPO DEL JUGADOR: ");
        String jugadorEquipo = scanner.next();

        Jugador jugadorEncontrado = null;
        for (Equipo equipo : equipos) {
            for (Jugador jugador : equipo.getJugadores()) {
                if (jugador.getNombre().equals(jugadorNombre) &&
                        jugador.getApellido().equals(jugadorApellido) &&
                        jugador.getPosicion().equals(jugadorPosicion) &&
                        jugador.getEsCapitan() == jugadorEsCapitan &&
                        jugador.getEquipo().getNombre().equals(jugadorEquipo)) {
                    jugadorEncontrado = jugador;
                    break;
                }
            }
            if (jugadorEncontrado != null) {
                break;
            }
        }

        // Verificar si se encontro el jugador
        if (jugadorEncontrado != null) {
            System.out.println("El jugador ha sido encontrado: \n" + jugadorEncontrado.toString());
        } else {
            System.out.println("No se encontró el jugador.");
        }
        scanner.close();

    }

    @Override
    public void buscarEquipo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("INGRESE EL NOMBRE DEL EQUIPO: ");
        String equipoNombre = scanner.next();
        System.out.print("INGRESE EL NOMBRE DEL ENTRENADOR: ");
        String equipoEntrenador = scanner.next();
        System.out.print("INGRESE EL NOMBRE DEL CAPITAN DEL EQUIPO");
        String equipoCapitan = scanner.next();

        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equalsIgnoreCase(equipoNombre)) {
                if (equipo.getEntrenador().getNombre().equalsIgnoreCase(equipoEntrenador)) {
                    for (Jugador jugador : jugadores) {
                        if (jugador.getEsCapitan() && jugador.getNombre().equalsIgnoreCase(equipoCapitan)) {
                            System.out.println(equipo.toString());
                        }
                    }
                }
            }
        }
        scanner.close();
    }

    @Override
    public void eliminarEquipo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("INGRESE EL NOMBRE DEL EQUIPO: ");
        String equipoNombre = scanner.next();
        scanner.close();
        Iterator<Equipo> iterator = equipos.iterator();
        while (iterator.hasNext()) {
            Equipo equipo = iterator.next();
            if (equipo.getNombre().equalsIgnoreCase(equipoNombre)) {
                iterator.remove();
                System.out.println("Equipo eliminado: " + equipo.getNombre());
                return;
            }
        }
        System.out.println("No se encontró ningún equipo con el nombre proporcionado.");

    }

}
