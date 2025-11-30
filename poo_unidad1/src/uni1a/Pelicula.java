package uni1a;

import java.util.ArrayList;
import java.util.List;

public class Pelicula extends ContenidoAudiovisual {
    private String estudio;
    private List<Actor> actores; // Agregación

    public Pelicula(String titulo, int duracion, String genero, String estudio) {
        super(titulo, duracion, genero);
        this.estudio = estudio;
        this.actores = new ArrayList<>();
    }

    public String getEstudio() { return estudio; }
    public List<Actor> getActores() { return actores; }

    // Método para manejar la agregación (Clean Code - Nombres claros)
    public void agregarActor(Actor actor) {
        this.actores.add(actor);
    }

    @Override
    public String mostrarDetalles() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Título: %s (%s)\n", getTitulo(), getGenero()));
        sb.append(String.format("Duración: %d min\n", getDuracionEnMinutos()));
        sb.append(String.format("Estudio: %s\n", estudio));
        sb.append("Actores: ");

        // Uso de Streams para un código más funcional y limpio
        actores.forEach(actor -> sb.append(actor.getNombre()).append(", "));

        // Eliminar la última coma y espacio si hay actores
        if (!actores.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }
}