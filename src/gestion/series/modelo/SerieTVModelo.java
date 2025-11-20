package gestion.series.modelo;

import gestion.InterfaceContenido;
import gestion.vista.Vista;

import java.util.ArrayList;

public class SerieTVModelo implements InterfaceContenido {
    ArrayList<SerieDeTV> serieTV = new ArrayList();
    Vista vista = new Vista();

    public void agregarSerieTV(SerieDeTV seriesTV) {
        serieTV.add(seriesTV);
    }

    @Override
    public void eliminarContenido() {
        System.out.println("");
        System.out.println("Escoge la serie que deseas eliminar: ");
        mostrarContenido();

        System.out.println("");
        System.out.print("Opcion: ");
        int opcion = vista.leerOpcion();

        serieTV.remove(opcion);
    }

    @Override
    public void mostrarContenido() {
        for (int i = 0; i < serieTV.size(); i++) {
            System.out.println("");
            System.out.println("Serie " + i + ":");
            System.out.println("Titulo: " + serieTV.get(i).getTitulo());
            System.out.println("Duracion: " + serieTV.get(i).getDuracionEnMinutos());
            System.out.println("Genero: " + serieTV.get(i).getGenero());
            System.out.println("Temporadas: " + serieTV.get(i).getTemporadas());
        }

        if (serieTV.isEmpty()) {
            System.out.println("No existen series.");
        }
    }
}
