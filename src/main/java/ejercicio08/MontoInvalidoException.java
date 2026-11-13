package ejercicio08;

/**
 * Excepción verificada que se lanza cuando un monto a depositar o retirar es menor o igual a cero.
 */
public class MontoInvalidoException extends Exception {

    public MontoInvalidoException(double monto) {
        super("Monto inválido: " + monto + ". Debe ser mayor que cero.");
    }
}
