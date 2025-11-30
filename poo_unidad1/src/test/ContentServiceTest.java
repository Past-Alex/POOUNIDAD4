package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import poo.ContentService;
import poo.IFileHandler;
import uni1a.ContenidoAudiovisual;
import uni1a.Pelicula;
import java.util.ArrayList;
import java.util.List;

class ContentServiceTest {

    private ContentService contentService;
    private IFileHandler mockFileHandler;

    @BeforeEach
    void setUp() {
        // Se utiliza Mockito para crear un mock del IFileHandler (DIP)
        mockFileHandler = mock(IFileHandler.class);
        contentService = new ContentService(mockFileHandler);
    }

    @Test
    void testLoadData() {
        List<ContenidoAudiovisual> mockList = new ArrayList<>();

        mockList.add(new Pelicula("Test Movie", 90, "Test", "Studio A"));

        // Ahora Mockito puede resolver el método correctamente
        when(mockFileHandler.loadContents()).thenReturn(mockList);

        contentService.loadData();

        // Se verifica que el metodo del mock haya sido llamado
        verify(mockFileHandler).loadContents();
        assertEquals(1, contentService.getAllContents().size());
    }
}

