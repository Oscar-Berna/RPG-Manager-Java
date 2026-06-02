import controller.Controlador;
import view.Menu;

public class Principal {

    public static void main(String[] args) {

        while (true) {
            Menu.mostrarMenu();
            String opcion = Menu.pedirOpcion();

            switch (opcion) {
                case "1" -> Controlador.crearNuevo();
                case "2" -> Controlador.listar();
                case "3" -> Controlador.buscar();
                case "4" -> Controlador.actualizar();
                case "5" -> Controlador.eliminar();
                case "6" -> Controlador.habilidad();
                case "0" -> { System.out.println("Hasta luego!"); return; }
                default  -> System.out.println("Opcion invalida.");
            }
        }
    }
}