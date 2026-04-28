package ejercicios.ficheros;

import java.io.*;
import java.util.Scanner;

public class Ejercicio8 {
    private static final String RUTA = "src/archivos_txt/meteorologia.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n--- ESTACIÓN METEOROLÓGICA ---");
            System.out.println("1. Registrar nueva temperatura");
            System.out.println("2. Mostrar historial de registros");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1 -> registrarTemperatura(sc);
                case 2 -> mostrarHistorial();
                case 3 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }

    private static void registrarTemperatura(Scanner sc) {
        // Usamos modo 'append' (true) para no borrar lo anterior
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA, true))) {
            System.out.print("Introduce la fecha (AAAA-MM-DD): ");
            String fecha = sc.nextLine();
            System.out.print("Temperatura Máxima: ");
            int max = sc.nextInt();
            System.out.print("Temperatura Mínima: ");
            int min = sc.nextInt();

            bw.write(fecha + "," + max + "," + min);
            bw.newLine();
            System.out.println("Registro guardado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
        }
    }

    private static void mostrarHistorial() {
        File f = new File(RUTA);
        if (!f.exists()) {
            System.out.println("No hay registros todavía.");
            return;
        }

        // Inicializamos los extremos con valores muy alejados
        int maxAbsoluta = Integer.MIN_VALUE;
        int minAbsoluta = Integer.MAX_VALUE;

        System.out.println("\n--- HISTORIAL DE REGISTROS ---");
        System.out.println("Fecha      | Max | Min");
        System.out.println("-----------------------");

        try (Scanner scFichero = new Scanner(f)) {
            while (scFichero.hasNextLine()) {
                String linea = scFichero.nextLine();
                // Separamos por la coma
                String[] partes = linea.split(",");
                
                if (partes.length == 3) {
                    String fecha = partes[0];
                    int max = Integer.parseInt(partes[1]);
                    int min = Integer.parseInt(partes[2]);

                    System.out.printf("%-10s | %3d | %3d%n", fecha, max, min);

                    // Actualizamos los valores récord
                    if (max > maxAbsoluta) maxAbsoluta = max;
                    if (min < minAbsoluta) minAbsoluta = min;
                }
            }
            
            System.out.println("-----------------------");
            System.out.println("Máxima histórica: " + maxAbsoluta);
            System.out.println("Mínima histórica: " + minAbsoluta);

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se pudo leer el archivo.");
        }
    }
}