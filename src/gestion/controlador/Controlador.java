package gestion.controlador;

import gestion.documentales.modelo.Documental;
import gestion.peliculas.modelo.Pelicula;
import gestion.series.modelo.SerieDeTV;
import gestion.vista.Vista;
import java.io.*;
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

    public void guardarContenido(int opcion) {

        if (opcion == 1) {
            try(BufferedWriter writerPelicula = new BufferedWriter(new FileWriter("peliculas.txt"))) {
                for (Pelicula indice : peliculas) {
                    writerPelicula.write(indice.toString());
                    writerPelicula.newLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else if (opcion == 2) {
            try(BufferedWriter writerSerie = new BufferedWriter(new FileWriter("seriesTV.txt"))) {
                for (SerieDeTV indice : seriesTV) {
                    writerSerie.write(indice.toString());
                    writerSerie.newLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else if (opcion == 3) {
            try(BufferedWriter writerDocumental = new BufferedWriter(new FileWriter("documentales.txt"))) {
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

        if (opcion == 1) {

            try(Scanner scanner = new Scanner(new FileReader("C:\\Users\\ortiz\\IdeaProjects\\TareaUnidad4\\peliculas.txt"))) {;

                String titulo = null;
                int duracionEnMinutos = 0;
                String genero = null;
                String estudio = null;

                scanner.useDelimiter(",|\\R");

                while (scanner.hasNext()) {

                    titulo = scanner.next().trim();
                    duracionEnMinutos = scanner.nextInt();
                    genero = scanner.next().trim();
                    estudio = scanner.next().trim();

                    peliculas.add(new Pelicula(titulo, duracionEnMinutos, genero, estudio));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (opcion == 2) {

            try(Scanner scanner = new Scanner(new FileReader("C:\\Users\\ortiz\\IdeaProjects\\TareaUnidad4\\seriesTV.txt"))) {;

                String titulo = null;
                int duracionEnMinutos = 0;
                String genero = null;
                int temporadas = 0;

                scanner.useDelimiter(",|\\R");

                while (scanner.hasNext()) {

                    titulo = scanner.next().trim();
                    duracionEnMinutos = scanner.nextInt();
                    genero = scanner.next().trim();
                    temporadas = scanner.nextInt();

                    seriesTV.add(new SerieDeTV(titulo, duracionEnMinutos, genero, temporadas));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (opcion == 3) {

            try(Scanner scanner = new Scanner(new FileReader("C:\\Users\\ortiz\\IdeaProjects\\TareaUnidad4\\documentales.txt"))) {;

                String titulo = null;
                int duracionEnMinutos = 0;
                String genero = null;
                String tema = null;

                scanner.useDelimiter(",|\\R");

                while (scanner.hasNext()) {

                    titulo = scanner.next().trim();
                    duracionEnMinutos = scanner.nextInt();
                    genero = scanner.next().trim();
                    tema = scanner.next().trim();

                    documentales.add(new Documental(titulo, duracionEnMinutos, genero, tema));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

