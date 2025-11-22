/**
 * Class Documental
 */
package gestion.documentales.modelo;

import clases.ContenidoAudiovisual;
import clases.Investigador;

import java.util.ArrayList;

// Subclase Documental que extiende de ContenidoAudiovisual
public class Documental extends ContenidoAudiovisual {
    private static int contador = 0;
    private String tema;
    private ArrayList<Investigador> investigadores;
    private int id;

    public Documental(String titulo, int duracionEnMinutos, String genero, String tema) {
        super(titulo, duracionEnMinutos, genero);
        this.id = contador++;
        this.tema = tema;
        this.investigadores = new ArrayList<>();
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void agregarInvestigadores(String nombre) {
        investigadores.add(new Investigador(nombre));
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("");
        System.out.println("ID: " + id);
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Tema: " + this.tema);
        System.out.print("Investigadores: ");
        for (Investigador indice: investigadores) {
            System.out.print("[" + indice.getNombre() + "] ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return getTitulo() + "," +  getDuracionEnMinutos() + "," + getGenero() + "," + getTema();
    }
}