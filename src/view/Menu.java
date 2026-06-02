package view;

import model.Personaje;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private static final Scanner sc = new Scanner(System.in);

    public static void mostrarMenu() {
        System.out.println("\n========== RPG MANAGER ==========");
        System.out.println("1. Crear personaje");
        System.out.println("2. Listar personajes");
        System.out.println("3. Buscar personaje por nombre");
        System.out.println("4. Actualizar nivel");
        System.out.println("5. Eliminar personaje");
        System.out.println("6. Ver habilidad especial");
        System.out.println("0. Salir");
        System.out.println("==================================");
    }

    public static void mostrarPersonajes(List<Personaje> personajes) {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes registrados.");
            return;
        }
        System.out.println("\n--- PERSONAJES ---");
        for (Personaje p : personajes) {
            System.out.println("ID:" + p.getId() + " | " + p);
        }
    }

    public static void mostrarPersonaje(Personaje p) {
        if (p != null) System.out.println("\nEncontrado: " + p);
        else           System.out.println("Personaje no encontrado.");
    }

    public static String pedirOpcion() {
        System.out.print("\nElige una opcion: ");
        return sc.nextLine().trim();
    }

    public static String[] pedirDatosPersonaje() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine().trim();
        System.out.println("Clases: 1-Guerrero  2-Mago  3-Arquero");
        System.out.print("Clase (numero o nombre): ");
        String clase = sc.nextLine().trim();
        return new String[]{nombre, clase};
    }

    public static int pedirInt(String mensaje) {
        System.out.print(mensaje);
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Error: ingresa un numero valido.");
            return -1;
        }
    }

    public static String pedirString(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine().trim();
    }
}