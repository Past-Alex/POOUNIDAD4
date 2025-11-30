package poo;

import uni1a.ContenidoAudiovisual;
import uni1a.Cortometraje;
import uni1a.Documental;
import uni1a.Pelicula;
import uni1a.Podcast;
import uni1a.SerieDeTV;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvFileHandler implements IFileHandler {
    private static final String CONTENTS_FILE = "data/contenidos.csv";

    @Override
    public List<ContenidoAudiovisual> loadContents() {
        List<ContenidoAudiovisual> contents = new ArrayList<>();
        System.out.println("Cargando datos desde archivos CSV...");

        try (BufferedReader reader = new BufferedReader(new FileReader(CONTENTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String type = data[0].trim();

                try {
                    switch (type) {
                        case "Pelicula":
                            contents.add(new Pelicula(
                                    data[1].trim(), // titulo
                                    Integer.parseInt(data[2].trim()), // duracionEnMinutos
                                    data[3].trim(), // genero
                                    data[4].trim()  // estudio
                            ));
                            break;
                        case "SerieDeTV":
                            contents.add(new SerieDeTV(
                                    data[1].trim(), // titulo
                                    Integer.parseInt(data[2].trim()), // duracionEnMinutos
                                    data[3].trim()// genero
                            ));
                            break;
                        case "Documental":
                            contents.add(new Documental(
                                    data[1].trim(), // titulo
                                    Integer.parseInt(data[2].trim()), // duracionEnMinutos
                                    data[3].trim(), // genero
                                    data[4].trim()  // tema
                            ));
                            break;
                        case "Cortometraje":
                            contents.add(new Cortometraje(
                                    data[1].trim(), // titulo
                                    Integer.parseInt(data[2].trim()), // duracionEnMinutos
                                    data[3].trim(),  // genero
                                    data[4].trim()
                            ));
                            break;
                        case "Podcast":
                            contents.add(new Podcast(
                                    data[1].trim(), // titulo
                                    Integer.parseInt(data[2].trim()), // duracionEnMinutos
                                    data[3].trim(), // genero
                                    data[4].trim(),  // plataforma
                                    data[5].trim()
                            ));
                            break;
                        default:
                            System.err.println("Tipo de contenido desconocido: " + type);
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error de formato numérico en la línea: " + line);
                }
            }
            System.out.println("Datos cargados correctamente.");
        } catch (FileNotFoundException e) {
            System.err.println("Error: Archivo de contenidos no encontrado. Asegúrate de que existe: " + CONTENTS_FILE);
        } catch (IOException e) {
            System.err.println("Error de lectura del archivo: " + e.getMessage());
        }
        return contents;
    }

    @Override
    public void saveContents(List<ContenidoAudiovisual> contents) {
        System.out.println("Guardando datos en archivos CSV...");

        // Verifica si la carpeta 'data' existe, si no, la crea.
        File directory = new File("data");
        if (!directory.exists()) {
            directory.mkdir();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CONTENTS_FILE))) {
            for (ContenidoAudiovisual content : contents) {
                if (content instanceof Pelicula) {
                    Pelicula p = (Pelicula) content;
                    writer.write("Pelicula," + p.getTitulo() + "," + p.getDuracionEnMinutos() + "," + p.getGenero() + "," + p.getEstudio());
                } else if (content instanceof SerieDeTV) {
                    SerieDeTV s = (SerieDeTV) content;
                    writer.write("SerieDeTV," + s.getTitulo() + "," + s.getDuracionEnMinutos() + "," + s.getGenero() + "," + s.getTemporadas());
                } else if (content instanceof Documental) {
                    Documental d = (Documental) content;
                    writer.write("Documental," + d.getTitulo() + "," + d.getDuracionEnMinutos() + "," + d.getGenero() + "," + d.getTema());
                } else if (content instanceof Cortometraje) {
                    Cortometraje c = (Cortometraje) content;
                    writer.write("Cortometraje," + c.getTitulo() + "," + c.getDuracionEnMinutos() + "," + c.getGenero());
                } else if (content instanceof Podcast) {
                    Podcast po = (Podcast) content;
                    writer.write("Podcast," + po.getTitulo() + "," + po.getDuracionEnMinutos() + "," + po.getGenero() + "," + po.getPlataforma());
                }
                writer.newLine();
            }
            System.out.println("Datos guardados correctamente.");
        } catch (IOException e) {
            System.err.println("Error de escritura en el archivo: " + e.getMessage());
        }
    }
}