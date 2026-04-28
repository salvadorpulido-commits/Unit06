package ejercicios.ficheros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        String ruta = "src/archivos_txt/cadenas.txt";

        // Al meter AMBOS (Scanner y BufferedWriter) aquí, Java los cierra solos.
        // Se separan por punto y coma dentro del paréntesis del try.
        try (Scanner sc = new Scanner(System.in);
             BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            
            String cadena;
            System.out.println("Escribe frases para guardar (escribe 'fin' para terminar):");

            do {
                System.out.print("> ");
                cadena = sc.nextLine();

                if (!cadena.equalsIgnoreCase("fin")) {
                    bw.write(cadena);
                    bw.newLine();
                }
            } while (!cadena.equalsIgnoreCase("fin"));

            System.out.println("Proceso finalizado. El fichero se ha guardado en: " + ruta);

        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        }
    }
}