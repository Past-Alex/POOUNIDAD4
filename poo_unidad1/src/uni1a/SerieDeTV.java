package uni1a;

import java.util.ArrayList;
import java.util.List;

public class SerieDeTV extends ContenidoAudiovisual {
    private List<Temporada> temporadas;

    // CONSTRUCTOR CORREGIDO: se eliminó el parámetro 'i'
    public SerieDeTV(String titulo, int duracionEnMinutos, String genero) {
        super(titulo, duracionEnMinutos, genero);
        this.temporadas = new ArrayList<>();
    }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    public void agregarTemporada(Temporada temporada) {
        this.temporadas.add(temporada);
    }

    // METODO CORREGIDO: devuelve un String en lugar de imprimir
    @Override
    public String mostrarDetalles() {
        StringBuilder sb = new StringBuilder();
        sb.append("Detalles de la Serie de TV:\n");
        sb.append("ID: ").append(getId()).append("\n");
        sb.append("Título: ").append(getTitulo()).append("\n");
        sb.append("Duración de episodio: ").append(getDuracionEnMinutos()).append(" minutos\n");
        sb.append("Género: ").append(getGenero()).append("\n");
        sb.append("Número de temporadas: ").append(this.temporadas.size()).append("\n");
        sb.append("Temporadas: \n");
        for (Temporada temporada : temporadas) {
            sb.append("  - ").append(temporada.toString()).append("\n");
        }
        return sb.toString();
    }
}