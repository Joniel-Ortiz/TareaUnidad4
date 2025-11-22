package gestion.vista;

import gestion.controlador.Controlador;
import gestion.documentales.modelo.Documental;
import gestion.peliculas.modelo.Pelicula;
import gestion.series.modelo.SerieDeTV;
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
            System.out.println("3. Mostrar contenido");
            System.out.println("4. Guardar archivo");
            System.out.println("5. Cargar archivo");
            System.out.println("6. Finalizar programa");
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
                    menuMostrarContenido();
                    break;
                case 4:
                    menuGuardarArchivos();
                    break;
                case 5:
                    menuCargarArchivos();
                    break;
                case 6:
                    finalizar = true;
                    System.out.println("");
                    System.out.println("Finalizando programa...");
                    break;
                default:
                    System.out.println("");
                    System.out.println("Opcion no valida, intenta de nuevo.");
                    break;
            }
        }
    }

    public void menuAgregar() {

        boolean regresarMenuAgregar = false;

        while (!regresarMenuAgregar) {
            System.out.println("");
            System.out.println("Elige el tipo de contenido que deseas agregar:");
            System.out.println("1. Pelicula");
            System.out.println("2. Serie de TV");
            System.out.println("3. Documental");
            System.out.println("4. Regresar");
            System.out.println("");
            System.out.print("Opcion: ");
            int opcionAgregar = leerOpcion();

            if (opcionAgregar > 0 && opcionAgregar < 4) {
                controlador.agregarContenido(opcionAgregar);
                System.out.println("");
                System.out.println("Contenido agregado exitosamente!");
            }

            else if (opcionAgregar == 4) {
                regresarMenuAgregar = true;
            }

            else {
                System.out.println("");
                System.out.println("Opcion no valida, intenta de nuevo.");
            }
        }
    }

    public void menuEliminar() {

        boolean regresarMenuEliminar = false;

        while (!regresarMenuEliminar) {
            System.out.println("");
            System.out.println("Elige el tipo de contenido que deseas eliminar:");
            System.out.println("1. Pelicula");
            System.out.println("2. Serie de TV");
            System.out.println("3. Documental");
            System.out.println("4. Regresar");
            System.out.println("");
            System.out.print("Opcion: ");

            int opcionEliminar = leerOpcion();

            if (opcionEliminar > 0 && opcionEliminar < 4) {
                controlador.mostrarContenido(opcionEliminar);
                System.out.println("");
                System.out.println("Escribe el ID del contenido que deseas eliminar: ");
                System.out.println("");
                System.out.print("Opcion: ");
                controlador.eliminarContenido(opcionEliminar);
                System.out.println("");
                System.out.println("Contenido eliminado exitosamente!");
            }

            else if (opcionEliminar == 4) {
                regresarMenuEliminar = true;
            }

            else {
                System.out.println("");
                System.out.println("Opcion no valida, intenta de nuevo.");
            }
        }
    }

    public void menuMostrarContenido() {

        boolean regresarMenuMostrar = false;

        while (!regresarMenuMostrar) {
            System.out.println("");
            System.out.println("Elige el tipo de contenido que deseas mostrar:");
            System.out.println("1. Pelicula");
            System.out.println("2. Serie de TV");
            System.out.println("3. Documental");
            System.out.println("4. Regresar");
            System.out.println("");
            System.out.print("Opcion: ");
            int opcionMostrar = leerOpcion();

            if (opcionMostrar > 0 && opcionMostrar < 4) {
                controlador.mostrarContenido(opcionMostrar);
            }

            else if (opcionMostrar == 4) {
                regresarMenuMostrar = true;
            }

            else {
                System.out.println("");
                System.out.println("Opcion no valida, intenta de nuevo.");
            }
        }
    }

    public void menuGuardarArchivos () {

        boolean regresarMenuGuardar = false;

        while(!regresarMenuGuardar) {
            System.out.println("");
            System.out.println("Elige el tipo de contenido que deseas guardar:");
            System.out.println("1. Pelicula");
            System.out.println("2. Serie de TV");
            System.out.println("3. Documental");
            System.out.println("4. Regresar");
            System.out.println("");
            System.out.print("Opcion: ");
            int opcionGuardar = leerOpcion();

            if (opcionGuardar > 0 && opcionGuardar < 4) {
                controlador.guardarContenido(opcionGuardar);
                System.out.println("");
                System.out.println("Archivo guardado exitosamente!");
            }

            else if (opcionGuardar == 4) {
                regresarMenuGuardar = true;
            }

            else {
                System.out.println("");
                System.out.println("Opcion no valida, intenta de nuevo.");
            }
        }
    }

    public void menuCargarArchivos () {

        boolean regresarMenuCargar = false;

        while(!regresarMenuCargar) {
            System.out.println("");
            System.out.println("Elige el tipo de contenido que deseas cargar:");
            System.out.println("1. Pelicula");
            System.out.println("2. Serie de TV");
            System.out.println("3. Documental");
            System.out.println("4. Regresar");
            System.out.println("");
            System.out.print("Opcion: ");
            int opcionCargar = leerOpcion();

            if (opcionCargar > 0 && opcionCargar < 4) {
                controlador.cargarContenido(opcionCargar);
                System.out.println("");
                System.out.println("Archivo cargado exitosamente!");
            }

            else if (opcionCargar == 4) {
                regresarMenuCargar = true;
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

    public Pelicula pedirDatosPelicula() {
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
        return pelicula;
    }

    public SerieDeTV pedirDatosSerieTV() {
        System.out.println("");
        System.out.print("Titulo: ");
        String titulo = sc.next();
        System.out.print("Duracion en minutos: ");
        int duracionEnMinutos = sc.nextInt();
        System.out.print("Genero: ");
        String genero = sc.next();
        System.out.print("Temporadas: ");
        int temporadas = sc.nextInt();

        SerieDeTV serieTV = new SerieDeTV(titulo, duracionEnMinutos, genero, temporadas);
        return serieTV;
    }

    public Documental pedirDatosDocumental() {
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
        return documental;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }
}
