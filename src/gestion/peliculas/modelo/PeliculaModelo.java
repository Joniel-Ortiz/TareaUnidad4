package gestion.peliculas.modelo;

import gestion.InterfaceContenido;
import gestion.vista.Vista;

import java.util.ArrayList;

public class PeliculaModelo implements InterfaceContenido {
    ArrayList<Pelicula> peliculas = new ArrayList();
    Vista vista = new  Vista();

    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
    }

    @Override
    public void eliminarContenido() {
        System.out.println("");
        System.out.println("Escoge la pelicula que deseas eliminar: ");
        mostrarContenido();

        System.out.println("");
        System.out.print("Opcion: ");
        int opcion = vista.leerOpcion();

        peliculas.remove(opcion);
    }

    @Override
    public void mostrarContenido() {
        for (int i = 0; i < peliculas.size(); i++) {
            System.out.println("");
            System.out.println("Pelicula " + i + ":");
            System.out.println("Titulo: " + peliculas.get(i).getTitulo());
            System.out.println("Duracion: " + peliculas.get(i).getDuracionEnMinutos());
            System.out.println("Estudio: " + peliculas.get(i).getEstudio());
            System.out.println("Genero: " + peliculas.get(i).getGenero());
        }

        if (peliculas.isEmpty()) {
            System.out.println("No existen peliculas.");
        }
    }
}
