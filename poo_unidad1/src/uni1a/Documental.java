package uni1a;

import java.util.ArrayList;
import java.util.List;

// Subclase Documental que extiende de ContenidoAudiovisual
public class Documental extends ContenidoAudiovisual {
    private String tema;
    private final List<Investigador> investigadores; // Relación de agregación: un documental tiene investigadores

    public Documental(String titulo, int duracionEnMinutos, String genero, String tema) {
        super(titulo, duracionEnMinutos, genero);
        this.tema = tema;
        this.investigadores = new ArrayList<>();
    }

    // Getters y setters
    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public List<Investigador> getInvestigadores() {
        return investigadores;
    }

    public void agregarInvestigador(Investigador investigador) {
        this.investigadores.add(investigador);
    }

    @Override
    public String mostrarDetalles() {
        StringBuilder sb = new StringBuilder();
        sb.append("Detalles del Documental:\n");
        sb.append("ID: ").append(getId()).append("\n");
        sb.append("Título: ").append(getTitulo()).append("\n");
        sb.append("Duración en minutos: ").append(getDuracionEnMinutos()).append("\n");
        sb.append("Género: ").append(getGenero()).append("\n");
        sb.append("Tema: ").append(this.tema).append("\n");
        sb.append("Investigadores: ");
        if (investigadores.isEmpty()) {
            sb.append("N/A\n");
        } else {
            for (int i = 0; i < investigadores.size(); i++) {
                sb.append(investigadores.get(i).getNombre());
                if (i < investigadores.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}