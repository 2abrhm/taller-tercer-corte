package ejercicio10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona el registro y lectura de eventos en un archivo de texto plano (bitácora).
 */
public class Bitacora {

    private static final DateTimeFormatter FORMATO_FECHA =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final String rutaArchivo;

    public Bitacora(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    /**
     * Agrega un nuevo evento al final del archivo de bitácora con marca de tiempo.
     *
     * @param mensaje descripción del evento a registrar
     * @throws IOException si ocurre un error de escritura
     */
    public void registrar(String mensaje) throws IOException {
        String fechaHora = LocalDateTime.now().format(FORMATO_FECHA);
        try (FileWriter fw = new FileWriter(rutaArchivo, StandardCharsets.UTF_8, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {
            pw.println("[" + fechaHora + "] " + mensaje);
        }
    }

    /**
     * Lee todas las líneas del archivo de bitácora usando BufferedReader y FileReader en UTF-8.
     *
     * @return lista con todas las líneas del archivo
     * @throws IOException si el archivo no existe (FileNotFoundException) o hay error de lectura
     */
    public List<String> leer() throws IOException {
        List<String> lineas = new ArrayList<>();
        try (FileReader fr = new FileReader(rutaArchivo, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(fr)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        }
        return lineas;
    }

    /**
     * Cuenta cuántas líneas del archivo contienen la palabra indicada sin importar mayúsculas o minúsculas.
     *
     * @param palabra término a buscar
     * @return cantidad de líneas que contienen la palabra
     * @throws IOException si ocurre un error al leer el archivo
     */
    public int contar(String palabra) throws IOException {
        List<String> lineas = leer();
        int contador = 0;
        String palabraMinuscula = palabra.toLowerCase();
        for (String linea : lineas) {
            if (linea.toLowerCase().contains(palabraMinuscula)) {
                contador++;
            }
        }
        return contador;
    }
}
