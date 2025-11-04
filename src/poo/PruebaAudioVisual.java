package poo;
import uni1a.*;

public class PruebaAudioVisual {
    public static void main(String[] args) {

        // Crear instancias de las subclases
        ContenidoAudiovisual[] contenidos = new ContenidoAudiovisual[5];
        contenidos[0] = new Pelicula("Avatar", 125, "Accion", "20th Century Studios");
        ((Pelicula)contenidos[0]).agregarActores("Juan");
        ((Pelicula)contenidos[0]).agregarActores("Maria");
        ((Pelicula)contenidos[0]).agregarActores("Pedro");
        contenidos[1] = new SerieDeTV("Game of Thrones", 60, "Fantasy", 1);
        ((SerieDeTV)contenidos[1]).agregarTemporada(2);
        ((SerieDeTV)contenidos[1]).agregarTemporada(3);
        contenidos[2] = new Documental("Cosmos", 45, "Science", "Astronomy");
        ((Documental)contenidos[2]).agregarInvestigadores("Pablo");
        ((Documental)contenidos[2]).agregarInvestigadores("Jose");
        contenidos[3] = new Cancion("Waka Waka", 3, "Soca", "Shakira", null);
        contenidos[4] = new VideoVertical("Viaje en POO", 10, "Entretenimiento", "TikTok", "Carlos");

        // Mostrar los detalles de cada contenido audiovisual
        for (ContenidoAudiovisual contenido : contenidos) {
            contenido.mostrarDetalles();
        }
    }
}