package ejercicio04;

/**
 * Interfaz que define el comportamiento de un dispositivo capaz de realizar llamadas.
 */
public interface Llamable {

    void llamar(String numero);

    void colgar();

    default String funcion() {
        return "Llamadas";
    }
}
