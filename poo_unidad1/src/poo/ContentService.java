package poo;

import uni1a.ContenidoAudiovisual;
import java.util.ArrayList;
import java.util.List;

public class ContentService {
    private final IFileHandler fileHandler;
    private List<ContenidoAudiovisual> contents;

    // DIP: Inyección de la dependencia de la abstracción IFileHandler
    public ContentService(IFileHandler fileHandler) {
        this.fileHandler = fileHandler;
        this.contents = new ArrayList<>();
    }

    public void loadData() {
        this.contents = fileHandler.loadContents();
    }

    public void saveData() {
        fileHandler.saveContents(this.contents);
    }

    public List<ContenidoAudiovisual> getAllContents() {
        return new ArrayList<>(this.contents); // Devuelve una copia para OCP
    }
    // Otros métodos de lógica de negocio...
}


