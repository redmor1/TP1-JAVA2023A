package com.informatorio.services.Menu.impl;

import java.util.Scanner;

import com.informatorio.services.Equipo.EquipoService;
import com.informatorio.services.Equipo.impl.EquipoServiceImpl;
import com.informatorio.services.Menu.MenuService;

public class MenuServiceImpl implements MenuService {
    @Override
    public void Inicio() {
        Scanner scanner = new Scanner(System.in);
        final EquipoService equipoService = new EquipoServiceImpl();

        boolean bucle = true;

        while (bucle) {

            System.out.println("Bienvenido a la aplicacion fut5app");
            System.out.println("1. Crear equipo");
            System.out.println("2. Buscar un jugador por nombre");
            System.out.println("3. Buscar un equipo por su nombre");
            System.out.println("4. Eliminar un equipo");
            System.out.println("5. Importar lista de jugadores de un Equipo desde un archivo");
            System.out.println("6. Exportar lista de jugadores de un Equipo a un archivo");
            System.out.println("7. Salir");
            System.out.print("Ingrese una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    equipoService.crearEquipo();
                    break;
                case 2:
                    equipoService.buscarJugador();
                    break;
                case 3:
                    equipoService.buscarEquipo();
                    break;
                case 4:
                    equipoService.eliminarEquipo();
                    break;
            }
        }
    }
}
