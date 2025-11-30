package poo;

import uni1a.*;

public class PruebaAudioVisual {
    public static void main(String[] args) {
        System.out.println("Hello from Eclipse!");

        // Crear instancias de las subclases
        ContenidoAudiovisual[] contenidos = new ContenidoAudiovisual[5];

        // Película con sus actores
        Pelicula pelicula = new Pelicula("Avatar", 125, "Acción", "20th Century Studios");
        pelicula.agregarActor(new Actor("Sam Worthington", "Reino Unido"));
        pelicula.agregarActor(new Actor("Zoe Saldaña", "Estados Unidos"));
        contenidos[0] = pelicula;

        // Serie de TV con sus temporadas
        SerieDeTV serieTV = new SerieDeTV("Game of Thrones", 60, "Fantasía");

        // Se crea la temporada con los parámetros en el orden correcto
        Temporada temporada1 = new Temporada(1, 2011, 10);
        serieTV.agregarTemporada(temporada1);

        Temporada temporada2 = new Temporada(2, 2012, 10);
        serieTV.agregarTemporada(temporada2);

        // Documental con sus investigadores
        Documental documental = new Documental("Cosmos", 45, "Ciencia", "Astronomía");
        documental.agregarInvestigador(new Investigador("Carl Sagan", "Astrofísica"));
        documental.agregarInvestigador(new Investigador("Neil deGrasse Tyson", "Astrofísica"));
        contenidos[2] = documental;

        // Cortometraje
        Cortometraje cortometraje = new Cortometraje("El Empleado del Mes", 15, "Comedia", "Festival de Cannes");
        contenidos[3] = cortometraje;

        // Podcast
        Podcast podcast = new Podcast("La Historia con Egorov", 60, "Historia", "Javier Egorov", "Spotify");
        contenidos[4] = podcast;

        // Mostrar los detalles de cada contenido audiovisual
        System.out.println("\n--- Lista de Contenidos Audiovisuales ---");
        for (ContenidoAudiovisual contenido : contenidos) {
            contenido.mostrarDetalles();
            System.out.println("---------------------------------");
        }
    }
}