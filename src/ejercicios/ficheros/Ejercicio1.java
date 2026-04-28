package ejercicios.ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Locale;

public class Ejercicio1 {
    public static void main(String[] args) {
    	
        // 1. Apuntamos al archivo dentro del paquete src
    	
        File archivo = new File("src/archivos_txt/NumerosReales.txt");
        
        double suma = 0;
        int contador = 0;

        try (Scanner sc = new Scanner(archivo)) {
        	
            // Forzamos el uso del punto como separador decimal
        	
            sc.useLocale(Locale.US);

            // 2. Leemos mientras haya números reales 
            
            while (sc.hasNextDouble()) {
                double num = sc.nextDouble();
                suma += num;
                contador++;
            }

            // 3. Calculamos la media y mostramos resultados 
            
            if (contador > 0) {
                double media = suma / contador;
                System.out.println("Suma total: " + suma);
                System.out.println("Media aritmética: " + media);
            } else {
                System.out.println("El fichero está vacío.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encuentra el archivo.");
            e.printStackTrace();
        }
    }
}
