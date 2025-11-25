package clases;

public class Temporada {
    private int numero;

    public Temporada(int numero) {
        this.numero = numero;
    }

    public int getnumero() {
        return numero;
    }
    public void setnumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "[" + numero + "]";
    }
}