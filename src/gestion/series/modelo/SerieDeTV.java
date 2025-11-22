/**
 * Class SerieDeTV
 */
package gestion.series.modelo;

import clases.ContenidoAudiovisual;
import clases.Temporada;

import java.util.ArrayList;

// Subclase SerieDeTV que extiende de ContenidoAudiovisual
public class SerieDeTV extends ContenidoAudiovisual {
    private static int contador = 0;
    private int temporadas;
    private ArrayList<Temporada> listaTemporadas;
    private int id;

    public SerieDeTV(String titulo, int duracionEnMinutos, String genero, int temporadas) {
        super(titulo, duracionEnMinutos, genero);
        this.id = contador++;
        this.temporadas = temporadas;
        this.listaTemporadas = new ArrayList<>();
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public void agregarTemporada(int numero) {
        listaTemporadas.add(new Temporada(numero));
    }

    @Override
    public void mostrarDetalles() {
        int totalTemporadas = temporadas + listaTemporadas.size();
        System.out.println("");
        System.out.println("ID: " + id);
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Temporadas: " + totalTemporadas);
    }

    @Override
    public String toString() {
        return getTitulo() + "," + getDuracionEnMinutos() + "," + getGenero() + "," + getTemporadas();
    }
}