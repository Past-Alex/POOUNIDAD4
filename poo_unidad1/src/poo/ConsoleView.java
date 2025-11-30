package poo;

import uni1a.ContenidoAudiovisual;
import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("\n--- Sistema de Contenido Audiovisual ---");
        System.out.println("1. Cargar datos desde archivos");
        System.out.println("2. Guardar datos a archivos");
        System.out.println("3. Mostrar todos los contenidos");
        System.out.println("0. Salir");
    }

    public int getUserChoice() {
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public void displayContents(List<ContenidoAudiovisual> contents) {
        System.out.println("\n--- Lista de Contenidos ---");
        if (contents.isEmpty()) {
            System.out.println("No hay contenidos para mostrar.");
            return;
        }
        for (ContenidoAudiovisual contenido : contents) {
            System.out.println(contenido.mostrarDetalles());
            System.out.println("---------------------------------");
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
