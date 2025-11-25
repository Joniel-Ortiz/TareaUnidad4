package gestion.controlador;

import gestion.modelos.*;
import gestion.vista.Vista;
import java.io.*;
import java.util.ArrayList;
import clases.*;

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

    public void guardarContenido(int opcion) {

        if (opcion == 1) {
            try(BufferedWriter writerPelicula = new BufferedWriter(new FileWriter("peliculas.csv"))) {
                for (Pelicula indice : peliculas) {
                    writerPelicula.write(indice.toString());
                    writerPelicula.newLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else if (opcion == 2) {
            try(BufferedWriter writerSerie = new BufferedWriter(new FileWriter("seriesTV.csv"))) {
                for (SerieDeTV indice : seriesTV) {
                    writerSerie.write(indice.toString());
                    writerSerie.newLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else if (opcion == 3) {
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

    public void cargarContenido(int opcion) { //! No carga datos de un ArrayList, Pendiente Arreglar!

        if (opcion == 1) {

            try(BufferedReader reader = new BufferedReader(new FileReader("peliculas.csv"))) {;

                String linea;

                while ((linea = reader.readLine()) != null) {

                    ArrayList<Actor> actores = new ArrayList<>();
                    String[] campos = linea.split(",");

                    int id = Integer.parseInt(campos[0].trim());
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

                    peliculas.add(new Pelicula(titulo, duracionEnMinutos, genero, estudio));
                    peliculas.get(id).agregarListaActores(actores);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (opcion == 2) {

            try (BufferedReader reader = new BufferedReader(new FileReader("seriesTV.csv"))) {
                
                String linea;
        
                while ((linea = reader.readLine()) != null) {

                    ArrayList<Temporada> temporadas = new ArrayList<>();
            
                    String[] campos = linea.split(",");
            
                    int id = Integer.parseInt(campos[0].trim());
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

                    seriesTV.add(new SerieDeTV(titulo, duracionEnMinutos, genero));
                    seriesTV.get(id).agregarListaTemporadas(temporadas);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (opcion == 3) {

            try(BufferedReader reader = new BufferedReader(new FileReader("documentales.csv")) ) {;

                String linea;

                while ((linea = reader.readLine()) != null) {

                    ArrayList<Investigador> investigadores = new ArrayList<>();

                    String[] campos = linea.split(",");

                    int id = Integer.parseInt(campos[0].trim());
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

                    documentales.add(new Documental(titulo, duracionEnMinutos, genero, tema));
                    documentales.get(id).agregarListaInvestigadores(investigadores);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void agregarElementosProduccion(int opcion, int idContenido) {
        
        if (opcion == 1) {
            peliculas.get(idContenido).agregarActor(vista.pedirDatosActor());
        }

        else if (opcion == 2) {
            seriesTV.get(idContenido).agregarTemporada(vista.pedirDatosTemporada());
        }

        else if (opcion == 3) {
            documentales.get(idContenido).agregarInvestigadores(vista.pedirDatosInvestigador());
        }
    }
}
