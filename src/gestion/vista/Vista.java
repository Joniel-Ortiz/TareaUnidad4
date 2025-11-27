package gestion.vista;

import gestion.controlador.Controlador;
import gestion.modelos.Documental;
import gestion.modelos.Pelicula;
import gestion.modelos.SerieDeTV;
import clases.*;
import java.util.Scanner;

public class Vista {

    Scanner sc = new Scanner(System.in);
    Controlador controlador = new Controlador();

    public void menuPrincipal() {

        boolean finalizar = false;

        while(!finalizar) {
            System.out.println("");
            System.out.println("Elige la opcion que deseas:");
            System.out.println("1. Agregar contenido");
            System.out.println("2. Eliminar Contenido");
            System.out.println("3. Elementos de produccion");
            System.out.println("4. Mostrar contenido");
            System.out.println("5. Guardar archivo");
            System.out.println("6. Cargar archivo");
            System.out.println("7. Finalizar programa");
            System.out.println("");
            System.out.print("Opcion: ");

            int opcion = leerOpcion();

            switch(opcion) {
                case 1:
                    menuAgregar();
                    break;
                case 2:
                    menuEliminar();
                    break;
                case 3:
                    menuElementosProduccion();
                    break;
                case 4:
                    menuMostrarContenido();
                    break;
                case 5:
                    menuGuardarArchivos();
                    break;
                case 6:
                    menuCargarArchivos();
                    break;    
                case 7:
                    finalizar = true;
                    System.out.println("");
                    System.out.println("Finalizando programa...");
                    System.out.println("");
                    break;
                default:
                    System.out.println("");
                    System.out.println("Opcion no valida, intenta de nuevo.");
                    break;
            }
        }
    }

    public void menuAgregar() {

        boolean regresar = false;

        while (!regresar) {
            System.out.println("");
            System.out.println("Elige el tipo de contenido que deseas agregar:");
            System.out.println("1. Pelicula");
            System.out.println("2. Serie de TV");
            System.out.println("3. Documental");
            System.out.println("4. Regresar");
            System.out.println("");
            System.out.print("Opcion: ");
            int opcion = leerOpcion();

            if (opcion > 0 && opcion < 4) {
                pedirDatosContenido(opcion);
                System.out.println("");
                System.out.println("Contenido agregado exitosamente!");
            }

            else if (opcion == 4) {
                regresar = true;
            }

            else {
                System.out.println("");
                System.out.println("Opcion no valida, intenta de nuevo.");
            }
        }
    }

    public void menuEliminar() {

        boolean regresar = false;

        while (!regresar) {
            System.out.println("");
            System.out.println("Elige el tipo de contenido que deseas eliminar:");
            System.out.println("1. Pelicula");
            System.out.println("2. Serie de TV");
            System.out.println("3. Documental");
            System.out.println("4. Regresar");
            System.out.println("");
            System.out.print("Opcion: ");
            int opcion = leerOpcion();

            if (opcion > 0 && opcion < 4) {

                System.out.println("");
                System.out.println("Escribe el ID del contenido que deseas eliminar: ");
                controlador.mostrarContenido(opcion);  
                System.out.println(""); 
                System.out.print("ID: ");
                int id = leerOpcion();
                controlador.eliminarContenido(opcion,id);     
                System.out.println("");
                System.out.println("Contenido eliminado exitosamente!");
            }

            else if (opcion == 4) {
                regresar = true;
            }

            else {
                System.out.println("");
                System.out.println("Opcion no valida, intenta de nuevo.");
            }
        }
    }

    public void menuMostrarContenido() {

        boolean regresar = false;

        while (!regresar) {
            System.out.println("");
            System.out.println("Elige el tipo de contenido que deseas mostrar:");
            System.out.println("1. Pelicula");
            System.out.println("2. Serie de TV");
            System.out.println("3. Documental");
            System.out.println("4. Regresar");
            System.out.println("");
            System.out.print("Opcion: ");
            int opcion = leerOpcion();

            if (opcion > 0 && opcion < 4) {
                controlador.mostrarContenido(opcion);
            }

            else if (opcion == 4) {
                regresar = true;
            }

            else {
                System.out.println("");
                System.out.println("Opcion no valida, intenta de nuevo.");
            }
        }
    }

    public void menuGuardarArchivos () {

        boolean regresar = false;

        while(!regresar) {
            System.out.println("");
            System.out.println("Elige el tipo de contenido que deseas guardar:");
            System.out.println("1. Pelicula");
            System.out.println("2. Serie de TV");
            System.out.println("3. Documental");
            System.out.println("4. Regresar");
            System.out.println("");
            System.out.print("Opcion: ");
            int opcion = leerOpcion();

            if (opcion > 0 && opcion < 4) {
                controlador.guardarContenido(opcion);
                System.out.println("");
                System.out.println("Archivo guardado exitosamente!");
            }

            else if (opcion == 4) {
                regresar = true;
            }

            else {
                System.out.println("");
                System.out.println("Opcion no valida, intenta de nuevo.");
            }
        }
    }

