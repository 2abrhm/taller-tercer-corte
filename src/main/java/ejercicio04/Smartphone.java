package ejercicio04;

/**
 * Clase que representa un teléfono inteligente (Smartphone).
 * Hereda de Dispositivo e implementa Llamable y Fotografiable.
 */
public class Smartphone extends Dispositivo implements Llamable, Fotografiable {

    private int megapixeles;

    public Smartphone(String marca, String modelo, double precio, int megapixeles) {
        super(marca, modelo, precio);
        this.megapixeles = megapixeles;
    }

    /**
     * Sobrescribe funcion() para resolver la ambigüedad entre Llamable y Fotografiable.
     */
    @Override
    public String funcion() {
        return "Llamadas y fotografía";
    }

    @Override
    public void describir() {
        System.out.println("Smartphone " + marca + " " + modelo
                + " - $" + formatearPrecio() + " - " + funcion());
    }

    @Override
    public void tomarFoto() {
        System.out.println(marca + " tomó una foto de " + megapixeles + " MP");
    }

    @Override
    public int getMegapixeles() {
        return megapixeles;
    }

    @Override
    public void llamar(String numero) {
        System.out.println(marca + " llamando a " + numero);
    }

    @Override
    public void colgar() {
        System.out.println(marca + " finalizó la llamada");
    }
}
