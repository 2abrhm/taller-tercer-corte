package ejercicio08;

import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Clase principal del Ejercicio 8: Cajero automático.
 */
public class Main {

    private static String formatearMoneda(double valor) {
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setGroupingSeparator('.');
        DecimalFormat formato = new DecimalFormat("#,###", simbolos);
        return formato.format(valor);
    }

    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("Usuario Principal", 500000);
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);

        try {
            boolean salir = false;
            while (!salir) {
                System.out.println("1. Consultar  2. Depositar  3. Retirar  4. Salir");
                System.out.print("Opción: ");
                try {
                    String entradaOpcion = sc.nextLine().trim();
                    int opcion = Integer.parseInt(entradaOpcion);

                    switch (opcion) {
                        case 1:
                            System.out.println("Saldo disponible: $" + formatearMoneda(cuenta.getSaldo()));
                            break;
                        case 2:
                            System.out.print("Monto a depositar: ");
                            double montoDeposito = Double.parseDouble(sc.nextLine().trim());
                            cuenta.depositar(montoDeposito);
                            System.out.println("Depósito exitoso. Nuevo saldo: $" + formatearMoneda(cuenta.getSaldo()));
                            break;
                        case 3:
                            System.out.print("Monto a retirar: ");
                            double montoRetiro = Double.parseDouble(sc.nextLine().trim());
                            cuenta.retirar(montoRetiro);
                            System.out.println("Retiro exitoso. Nuevo saldo: $" + formatearMoneda(cuenta.getSaldo()));
                            break;
                        case 4:
                            System.out.println("Gracias por usar el cajero automático. ¡Hasta pronto!");
                            salir = true;
                            break;
                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: debe ingresar un número.");
                } catch (MontoInvalidoException | SaldoInsuficienteException e) {
                    System.out.println(e.getMessage());
                } catch (NoSuchElementException e) {
                    System.out.println("\nEntrada finalizada. Gracias por usar el cajero automático.");
                    salir = true;
                }
                System.out.println();
            }
        } finally {
            sc.close();
        }
    }
}
