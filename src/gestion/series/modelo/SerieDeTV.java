/**
 * Class SerieDeTV
 */
package gestion.series.modelo;

import clases.ContenidoAudiovisual;
import clases.Temporada;

import java.util.ArrayList;

// Subclase SerieDeTV que extiende de ContenidoAudiovisual
public class SerieDeTV extends ContenidoAudiovisual {
    private int temporadas;
    private ArrayList<Temporada> listaTemporadas;

    public SerieDeTV(String titulo, int duracionEnMinutos, String genero) {
        super(titulo, duracionEnMinutos, genero);
    }

    public SerieDeTV(String titulo, int duracionEnMinutos, String genero, int temporadas) {
        super(titulo, duracionEnMinutos, genero);
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
        System.out.println("Detalles de la Serie:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Temporadas: " + totalTemporadas);
        System.out.println("");
    }
}