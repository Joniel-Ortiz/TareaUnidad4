package gestion.controlador;

import clases.ContenidoAudiovisual;
import gestion.documentales.modelo.Documental;
import gestion.peliculas.modelo.Pelicula;
import gestion.series.modelo.SerieDeTV;
import gestion.vista.Vista;

import java.util.ArrayList;
import java.util.Scanner;

public class Controlador {

    private Vista vista;
    private ArrayList<Pelicula> peliculas;
    private ArrayList<SerieDeTV> seriesTV;
    private ArrayList<Documental> documentales;

    public Controlador () {

    }

    public Controlador(Vista vista, ArrayList<Pelicula> peliculas, ArrayList<SerieDeTV> seriesTV, ArrayList<Documental> documentales) {
        this.vista = vista;
        this.peliculas = peliculas;
        this.seriesTV = seriesTV;
        this.documentales = documentales;
    }

    public void agregarContenido(int opcion) {

        if (opcion == 1) {
            peliculas.add(vista.pedirDatosPelicula());
        }

        else if (opcion== 2) {
            seriesTV.add(vista.pedirDatosSerieTV());
        }

        else if (opcion == 3) {
            documentales.add(vista.pedirDatosDocumental());
        }
    }

    public void eliminarContenido(int opcion) {

        if (opcion == 1) {

            int idPelicula = vista.leerOpcion();

            peliculas.remove(idPelicula);
        }

        else if (opcion == 2) {
            for (SerieDeTV indice : seriesTV) {
                indice.mostrarDetalles();
            }

            int idSerie = vista.leerOpcion();

            seriesTV.remove(idSerie);
        }

        else if (opcion== 3) {
            for (Documental indice : documentales) {
                indice.mostrarDetalles();
            }

            int idDocumental = vista.leerOpcion();

            documentales.remove(idDocumental);
        }
    }

    public void mostrarContenido(int opcion) {

        if (opcion == 1) {
            for (Pelicula pelicula : peliculas) {
                pelicula.mostrarDetalles();
            }
        }

        else if (opcion == 2) {
            for (SerieDeTV serie : seriesTV) {
                serie.mostrarDetalles();
            }
        }

        else if (opcion == 3) {
            for (Documental documental : documentales) {
                documental.mostrarDetalles();
            }
        }
    }
}

