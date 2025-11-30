package uni1a;

public abstract class ContenidoAudiovisual {
    protected int id;
    protected String titulo;
    protected int duracionEnMinutos;
    protected String genero;
    private static int contador = 0;

    public ContenidoAudiovisual(String titulo, int duracionEnMinutos, String genero) {
        this.id = ++contador;
        this.titulo = titulo;
        this.duracionEnMinutos = duracionEnMinutos;
        this.genero = genero;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public int getDuracionEnMinutos() { return duracionEnMinutos; }
    public String getGenero() { return genero; }

    public abstract String mostrarDetalles();
}

