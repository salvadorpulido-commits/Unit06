package ejercicios.ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Locale;

public class Ejercicio3 {
    public static void main(String[] args) {
        File archivo = new File("Alumnos.txt");
        
        double sumaEdades = 0;
        double sumaEstaturas = 0;
        int contadorAlumnos = 0;

        try (Scanner sc = new Scanner(archivo)) {
            sc.useLocale(Locale.US);

            System.out.println("--- Listado de Alumnos ---");

            while (sc.hasNext()) {
                // Leemos los datos de la línea actual
                String nombre = sc.next();
                int edad = sc.nextInt();
                double estatura = sc.nextDouble();

                // Mostramos el nombre según pide el boletín
                System.out.println("Nombre: " + nombre);

                // Acumulamos para las medias
                sumaEdades += edad;
                sumaEstaturas += estatura;
                contadorAlumnos++;
            }

            // Calculamos y mostramos las medias
            if (contadorAlumnos > 0) {
                System.out.println("--------------------------");
                System.out.printf("Media de edad: %.2f%n", (sumaEdades / contadorAlumnos));
                System.out.printf("Media de estatura: %.2f%n", (sumaEstaturas / contadorAlumnos));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encuentra el archivo Alumnos.txt");
        }
    }
}