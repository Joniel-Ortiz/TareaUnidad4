package main;
import gestion.controlador.Controlador;
import gestion.modelos.Documental;
import gestion.modelos.Pelicula;
import gestion.modelos.SerieDeTV;
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