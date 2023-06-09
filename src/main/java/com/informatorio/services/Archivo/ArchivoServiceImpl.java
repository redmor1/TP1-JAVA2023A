package com.informatorio.services.Archivo;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.informatorio.domain.Equipo;
import com.informatorio.domain.Jugador;
import com.informatorio.services.Archivo.impl.ArchivoService;
import com.informatorio.services.Entrenador.EntrenadorService;
import com.informatorio.services.Entrenador.impl.EntrenadorServiceImpl;
import com.informatorio.services.Equipo.EquipoService;
import com.informatorio.services.Equipo.impl.EquipoServiceImpl;

public class ArchivoServiceImpl implements ArchivoService {

    private EquipoService equipoService = new EquipoServiceImpl();
    private EntrenadorService entrenadorService = new EntrenadorServiceImpl();

    @Override
    public void importarListaJugadores() {
        List<Jugador> jugadores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese nombre del archivo: ");
        String nombreArchivo = scanner.nextLine();

        // Crea nuevo Equipo y lo añade a la lista de los equipos
        System.out.print("INGRESE NOMBRE DEL EQUIPO: ");
        String equipoNombre = scanner.nextLine();
        Equipo equipo = new Equipo();
        equipo.setEntrenador(entrenadorService.crearEntrenador());
        equipo.setNombre(equipoNombre);

        try (BufferedReader br = new BufferedReader(
                new FileReader("src/main/java/com/informatorio/resources/" + (nombreArchivo)))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Procesar cada línea del archivo
                String[] datos = linea.split(",");

                String nombre = datos[0];
                String apellido = datos[1];
                long dni = Long.parseLong(datos[2]);
                String altura = datos[3];
                String posicion = datos[4];
                int goles = Integer.parseInt(datos[5]);
                int partidosJugados = Integer.parseInt(datos[6]);
                boolean esCapitan = Boolean.parseBoolean(datos[7]);
                int numeroCamiseta = Integer.parseInt(datos[8]);

                Jugador jugador = new Jugador(nombre, apellido, dni, altura, posicion, goles, partidosJugados,
                        esCapitan, numeroCamiseta, equipo);

                jugadores.add(jugador);
                equipo.setJugadores(jugadores);
                System.out.print(jugador);

            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        // equipo.setJugadores(jugadores);
        equipoService.agregarEquipoALista(equipo);
    }
}
