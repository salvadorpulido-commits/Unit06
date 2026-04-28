package ejercicios.ficheros;

import java.io.*;
import java.util.*;

public class Ejercicio7 {
    private static final String RUTA = "src/archivos_txt/agenda.txt";
    private static final int MAX_CONTACTOS = 20;
    private static TreeMap<String, String> agenda = new TreeMap<>();

    public static void main(String[] args) {
        cargarDatos();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n--- AGENDA ---");
            System.out.println("1. Nuevo contacto");
            System.out.println("2. Buscar por nombre");
            System.out.println("3. Mostrar todos");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> nuevoContacto(sc);
                case 2 -> buscarContacto(sc);
                case 3 -> mostrarAgenda();
                case 4 -> guardarDatos();
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    private static void nuevoContacto(Scanner sc) {
        if (agenda.size() >= MAX_CONTACTOS) {
            System.out.println("Error: Agenda llena.");
            return;
        }
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        if (agenda.containsKey(nombre)) {
            System.out.println("El nombre ya existe.");
        } else {
            System.out.print("Teléfono: ");
            String telf = sc.nextLine();
            agenda.put(nombre, telf);
            System.out.println("Añadido.");
        }
    }

    private static void buscarContacto(Scanner sc) {
        System.out.print("Nombre a buscar: ");
        String nombre = sc.nextLine();
        if (agenda.containsKey(nombre)) {
            System.out.println("Teléfono: " + agenda.get(nombre));
        } else {
            System.out.println("No encontrado.");
        }
    }

    private static void mostrarAgenda() {
        if (agenda.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            agenda.forEach((nom, tel) -> System.out.println(nom + " - " + tel));
        }
    }

    private static void guardarDatos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA))) {
            for (var entrada : agenda.entrySet()) {
                bw.write(entrada.getKey() + ":" + entrada.getValue());
                bw.newLine();
            }
            System.out.println("Datos guardados. ¡Adiós!");
        } catch (IOException e) {
            System.out.println("Error al guardar.");
        }
    }

    private static void cargarDatos() {
        File f = new File(RUTA);
        if (!f.exists()) return;

        try (Scanner sc = new Scanner(f)) {
            while (sc.hasNextLine()) {
                String[] partes = sc.nextLine().split(":");
                if (partes.length == 2) {
                    agenda.put(partes[0], partes[1]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No hay datos previos.");
        }
    }
}