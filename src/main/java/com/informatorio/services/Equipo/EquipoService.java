package com.informatorio.services.Equipo;

import com.informatorio.domain.Equipo;

public interface EquipoService {

    public void crearEquipo();

    public void buscarJugador();

    public void buscarEquipoYImprimir();

    public Equipo buscarEquipo();

    public void eliminarEquipo();

    public void agregarEquipoALista(Equipo equipo);

}
