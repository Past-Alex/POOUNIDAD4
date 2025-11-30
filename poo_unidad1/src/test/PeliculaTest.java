package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import uni1a.Pelicula;
import uni1a.Actor;

class PeliculaTest {

    @Test
    void testPeliculaCreation() {
        Pelicula pelicula = new Pelicula("Avatar", 162, "Ciencia Ficcion", "20th Century Studios");
        assertNotNull(pelicula);
        assertEquals("Avatar", pelicula.getTitulo());
    }

    @Test
    void testAddActor() {
        Pelicula pelicula = new Pelicula("Avatar", 162, "Ciencia Ficcion", "20th Century Studios");
        Actor actor = new Actor("Sam Worthington", "Reino Unido");
        pelicula.agregarActor(actor);
        assertEquals(1, pelicula.getActores().size());
        assertEquals("Sam Worthington", pelicula.getActores().getFirst().getNombre());
    }

    @Test
    void testMostrarDetallesOutput() {
        Pelicula pelicula = new Pelicula("Avatar", 162, "Ciencia Ficcion", "20th Century Studios");
        Actor actor = new Actor("Zoe Saldaña", "Estados Unidos");
        pelicula.agregarActor(actor);
        String expected = "Título: Avatar (Ciencia Ficcion)\nDuración: 162 min\nEstudio: 20th Century Studios\nActores: Zoe Saldaña";
        assertEquals(expected, pelicula.mostrarDetalles());
    }
}
