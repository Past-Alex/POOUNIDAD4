package uni1a;

public class Podcast extends ContenidoAudiovisual {
    private String host;
    private String plataforma;

    // CONSTRUCTOR CORREGIDO: ahora recibe 'plataforma'
    public Podcast(String titulo, int duracionEnMinutos, String genero, String host, String plataforma) {
        super(titulo, duracionEnMinutos, genero);
        this.host = host;
        this.plataforma = plataforma;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    // METODO CORREGIDO: devuelve un String en lugar de imprimir
    @Override
    public String mostrarDetalles() {
        return "Detalles del Podcast:\n" +
                "ID: " + getId() + "\n" +
                "Título: " + getTitulo() + "\n" +
                "Duración en minutos: " + getDuracionEnMinutos() + "\n" +
                "Género: " + getGenero() + "\n" +
                "Host: " + this.host + "\n" +
                "Plataforma: " + this.plataforma;
    }
}