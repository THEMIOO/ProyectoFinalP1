package com.itla.app;

import com.itla.controller.ContactoController;
import com.itla.db.DBManager;
import com.itla.vista.ContactoVista;
import com.sun.jdi.connect.spi.Connection;
//import com.itla.vista.ContactoVista;


public class App {
    public static void main(String[] args) {

        // Inicializar la vista
        ContactoVista vista = new ContactoVista();

        // Inicializar el controlador con la vista y la conexión
        ContactoController controller = new ContactoController(vista);

        // Mostrar la ventana principal
        vista.setVisible(true);
    }
}
