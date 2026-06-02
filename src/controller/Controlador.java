package controller;

import db.Conexion;
import model.*;
import view.Menu;
import java.util.List;

public class Controlador {

    public static void crearNuevo() {
        String[] datos = Menu.pedirDatosPersonaje();
        String nombre  = datos[0];
        String clase   = datos[1];
        Personaje p;
        switch (clase) {
            case "1", "Guerrero", "guerrero" -> p = new Guerrero(nombre);
            case "2", "Mago",     "mago"     -> p = new Mago(nombre);
            case "3", "Arquero",  "arquero"  -> p = new Arquero(nombre);
            default -> { System.out.println("Clase invalida."); return; }
        }
        Conexion.crearPersonaje(p);
    }

    public static void listar() {
        Menu.mostrarPersonajes(Conexion.listarPersonajes());
    }

    public static void buscar() {
        String nombre = Menu.pedirString("Nombre a buscar: ");
        Menu.mostrarPersonaje(Conexion.buscarPorNombre(nombre));
    }

    public static void actualizar() {
        int id    = Menu.pedirInt("ID del personaje: ");
        int nivel = Menu.pedirInt("Nuevo nivel (1-50): ");
        if (id > 0 && nivel > 0) Conexion.actualizarNivel(id, nivel);
    }

    public static void eliminar() {
        int id = Menu.pedirInt("ID a eliminar: ");
        if (id > 0) Conexion.eliminarPersonaje(id);
    }

    public static void habilidad() {
        List<Personaje> personajes = Conexion.listarPersonajes();
        Menu.mostrarPersonajes(personajes);
        int id = Menu.pedirInt("ID del personaje: ");
        Personaje p = personajes.stream()
                .filter(x -> x.getId() == id)
                .findFirst().orElse(null);
        if (p != null) System.out.println(p.habilidadEspecial());
        else           System.out.println("ID no encontrado.");
    }
}