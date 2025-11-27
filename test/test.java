package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import org.junit.*;
import clases.Actor;
import clases.Investigador;
import clases.Temporada;
import gestion.controlador.Controlador;
import gestion.modelos.*;
import gestion.vista.Vista;

public class test {
    
    ArrayList<Pelicula> peliculas = new ArrayList<>();
    ArrayList<SerieDeTV> series = new ArrayList<>();
    ArrayList<Documental> documentales = new ArrayList<>();
    Vista vista = new Vista();

    Controlador controlador = new Controlador(vista, peliculas, series, documentales);

    Pelicula peliculaTest = new Pelicula("Test", 70, "generoTest", "estudioTest");
    SerieDeTV serieTest = new SerieDeTV("Test", 70, "generoTest");
    Documental documentalTest = new Documental("Test", 70, "generoTest", "temaTest");

    @Test
    public void testAgregarContenido() {

        controlador.agregarContenido(1, peliculaTest);
        controlador.agregarContenido(2, serieTest);
        controlador.agregarContenido(3, documentalTest);

        assertEquals(1,peliculas.size());
        assertEquals(1, series.size());
        assertEquals(1, documentales.size());
    }

    @Test
    public void testEliminarContenido() {

        controlador.eliminarContenido(1, 0);
        controlador.eliminarContenido(2, 0);
        controlador.eliminarContenido(3, 0);

        assertEquals(0, peliculas.size());
        assertEquals(0, series.size());
        assertEquals(0, documentales.size());
    }

    @Test
    public void testMostrarContenido() {
        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            Pelicula peliculaTest = new Pelicula("TestPelicula", 70, "generoTest", "estudioTest");
            SerieDeTV serieTest = new SerieDeTV("TestSerie", 70, "generoTest");
            Documental documentalTest = new Documental("TestDocumental", 70, "generoTest", "temaTest");

            controlador.agregarContenido(1, peliculaTest);
            controlador.agregarContenido(2, serieTest);
            controlador.agregarContenido(3, documentalTest);

            controlador.mostrarContenido(1);
            controlador.mostrarContenido(2);
            controlador.mostrarContenido(3);

            String salida = outContent.toString();
            
            assertTrue(salida.contains("TestPelicula"));
            assertTrue(salida.contains("TestSerie"));
            assertTrue(salida.contains("TestDocumental"));
            
        } finally {
            System.setOut(originalOut);
        }
    }

    @Test
    public void testGuardarContenido () {
        Pelicula peliculaTest = new Pelicula("Test", 70, "generoTest", "estudioTest");
        SerieDeTV serieTest = new SerieDeTV("Test", 70, "generoTest");
        Documental documental = new Documental("Test", 70, "generoTest", "temaTest");

        controlador.agregarContenido(1, peliculaTest);
        controlador.agregarContenido(2, serieTest);
        controlador.agregarContenido(3, documental);

        controlador.guardarContenido(1);
        controlador.guardarContenido(2);
        controlador.guardarContenido(3);
        
        File peliculasFile = new File("peliculas.csv");
        File seriesTVFile = new File("seriesTV.csv");
        File documentalesFile = new File("documentales.csv");
        
        assertTrue("El archivo peliculas.csv no fue creado", peliculasFile.exists());
        assertTrue("El archivo seriesTV.csv no fue creado", seriesTVFile.exists());
        assertTrue("El archivo documentales.csv no fue creado", documentalesFile.exists());
    }

    @Test
    public void testCargarContenido() {

        Pelicula peliculaTest = new Pelicula("Test", 70, "generoTest", "estudioTest");
        SerieDeTV serieTest = new SerieDeTV("Test", 70, "generoTest");
        Documental documental = new Documental("Test", 70, "generoTest", "temaTest");

        controlador.agregarContenido(1, peliculaTest);
        controlador.agregarContenido(2, serieTest);
        controlador.agregarContenido(3, documental);

        controlador.guardarContenido(1);
        controlador.guardarContenido(2);
        controlador.guardarContenido(3);
        peliculas.clear();
        series.clear();
        documentales.clear();
        
        assertEquals(0, peliculas.size());
        assertEquals(0, series.size());
        assertEquals(0, documentales.size());
        
        controlador.cargarContenido(1);
        controlador.cargarContenido(2);
        controlador.cargarContenido(3);

        assertEquals(1, peliculas.size());
        assertEquals(1, series.size());
        assertEquals(1, documentales.size());
    }

    @Test
    public void testAgregarElementosProduccion() {

        Pelicula peliculaTest = new Pelicula("Test", 70, "generoTest", "estudioTest");
        SerieDeTV serieTest = new SerieDeTV("Test", 70, "generoTest");
        Documental documentalTest = new Documental("Test", 70, "generoTest", "temaTest");

        controlador.agregarContenido(1, peliculaTest);
        controlador.agregarContenido(2, serieTest);
        controlador.agregarContenido(3, documentalTest);

        Actor actorTest = new Actor("actorTest");
        Temporada temporadaTest = new Temporada(1);
        Investigador investigadorTest = new Investigador("investigadorTest");

        controlador.agregarElementosProduccion(1, 0, actorTest);
        controlador.agregarElementosProduccion(2, 0, temporadaTest);
        controlador.agregarElementosProduccion(3, 0, investigadorTest);

        assertEquals(1, peliculaTest.getActores().size());
        assertEquals(1, serieTest.getTemporadas().size());
        assertEquals(1, documentalTest.getInvestigadores().size());
    }
}