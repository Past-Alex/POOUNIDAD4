package poo;

import uni1a.ContenidoAudiovisual;
import java.util.List;

public interface IFileHandler {
    List<ContenidoAudiovisual> loadContents();
    void saveContents(List<ContenidoAudiovisual> contents);
}



