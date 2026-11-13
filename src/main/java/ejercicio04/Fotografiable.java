package ejercicio04;

/**
 * Interfaz que define el comportamiento de un dispositivo capaz de tomar fotografías.
 */
public interface Fotografiable {

    void tomarFoto();

    int getMegapixeles();

    default String funcion() {
        return "Fotografía";
    }
}
