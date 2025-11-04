package uni1a;

public class VideoVertical extends ContenidoAudiovisual {
    private String plataforma;
    private String creador;

    public VideoVertical(String titulo, int duracionEnMinutos, String genero, String plataforma, String creador) {
        super(titulo, duracionEnMinutos, genero);
        this.plataforma = plataforma;
        this.creador = creador;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("");
        System.out.println("Detalles de Video:");
        System.out.println("ID: " + getId());
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Creador: " + creador);
        System.out.println("Plataforma: " + plataforma);
        System.out.println("Genero: " + getGenero());
        System.out.println("Duracion: " + getDuracionEnMinutos() + " minutos");
        System.out.println("");
    }
}
