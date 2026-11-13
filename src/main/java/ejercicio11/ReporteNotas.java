package ejercicio11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/**
 * Ejercicio 11: Lectura de notas desde notas.csv y generación de reporte.csv.
 */
public class ReporteNotas {

    public static void main(String[] args) {
        String archivoEntrada = "notas.csv";
        String archivoSalida = "reporte.csv";

        int procesados = 0;
        int conError = 0;

        try (FileReader fr = new FileReader(archivoEntrada, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(fr);
             FileWriter fw = new FileWriter(archivoSalida, StandardCharsets.UTF_8);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {

            // Escribir cabecera del archivo de salida
            pw.println("codigo,nombre,promedio,estado");

            // Leer y saltar la cabecera del archivo de entrada (línea 1)
            String linea = br.readLine();
            int numeroLinea = 1;

            while ((linea = br.readLine()) != null) {
                numeroLinea++;
                if (linea.trim().isEmpty()) {
                    continue;
                }

                String[] columnas = linea.split(",");
                if (columnas.length != 5) {
                    System.out.println("Línea " + numeroLinea + ": faltan columnas (se esperaban 5, hay "
                            + columnas.length + ")");
                    conError++;
                    continue;
                }

                String codigo = columnas[0].trim();
                String nombre = columnas[1].trim();
                String datoActual = "";

                try {
                    datoActual = columnas[2].trim();
                    double nota1 = Double.parseDouble(datoActual);

                    datoActual = columnas[3].trim();
                    double nota2 = Double.parseDouble(datoActual);

                    datoActual = columnas[4].trim();
                    double nota3 = Double.parseDouble(datoActual);

                    double promedio = (nota1 + nota2 + nota3) / 3.0;
                    String estado = (promedio >= 3.0) ? "APROBADO" : "REPROBADO";
                    String promedioFormateado = String.format(Locale.US, "%.2f", promedio);

                    pw.println(codigo + "," + nombre + "," + promedioFormateado + "," + estado);
                    procesados++;
                } catch (NumberFormatException e) {
                    System.out.println("Línea " + numeroLinea + ": nota no numérica '" + datoActual + "'");
                    conError++;
                }
            }

            System.out.println("Registros procesados: " + procesados);
            System.out.println("Registros con error: " + conError);

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró el archivo de entrada '" + archivoEntrada
                    + "'. Verifique que exista en la raíz del proyecto.");
        } catch (IOException e) {
            System.out.println("Error de lectura/escritura al procesar el reporte: " + e.getMessage());
        }
    }
}