    public void menuCargarArchivos () {

        boolean regresar = false;

        while(!regresar) {
            System.out.println("");
            System.out.println("Elige el tipo de contenido que deseas cargar:");
            System.out.println("1. Pelicula");
            System.out.println("2. Serie de TV");
            System.out.println("3. Documental");
            System.out.println("4. Regresar");
            System.out.println("");
            System.out.print("Opcion: ");
            int opcion = leerOpcion();

            if (opcion > 0 && opcion < 4) {
                controlador.cargarContenido(opcion);
                System.out.println("");
                System.out.println("Archivo cargado exitosamente!");
            }

            else if (opcion == 4) {
                regresar = true;
            }

            else {
                System.out.println("");
                System.out.println("Opcion no valida, intenta de nuevo.");
            }
        }
    }

    public void menuElementosProduccion() {
        
        boolean regresar = false;

        while (!regresar) {
            System.out.println("");
            System.out.println("Elige la opcion que deseas:");
            System.out.println("1. Agregar Actores");
            System.out.println("2. Agregar Temporadas");
            System.out.println("3. Agregar Investigadores");
            System.out.println("4. Regresar");
            System.out.println("");
            System.out.print("Opcion: ");
            int opcion = leerOpcion();

            if (opcion > 0 && opcion < 4) {

                System.out.println("");
                System.out.println("Escoge el ID del contenido: ");
                controlador.mostrarContenido(opcion);
                System.out.println("");
                System.out.print("ID: ");
                int idContenido = leerOpcion();
                pedirDatosElementos(opcion, idContenido);
                System.out.println("");
                System.out.println("Elemento agregado con exito!");
            }

            else if (opcion == 4) {
                regresar = true;
            }

            else {
                System.out.println("");
                System.out.println("Opcion no valida, intenta de nuevo.");
            }

        } 
    }

    public int leerOpcion() {
        return sc.nextInt();
    }

    public void pedirDatosContenido(int opcion) {
        
        if (opcion == 1) {
            System.out.println("");
            System.out.print("Titulo: ");
            String titulo = sc.next();
            System.out.print("Duracion en minutos: ");
            int duracionEnMinutos = sc.nextInt();
            System.out.print("Genero: ");
            String genero = sc.next();
            System.out.print("Estudio: ");
            String estudio = sc.next();

            Pelicula pelicula = new Pelicula(titulo, duracionEnMinutos, genero, estudio);
            controlador.agregarContenido(opcion, pelicula);
        }
        else if (opcion == 2) {
            System.out.println("");
            System.out.print("Titulo: ");
            String titulo = sc.next();
            System.out.print("Duracion en minutos: ");
            int duracionEnMinutos = sc.nextInt();
            System.out.print("Genero: ");
            String genero = sc.next();

            SerieDeTV serieTV = new SerieDeTV(titulo, duracionEnMinutos, genero);
            controlador.agregarContenido(opcion, serieTV);
        }
        else if (opcion == 3) {
            System.out.println("");
            System.out.print("Titulo: ");
            String titulo = sc.next();
            System.out.print("Duracion en minutos: ");
            int duracionEnMinutos = sc.nextInt();
            System.out.print("Genero: ");
            String genero = sc.next();
            System.out.print("Tema: ");
            String tema = sc.next();

            Documental documental = new Documental(titulo, duracionEnMinutos, genero, tema);
            controlador.agregarContenido(opcion, documental);
        }
    }

    public void pedirDatosElementos (int opcion, int id) {
        
        if (opcion == 1) {
            System.out.println("");
            System.out.print("Nombre: ");
            String nombre = sc.next();

            Actor actor = new Actor(nombre);
            controlador.agregarElementosProduccion(opcion, id, actor);
        }

        else if (opcion == 2) {
            System.out.println("");
            System.out.print("Numero de temporada: ");
            int numeroTemporada = sc.nextInt();

            Temporada temporada = new Temporada(numeroTemporada);
            controlador.agregarElementosProduccion(opcion, id, temporada);
        }
        
        else if (opcion == 3) {
            System.out.println("");
            System.out.print("Nombre: ");
            String nombre = sc.next();

            Investigador investigador = new Investigador(nombre);
            controlador.agregarElementosProduccion(opcion, id, investigador);
        }
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
}