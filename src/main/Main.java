package main;
import gestion.controlador.Controlador;
import gestion.documentales.modelo.Documental;
import gestion.peliculas.modelo.Pelicula;
import gestion.series.modelo.SerieDeTV;
import gestion.vista.Vista;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Pelicula> peliculas = new ArrayList<>();
        ArrayList<SerieDeTV> seriesTV = new ArrayList<>();
        ArrayList<Documental> documentales = new ArrayList<>();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(vista, peliculas, seriesTV, documentales);
        vista.setControlador(controlador);
        vista.menuPrincipal();










    }
}