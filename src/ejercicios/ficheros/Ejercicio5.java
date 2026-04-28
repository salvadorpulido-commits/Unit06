package ejercicios.ficheros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio5 {
	
    public static void main(String[] args) {
        String ruta = "src/archivos_txt/datos.txt";

        // Usamos el Scanner dentro del try para que se cierre solo
        try (Scanner sc = new Scanner(System.in);
             // El truco está en el 'true' del FileWriter: activa el modo APPEND
             BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true))) {

            System.out.print("Introduce tu nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Introduce tu edad: ");
            int edad = sc.nextInt();

            // Escribimos en el fichero
            bw.write("Nombre: " + nombre + ", Edad: " + edad);
            bw.newLine();

            System.out.println("Datos añadidos correctamente a datos.txt");

        } catch (IOException e) {
            System.out.println("Error al manejar el fichero: " + e.getMessage());
        }
    }
}
