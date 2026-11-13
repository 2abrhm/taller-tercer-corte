package ejercicio04;

/**
 * Clase que representa una cámara fotográfica.
 * Hereda de Dispositivo e implementa Fotografiable.
 */
public class Camara extends Dispositivo implements Fotografiable {

    private int megapixeles;

    public Camara(String marca, String modelo, double precio, int megapixeles) {
        super(marca, modelo, precio);
        this.megapixeles = megapixeles;
    }

    @Override
    public void describir() {
        System.out.println("Cámara " + marca + " " + modelo
                + " - $" + formatearPrecio() + " - " + funcion());
    }

    @Override
    public void tomarFoto() {
        System.out.println(marca + " tomó una foto profesional de " + megapixeles + " MP");
    }

    @Override
    public int getMegapixeles() {
        return megapixeles;
    }
}
