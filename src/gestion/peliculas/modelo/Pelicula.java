/**
 * Class Pelicula
 */
package gestion.peliculas.modelo;

import clases.Actor;
import clases.ContenidoAudiovisual;

import java.util.ArrayList;

// Subclase Pelicula que extiende de ContenidoAudiovisual
public class Pelicula extends ContenidoAudiovisual {
    private String estudio;
    private ArrayList<Actor> actores;
    private int id;

    public Pelicula(String titulo, int duracionEnMinutos, String genero, String estudio) {
        super(titulo, duracionEnMinutos, genero);
        this.id = id++;
        this.estudio = estudio;
        this.actores = new ArrayList<>();
    }

    public String getEstudio() {
        return estudio;
    }

    public void agregarActor(Actor actor) {
        actores.add(actor);
    }

    public ArrayList<Actor> getActores() {
        return actores;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("");
        System.out.println("ID: " + id);
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Estudio: " + estudio);
        System.out.print("Actores: ");
        for (Actor indice:actores) {
            System.out.print("[" + indice.getNombre() + "] ");
        }
        System.out.println("");
    }

    @Override
    public String toString() {
        return "" + getTitulo() + getDuracionEnMinutos() +  getGenero() + getEstudio();
    }
}