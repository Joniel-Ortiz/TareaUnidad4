package clases;

import clases.superclase.ElementosProduccion;

public class Actor extends ElementosProduccion{
    private String nombre;

    public Actor(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "[" + nombre + "]";
    }
}