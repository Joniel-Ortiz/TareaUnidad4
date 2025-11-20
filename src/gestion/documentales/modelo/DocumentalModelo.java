package gestion.documentales.modelo;

import gestion.InterfaceContenido;
import gestion.vista.Vista;

import java.util.ArrayList;

public class DocumentalModelo implements InterfaceContenido {
    ArrayList<Documental> documentales = new ArrayList();
    Vista vista = new Vista();

    public void agregarDocumental(Documental documental) {
        documentales.add(documental);
    }

    @Override
    public void eliminarContenido() {
        System.out.println("");
        System.out.println("Escoge el documental que deseas eliminar: ");
        mostrarContenido();

        System.out.println("");
        System.out.print("Opcion: ");
        int opcion = vista.leerOpcion();

        documentales.remove(opcion);
    }

    @Override
    public void mostrarContenido() {
        for (int i = 0; i < documentales.size(); i++) {
            System.out.println("");
            System.out.println("Documental " + i + ":");
            System.out.println("Titulo: " + documentales.get(i).getTitulo());
            System.out.println("Duracion: " + documentales.get(i).getDuracionEnMinutos());
            System.out.println("Genero: " + documentales.get(i).getGenero());
            System.out.println("Tema: " + documentales.get(i).getTema());
        }

        if (documentales.isEmpty()) {
            System.out.println("No existen documentales.");
        }

    }
}
