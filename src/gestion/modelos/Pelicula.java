package gestion.modelos;

import clases.Actor;
import clases.superclase.ContenidoAudiovisual;
import java.util.ArrayList;

public class Pelicula extends ContenidoAudiovisual {

    private static int contador = 0;
    private String estudio;
    private ArrayList<Actor> actores;
    private int id;

    public Pelicula(String titulo, int duracionEnMinutos, String genero, String estudio) {
        super(titulo, duracionEnMinutos, genero);
        this.id = contador++;
        this.estudio = estudio;
        this.actores = new ArrayList<>();
    }

    public String getEstudio() {
        return estudio;
    }

    public ArrayList<Actor> getActores() {
        return actores;
    }

    public void agregarActor(Actor actor) {
        actores.add(actor);
    }

    public void agregarListaActores (ArrayList<Actor> actor) {
        actores.addAll(actor);
    }

    public int getId() {
        return id;
    }

    public int setId(int id) {
        return this.id = id;
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
        for (Actor indice : actores) {
            System.out.print(indice.toString());
        }
        System.out.println(""); 

    }

    @Override
    public String toString() {
        return id + "," + getTitulo() + "," + getDuracionEnMinutos() + "," + getGenero() + "," + getEstudio() + "," + getActores();
    }
}