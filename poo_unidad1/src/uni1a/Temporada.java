package uni1a;

public class Temporada {
    private int numeroTemporada;
    private int anioLanzamiento;
    private int numeroEpisodios;

    public Temporada(int numeroTemporada, int anioLanzamiento, int numeroEpisodios) {
        this.numeroTemporada = numeroTemporada;
        this.anioLanzamiento = anioLanzamiento;
        this.numeroEpisodios = numeroEpisodios;
    }

    // Getters y setters
    public int getNumeroTemporada() {
        return numeroTemporada;
    }

    public void setNumeroTemporada(int numeroTemporada) {
        this.numeroTemporada = numeroTemporada;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public int getNumeroEpisodios() {
        return numeroEpisodios;
    }

    public void setNumeroEpisodios(int numeroEpisodios) {
        this.numeroEpisodios = numeroEpisodios;
    }

    @Override
    public String toString() {
        return "Temporada " + numeroTemporada + " (" + anioLanzamiento + ")";
    }
}

