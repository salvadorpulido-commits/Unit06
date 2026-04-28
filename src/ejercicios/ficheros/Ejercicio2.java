package ejercicios.ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
  
        File archivo = new File("src/archivos_txt/Enteros.txt");
        
        int suma = 0;
        int contador = 0;

        try (Scanner sc = new Scanner(archivo)) {
        	
            // Leemos números enteros 
        	
            while (sc.hasNextInt()) {
                int num = sc.nextInt();
                suma += num;
                contador++;
            }

            if (contador > 0) {
                double media = (double) suma / contador; // Cast a double para no perder decimales 
                System.out.println("Suma de enteros: " + suma);
                System.out.println("Media aritmética: " + media);
            } else {
                System.out.println("El fichero Enteros.txt está vacío.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encuentra 'Enteros.txt' en la raíz del proyecto.");
        }
    }
}