package gestion.controlador;

import gestion.documentales.modelo.DocumentalModelo;
import gestion.peliculas.modelo.PeliculaModelo;
import gestion.series.modelo.SerieTVModelo;
import gestion.vista.Vista;

public class Controlador {
    Vista vista = new Vista();
    PeliculaModelo peliculaModelo = new PeliculaModelo();
    SerieTVModelo serieTVModelo = new SerieTVModelo();
    DocumentalModelo documentalModelo = new DocumentalModelo();

    public void iniciarPrograma () {

        boolean finalizar = false;

        while (!finalizar) {

            vista.menuPrincipal();
            int opcionMenuPrincipal = vista.leerOpcion();

            switch (opcionMenuPrincipal) { // Switch de Menu Principal

                case 1: // Menu Pelicula

                    boolean regresarMenuPelicula = false;

                    while (!regresarMenuPelicula) {

                        vista.menuPelicula();
                        int opcionMenuPelicula = vista.leerOpcion();


                        switch (opcionMenuPelicula) { // Switch de Opciones Pelicula

                            case 1: // Agregar Pelicula

                                peliculaModelo.agregarPelicula(vista.pedirDatosPelicula());
                                System.out.println("");
                                System.out.println("La pelicula ha sido agregada exitosamente!");
                                break;

                            case 2: // Eliminar Pelicula

                                peliculaModelo.eliminarContenido();
                                System.out.println("");
                                System.out.println("Pelicula eliminada con exito!");
                                break;

                            case 3: // Mostrar Peliculas

                                System.out.println("");
                                System.out.println("Lista de peliculas:");
                                peliculaModelo.mostrarContenido();
                                break;

                            case 4: // Regresar a Menu Principal

                                regresarMenuPelicula = true;
                                break;
                        }
                    }

                    break; // Break de Menu Pelicula

                case 2: // Menu Serie

                    boolean regresarMenuSerie = false;

                    while (!regresarMenuSerie) {

                        vista.menuSeries();
                        int opcionMenuSeries = vista.leerOpcion();


                        switch (opcionMenuSeries) { // Switch de Opciones Serie

                            case 1: // Agregar Serie

                                serieTVModelo.agregarSerieTV(vista.pedirDatosSerie());
                                System.out.println("");
                                System.out.println("La serie ha sido agregada exitosamente!");
                                break;

                            case 2: // Eliminar Serie

                                serieTVModelo.eliminarContenido();
                                System.out.println("");
                                System.out.println("Serie eliminada con exito!");
                                break;

                            case 3: // Mostrar Serie

                                System.out.println("");
                                System.out.println("Lista de series:");
                                serieTVModelo.mostrarContenido();
                                break;

                            case 4: // Regresar a Menu Principal

                                regresarMenuSerie = true;
                                break;
                        }
                    }

                    break; // Break Menu Serie

                case 3: // Menu Documentales

                    boolean regresarMenuDocumental = false;

                    while (!regresarMenuDocumental) {

                        vista.menuDocumentales();
                        int opcionMenuDocumentales = vista.leerOpcion();


                        switch (opcionMenuDocumentales) { // Switch de Opciones Serie

                            case 1: // Agregar Documental

                                documentalModelo.agregarDocumental(vista.pedirDatosDocumental());
                                System.out.println("");
                                System.out.println("El documental ha sido agregada exitosamente!");
                                break;

                            case 2: // Eliminar Documental

                                documentalModelo.eliminarContenido();
                                System.out.println("");
                                System.out.println("Documental eliminada con exito!");
                                break;

                            case 3: // Mostrar Documental

                                System.out.println("");
                                System.out.println("Lista de documentales:");
                                documentalModelo.mostrarContenido();
                                break;

                            case 4: // Regresar a Menu Principal

                                regresarMenuDocumental = true;
                                break;
                        }
                    }

                    break; // Break Menu Documentales

                case 4: // Finalizar Programa

                    System.out.println("");
                    System.out.println("Finalizando Programa...");
                    finalizar = true;

                    break; // Break Finalizar Programa
            }
        }
    }
}
