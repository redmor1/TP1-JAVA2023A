package com.informatorio;

import com.informatorio.services.Menu.MenuService;
import com.informatorio.services.Menu.impl.MenuServiceImpl;

public class App {
    public static void main(String[] args) {
        final MenuService menuService = new MenuServiceImpl();

        menuService.Inicio();

    }
}
