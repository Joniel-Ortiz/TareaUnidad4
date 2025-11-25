/**
 * Class SerieDeTV
 */
package gestion.modelos;

import clases.Temporada;
import clases.superclase.ContenidoAudiovisual;

import java.util.ArrayList;

// Subclase SerieDeTV que extiende de ContenidoAudiovisual
public class SerieDeTV extends ContenidoAudiovisual {
    private static int contador = 0;
    private ArrayList<Temporada> temporadas;
    private int id;

    public SerieDeTV(String titulo, int duracionEnMinutos, String genero) {
        super(titulo, duracionEnMinutos, genero);
        this.id = contador++;
        this.temporadas = new ArrayList<>();
    }

    
    public ArrayList<Temporada> getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(ArrayList<Temporada> temporadas) {
        this.temporadas = temporadas;
    }

    public void agregarTemporada(Temporada numero) {
        temporadas.add(numero);
    }

    public void agregarListaTemporadas (ArrayList<Temporada> numero) {
        temporadas.addAll(numero);
    }

    @Override
    public void mostrarDetalles() {
        
        System.out.println("");
        System.out.println("ID: " + id);
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.print("Temporadas: ");
        for (Temporada indice : temporadas) {
            System.out.print(indice.toString());
        }
        System.out.println("");
    }

    @Override
    public String toString() {
        return id + "," +getTitulo() + "," + getDuracionEnMinutos() + "," + getGenero() + "," + getTemporadas();
    }
}