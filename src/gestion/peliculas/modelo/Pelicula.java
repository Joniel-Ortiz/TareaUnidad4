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

    public Pelicula(String titulo, int duracionEnMinutos, String genero, String estudio) {
        super(titulo, duracionEnMinutos, genero);
        this.estudio = estudio;
        this.actores = new ArrayList<>();
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la película:");
        System.out.println("ID: " + getId());
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