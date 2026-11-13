package ejercicio10;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Clase principal del Ejercicio 10: Bitácora de eventos (TXT).
 */
public class Main {

    public static void main(String[] args) {
        String archivoBitacora = "bitacora.txt";

        try {
            // Al inicio se borra bitacora.txt si existe para que cada ejecución parta limpia
            Files.deleteIfExists(Path.of(archivoBitacora));

            Bitacora bitacora = new Bitacora(archivoBitacora);

            // Registrar 4 eventos (2 de ellos con la palabra ERROR, uno en minúscula "error")
            bitacora.registrar("INFO: Inicio del sistema de facturación y gestión de niños/as");
            bitacora.registrar("ERROR: No se pudo conectar a la base de datos principal");
            bitacora.registrar("INFO: Usuario 'María Peña' inició sesión correctamente");
            bitacora.registrar("Advertencia con error crítico: tiempo de espera agotado en el servidor");

            // Leer y mostrar el contenido
            List<String> eventos = bitacora.leer();
            System.out.println("=== Contenido de " + archivoBitacora + " ===");
            for (String evento : eventos) {
                System.out.println(evento);
            }

            // Mostrar el total de líneas que contienen la palabra "ERROR" (ignore-case)
            int totalErrores = bitacora.contar("ERROR");
            System.out.println("\nTotal de eventos con 'ERROR': " + totalErrores);

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo de bitácora: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de entrada/salida al gestionar la bitácora: " + e.getMessage());
        }

        // Intentar leer un archivo inexistente ("noexiste.txt") con otra instancia
        System.out.println("\n=== Prueba de lectura de archivo inexistente ===");
        Bitacora bitacoraInexistente = new Bitacora("noexiste.txt");
        try {
            bitacoraInexistente.leer();
        } catch (FileNotFoundException e) {
            System.out.println("Aviso amigable: El archivo 'noexiste.txt' no fue encontrado en el sistema. Verifique la ruta antes de leer.");
        } catch (IOException e) {
            System.out.println("Error general de lectura: " + e.getMessage());
        }
    }
}
