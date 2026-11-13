package ejercicio04;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Clase abstracta que representa un dispositivo electrónico de la tienda.
 */
public abstract class Dispositivo {

    protected String marca;
    protected String modelo;
    protected double precio;

    public Dispositivo(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    /**
     * Formatea el precio con punto como separador de miles y sin decimales.
     *
     * @return precio formateado (ej. "3.500.000")
     */
    protected String formatearPrecio() {
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setGroupingSeparator('.');
        DecimalFormat formato = new DecimalFormat("#,###", simbolos);
        return formato.format(precio);
    }

    public abstract void describir();
}
