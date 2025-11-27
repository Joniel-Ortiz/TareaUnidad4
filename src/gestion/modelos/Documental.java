/**
 * Class Documental
 */
package gestion.modelos;

import clases.Investigador;
import clases.superclase.ContenidoAudiovisual;

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

    public ArrayList<Investigador> getInvestigadores() {
        return investigadores;
    }

    public void setInvestigadores(ArrayList<Investigador> investigadores) {
        this.investigadores = investigadores;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void agregarInvestigadores(Investigador investigador) {
        investigadores.add(investigador);
    }

    public void agregarListaInvestigadores(ArrayList<Investigador> investigador) {
        investigadores.addAll(investigador);
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
        System.out.println("Tema: " + this.tema);
        System.out.print("Investigadores: ");
        for (Investigador indice: investigadores) {
            System.out.print(indice.toString());
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return id + "," + getTitulo() + "," +  getDuracionEnMinutos() + "," + getGenero() + "," + getTema() + "," + getInvestigadores();
    }
}