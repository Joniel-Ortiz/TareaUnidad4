package gestion.vista;

import gestion.documentales.modelo.Documental;
import gestion.peliculas.modelo.Pelicula;
import gestion.series.modelo.SerieDeTV;
import java.util.Scanner;

public class Vista {

    Scanner sc = new Scanner(System.in);

    public void menuPrincipal () {

        System.out.println("");
        System.out.println("Elige la opcion que deseas:");
        System.out.println("1. Peliculas");
        System.out.println("2. Series de TV");
        System.out.println("3. Documentales");
        System.out.println("4. Finalizar programa");
        System.out.println("");
        System.out.print("Opcion: ");

    }

    public void menuPelicula () {
        System.out.println("");
        System.out.println("Elige la opcion que deseas:");
        System.out.println("1. Agregar pelicula");
        System.out.println("2. Eliminar pelicula");
        System.out.println("3. Mostrar lista de peliculas");
        System.out.println("4. Regresar");
        System.out.println("");
        System.out.print("Opcion: ");
    }

    public void menuSeries () {
        System.out.println("");
        System.out.println("Elige la opcion que deseas:");
        System.out.println("1. Agregar Serie de TV");
        System.out.println("2. Eliminar Serie de TV");
        System.out.println("3. Mostrar lista de Series de TV");
        System.out.println("4. Regresar");
        System.out.println("");
        System.out.print("Opcion: ");
    }

    public void menuDocumentales () {
        System.out.println("");
        System.out.println("Elige la opcion que deseas:");
        System.out.println("1. Agregar Documental");
        System.out.println("2. Eliminar Documental");
        System.out.println("3. Mostrar lista de Documentals");
        System.out.println("4. Regresar");
        System.out.println("");
        System.out.print("Opcion: ");
    }

    public int leerOpcion() {
        int opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }

    public Pelicula pedirDatosPelicula() {

        System.out.println("");
        System.out.print("Introduce el titulo: ");
        String titulo = sc.nextLine();
        System.out.print("Introduce la duracion en minutos: ");
        int duracion = sc.nextInt();
        sc.nextLine();
        System.out.print("Introduce el genero: ");
        String genero = sc.nextLine();
        System.out.print("Introduce el nombre del estudio: ");
        String estudio =  sc.nextLine();

        return new Pelicula(titulo, duracion, genero, estudio);
    }
    
    public SerieDeTV pedirDatosSerie() {
        System.out.println("");
        System.out.print("Introduce el titulo: ");
        String titulo = sc.nextLine();
        System.out.print("Introduce la duracion en minutos: ");
        int duracion = sc.nextInt();
        sc.nextLine();
        System.out.print("Introduce el genero: ");
        String genero = sc.nextLine();

        return new SerieDeTV(titulo,duracion,genero);
    }

    public Documental pedirDatosDocumental() {
        System.out.println("");
        System.out.print("Introduce el titulo: ");
        String titulo = sc.nextLine();
        System.out.print("Introduce la duracion en minutos: ");
        int duracion = sc.nextInt();
        sc.nextLine();
        System.out.print("Introduce el genero: ");
        String genero = sc.nextLine();
        System.out.print("Introduce el tema: ");
        String tema = sc.nextLine();

        return new Documental(titulo,duracion,genero,tema);
    }


}
