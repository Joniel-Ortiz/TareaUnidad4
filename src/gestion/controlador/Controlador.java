package gestion.controlador;

import gestion.modelos.*;
import gestion.vista.Vista;
import java.io.*;
import java.util.ArrayList;
import clases.*;
import clases.superclase.ContenidoAudiovisual;
import clases.superclase.ElementosProduccion;

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

    public void agregarContenido(int opcion, ContenidoAudiovisual contenido) {

        switch (opcion) {
            case 1:
                peliculas.add((Pelicula) contenido);
                break;
            case 2:
                seriesTV.add((SerieDeTV) contenido);
                break;
            case 3:
                documentales.add((Documental) contenido);
                break;    
        }   
    }

    public void eliminarContenido(int opcion, int id) {
        
        int indiceAEliminar = -1;

        switch (opcion) {
            case 1:
                
                for (int i = 0; i < peliculas.size(); i++) {
                    if (peliculas.get(i).getId() == id) {
                        indiceAEliminar = i;
                        break;
                    }
                }
            
                if (indiceAEliminar != -1) {
                    peliculas.remove(indiceAEliminar);
                
                    for (Pelicula pelicula : peliculas) {
                        if (pelicula.getId() > id) {
                        pelicula.setId(pelicula.getId() - 1);
                        }
                    }
                }
                break;
            case 2:

                for (int i = 0; i < seriesTV.size(); i++) {
                    if (seriesTV.get(i).getId() == id) {
                        indiceAEliminar = i;
                        break;
                    }
                }
            
                if (indiceAEliminar != -1) {
                    seriesTV.remove(indiceAEliminar);
                
                    for (SerieDeTV serieDeTV : seriesTV) {
                        if (serieDeTV.getId() > id) {
                        serieDeTV.setId(serieDeTV.getId() - 1);
                        }
                    }
                }
                break;
            case 3:

                for (int i = 0; i < documentales.size(); i++) {
                    if (documentales.get(i).getId() == id) {
                        indiceAEliminar = i;
                        break;
                    }
                }
            
                if (indiceAEliminar != -1) {
                    documentales.remove(indiceAEliminar);
                
                    for (Documental documental : documentales) {
                        if (documental.getId() > id) {
                        documental.setId(documental.getId() - 1);
                        }
                    }
                }
                break;
            }      
    }
        
    public void mostrarContenido(int opcion) {

        switch(opcion) {
            case 1:
                for (Pelicula pelicula : peliculas) {
                    pelicula.mostrarDetalles();
                }
                break;
            case 2:
                for (SerieDeTV serie : seriesTV) {
                    serie.mostrarDetalles();
                }
                break;
            case 3:
                for (Documental documental : documentales) {
                    documental.mostrarDetalles();
                }
                break;
        }
    }

    public void guardarContenido(int opcion) {

        switch (opcion) {
            case 1:
                try(BufferedWriter writerPelicula = new BufferedWriter(new FileWriter("peliculas.csv"))) {
                    for (Pelicula indice : peliculas) {
                        writerPelicula.write(indice.toString());
                        writerPelicula.newLine();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try(BufferedWriter writerSerie = new BufferedWriter(new FileWriter("seriesTV.csv"))) {
                    for (SerieDeTV indice : seriesTV) {
                        writerSerie.write(indice.toString());
                        writerSerie.newLine();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try(BufferedWriter writerDocumental = new BufferedWriter(new FileWriter("documentales.csv"))) {
                    for (Documental indice : documentales) {
                        writerDocumental.write(indice.toString());
                        writerDocumental.newLine();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }

    public void cargarContenido(int opcion) {

        switch (opcion) {
            case 1:
                try(BufferedReader reader = new BufferedReader(new FileReader("peliculas.csv"))) {;

                    String linea;

                    while ((linea = reader.readLine()) != null) {

                        ArrayList<Actor> actores = new ArrayList<>();
                        String[] campos = linea.split(",");

                        String titulo = campos[1].trim();
                        int duracionEnMinutos = Integer.parseInt(campos[2].trim());
                        String genero = campos[3].trim();
                        String estudio = campos[4].trim();

                        for (int i = 5; i < campos.length; i++) {
                            String campo = campos[i].replaceAll("[\\[\\]\\s]", "");
                            if (!campo.isEmpty()) {
                                try {
                                    String nombreActores = campo;
                                    actores.add(new Actor(nombreActores));
                                } catch (NumberFormatException e){

                                }
                            }
                        }

                        Pelicula nuevaPelicula = new Pelicula(titulo, duracionEnMinutos, genero, estudio);
                        nuevaPelicula.agregarListaActores(actores);
                        peliculas.add(nuevaPelicula);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try (BufferedReader reader = new BufferedReader(new FileReader("seriesTV.csv"))) {
                
                    String linea;
        
                    while ((linea = reader.readLine()) != null) {

                        ArrayList<Temporada> temporadas = new ArrayList<>();
            
                        String[] campos = linea.split(",");
            
                        String titulo = campos[1].trim();
                        int duracionEnMinutos = Integer.parseInt(campos[2].trim());
                        String genero = campos[3].trim();
            
                        for (int i = 4; i < campos.length; i++) {
                            String campo = campos[i].replaceAll("[\\[\\]\\s]", "");
                            if (!campo.isEmpty()) {
                                try {
                                    int numeroTemporada = Integer.parseInt(campo);
                                    temporadas.add(new Temporada(numeroTemporada));
                                } catch (NumberFormatException e) {

                                }
                            }
                        }

                        SerieDeTV nuevaSerieDeTV = new SerieDeTV(titulo, duracionEnMinutos, genero);
                        nuevaSerieDeTV.agregarListaTemporadas(temporadas);
                        seriesTV.add(nuevaSerieDeTV);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try(BufferedReader reader = new BufferedReader(new FileReader("documentales.csv")) ) {;

                    String linea;

                    while ((linea = reader.readLine()) != null) {

                        ArrayList<Investigador> investigadores = new ArrayList<>();

                        String[] campos = linea.split(",");

                        String titulo = campos[1].trim();
                        int duracionEnMinutos = Integer.parseInt(campos[2].trim());
                        String genero = campos[3].trim();
                        String tema = campos[4].trim();

                        for (int i = 5; i < campos.length; i++) {
                            String campo = campos[i].replaceAll("[\\[\\]\\s]", ""); 

                            if (!campo.isEmpty()) {
                                try {
                                    String nombreInvestigador = campo;
                                    investigadores.add(new Investigador(nombreInvestigador));
                                } catch (NumberFormatException e) {

                                }
                            }
                        }

                        Documental nuevoDocumental = new Documental(titulo, duracionEnMinutos, genero, tema);
                        nuevoDocumental.agregarListaInvestigadores(investigadores);
                        documentales.add(nuevoDocumental);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public void agregarElementosProduccion(int opcion, int idContenido, ElementosProduccion elementosProduccion) {
        
        switch (opcion) {
            case 1:
                peliculas.get(idContenido).agregarActor((Actor) elementosProduccion);
                break;
            case 2:
                seriesTV.get(idContenido).agregarTemporada((Temporada) elementosProduccion);
                break;
            case 3:
                documentales.get(idContenido).agregarInvestigadores((Investigador) elementosProduccion);
                break;
        }
    }
}