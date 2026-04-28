package ejercicios.ficheros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Usamos tu nueva ruta organizada
        
        String ruta = "src/archivos_txt/cadenas.txt";

        // BufferedWriter es eficiente para escribir texto línea a línea
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            String cadena;
            System.out.println("Escribe frases para guardar (escribe 'fin' para terminar):");

            do {
                System.out.print("> ");
                cadena = sc.nextLine();

                if (!cadena.equalsIgnoreCase("fin")) {
                	
                    bw.write(cadena); // Escribe la frase
                    bw.newLine();    // Añade el salto de línea [cite: 20]
                }
            } while (!cadena.equalsIgnoreCase("fin"));

            System.out.println("Fichero guardado con éxito en: " + ruta);

        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }
}