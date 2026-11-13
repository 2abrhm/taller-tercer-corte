package ejercicio08;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Excepción verificada que se lanza cuando el saldo de una cuenta no alcanza para el retiro.
 */
public class SaldoInsuficienteException extends Exception {

    private final double faltante;

    public SaldoInsuficienteException(double saldo, double monto) {
        super("Saldo insuficiente. Saldo: $" + formatearMoneda(saldo)
                + " - Faltan: $" + formatearMoneda(monto - saldo));
        this.faltante = monto - saldo;
    }

    public double getFaltante() {
        return faltante;
    }

    private static String formatearMoneda(double valor) {
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setGroupingSeparator('.');
        DecimalFormat formato = new DecimalFormat("#,###", simbolos);
        return formato.format(valor);
    }
}
