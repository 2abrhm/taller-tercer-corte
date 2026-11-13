package ejercicio08;

/**
 * Clase que representa una cuenta bancaria con operaciones de consulta, depósito y retiro.
 */
public class CuentaBancaria {

    private String titular;
    private double saldo;

    public CuentaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) throws MontoInvalidoException {
        if (monto <= 0) {
            throw new MontoInvalidoException(monto);
        }
        saldo += monto;
    }

    public void retirar(double monto) throws MontoInvalidoException, SaldoInsuficienteException {
        if (monto <= 0) {
            throw new MontoInvalidoException(monto);
        }
        if (monto > saldo) {
            throw new SaldoInsuficienteException(saldo, monto);
        }
        saldo -= monto;
    }
}
