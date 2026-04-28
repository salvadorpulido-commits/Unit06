package ejercicios.ficheros.boletin2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio1 {
    public static void main(String[] args) {
        String ruta = "src/archivos_txt/carta.txt";
        
        int caracteres = 0;
        int lineas = 0;
        int palabras = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                lineas++;
                // Sumamos la longitud de la línea (caracteres)
                caracteres += linea.length();

                // Contamos palabras: dividimos la línea por espacios
                // El trim() evita contar espacios vacíos al inicio/final
                if (!linea.trim().isEmpty()) {
                    String[] trozos = linea.trim().split("\\s+"); // "\\s+" detecta uno o más espacios
                    palabras += trozos.length;
                }
            }

            System.out.println("--- Estadísticas de carta.txt ---");
            System.out.println("Líneas: " + lineas);
            System.out.println("Palabras: " + palabras);
            System.out.println("Caracteres (sin contar saltos de línea): " + caracteres);

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}