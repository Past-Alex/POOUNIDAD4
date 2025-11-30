package uni1a;

public class Cortometraje extends ContenidoAudiovisual {
    private String festival;

    // CONSTRUCTOR CORREGIDO: ahora recibe el 'festival'
    public Cortometraje(String titulo, int duracionEnMinutos, String genero, String festival) {
        super(titulo, duracionEnMinutos, genero);
        this.festival = festival;
    }

    public String getFestival() {
        return festival;
    }

    public void setFestival(String festival) {
        this.festival = festival;
    }

    // METODO CORREGIDO: devuelve un String en lugar de imprimir
    @Override
    public String mostrarDetalles() {
        return "Detalles del Cortometraje:\n" +
                "ID: " + getId() + "\n" +
                "Título: " + getTitulo() + "\n" +
                "Duración en minutos: " + getDuracionEnMinutos() + "\n" +
                "Género: " + getGenero() + "\n" +
                "Festival: " + this.festival;
    }
}

