package ejercicios.ficheros;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        String rutaLectura = "src/archivos_txt/numeros_desordenados.txt";
        String rutaEscritura = "src/archivos_txt/numeros_ordenados.txt";
        
        // 1. Lista para almacenar los números en memoria
        ArrayList<Integer> listaNumeros = new ArrayList<>();

        // 2. Lectura del fichero original
        try (Scanner sc = new Scanner(new File(rutaLectura))) {
            while (sc.hasNextInt()) {
                listaNumeros.add(sc.nextInt()); // [cite: 23]
            }
            System.out.println("Números leídos: " + listaNumeros);
        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encuentra el archivo de origen.");
        }

        // 3. Ordenación de la lista
        Collections.sort(listaNumeros); // 
        System.out.println("Números ordenados: " + listaNumeros);

        // 4. Escritura en el nuevo fichero
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaEscritura))) {
            for (Integer num : listaNumeros) {
                bw.write(String.valueOf(num));
                bw.newLine(); // 
            }
            System.out.println("Fichero 'numeros_ordenados.txt' creado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}
