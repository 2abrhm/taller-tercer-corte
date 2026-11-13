package ejercicio07;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;

/**
 * Ejercicio 7: Cálculo del promedio de notas corrigiendo las malas prácticas.
 */
public class Promedio {

    /**
     * Calcula el promedio de un arreglo de notas entre 0.0 y 5.0.
     *
     * @param notas arreglo de notas en escala de 0 a 5
     * @return promedio aritmético de las notas
     * @throws IllegalArgumentException si el arreglo es nulo, vacío o contiene notas fuera de rango
     */
    public static double promedio(double[] notas) {
        if (notas == null || notas.length == 0) {
            throw new IllegalArgumentException("El arreglo de notas no puede ser nulo ni estar vacío.");
        }

        double suma = 0.0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < 0.0 || notas[i] > 5.0) {
                throw new IllegalArgumentException(
                        "La nota en la posición " + (i + 1) + " (" + notas[i] + ") debe estar entre 0.0 y 5.0.");
            }
            suma += notas[i];
        }
        return suma / notas.length;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8)) {
            int n = 0;
            while (n <= 0) {
                System.out.print("¿Cuántas notas? ");
                String entrada = sc.nextLine().trim();
                try {
                    n = Integer.parseInt(entrada);
                    if (n <= 0) {
                        System.out.println("La cantidad de notas debe ser un entero mayor que 0.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Dato inválido: debe ingresar un número entero.");
                }
            }

            double[] notas = new double[n];
            for (int i = 0; i < n; i++) {
                boolean notaValida = false;
                while (!notaValida) {
                    System.out.print("Nota " + (i + 1) + ": ");
                    String entradaNota = sc.nextLine().trim().replace(',', '.');
                    try {
                        double valor = Double.parseDouble(entradaNota);
                        if (valor < 0.0 || valor > 5.0) {
                            System.out.println("La nota debe estar entre 0.0 y 5.0.");
                        } else {
                            notas[i] = valor;
                            notaValida = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Dato inválido");
                    }
                }
            }

            double resultado = promedio(notas);
            System.out.println(String.format(Locale.US, "Promedio: %.2f", resultado));
        }
    }
}
