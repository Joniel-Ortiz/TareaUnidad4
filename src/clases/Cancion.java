package clases;

public class Cancion extends ContenidoAudiovisual{
    private String cantante;
    private String album;

    public Cancion(String titulo, int duracionEnMinutos, String genero, String cantante, String album) {
        super(titulo, duracionEnMinutos, genero);
        this.cantante = cantante;
        this.album = album;
    }

    public String getCantante() {
        return cantante;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("");
        System.out.println("Detalles de Cancion");
        System.out.println("ID: " + getId());
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Cantante: " + cantante);
        System.out.println("Genero: " + getGenero());
        System.out.println("Album: " + album);
        System.out.println("Duracion: " + getDuracionEnMinutos() + " minutos");
        System.out.println("");
    }


}