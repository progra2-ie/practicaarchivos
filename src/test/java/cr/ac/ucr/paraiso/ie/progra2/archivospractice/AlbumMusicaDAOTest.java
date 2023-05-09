package cr.ac.ucr.paraiso.ie.progra2.archivospractice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class AlbumMusicaDAOTest {

    private static String PATH = "C:\\MyStuff\\albumes.dat";

  // @Test
    void insertar() {
        AlbumMusicaDAO albumMusicaDAO;
        try {
             albumMusicaDAO = new  AlbumMusicaDAO(PATH);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        AlbumMusica albumMusica = new AlbumMusica(170,"Green",2000);
       try {
           albumMusicaDAO.insertar(albumMusica);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }
    //@BeforeEach
   public void inserciones(){
        Path path = Path.of("C:\\MyStuff\\albumes.dat");
        try {
            if (Files.exists(path))
                    Files.delete(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        AlbumMusicaDAO albumMusicaDAO;
        try {
            albumMusicaDAO = new  AlbumMusicaDAO(PATH);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        AlbumMusica albumMusica1 = new AlbumMusica(170,"Green",2000);
        AlbumMusica albumMusica2 = new AlbumMusica(172,"Blue",2002);
        AlbumMusica albumMusica3 = new AlbumMusica(174,"Pink",2022);
        try {
            albumMusicaDAO.insertar(albumMusica1);
            albumMusicaDAO.insertar(albumMusica2);
            albumMusicaDAO.insertar(albumMusica3);
            albumMusicaDAO.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void buscar_un_registro_que_no_exista_funciona() {
       //Arrange
        inserciones();
        AlbumMusicaDAO albumMusicaDAO;
        try {
            albumMusicaDAO = new  AlbumMusicaDAO(PATH);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            //act
            AlbumMusica albumMusicaEncontrado = albumMusicaDAO.buscar(180);
            AlbumMusica albumMusicaEsperado = null;
            //assert
            Assertions.assertTrue(albumMusicaEsperado==albumMusicaEncontrado);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void buscar_un_registro_que_exista_hacia_el_final() {
        //Arrange
        inserciones();
        AlbumMusicaDAO albumMusicaDAO;
        try {
            albumMusicaDAO = new  AlbumMusicaDAO(PATH);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            //act
            AlbumMusica albumMusicaEncontrado = albumMusicaDAO.buscar(174);
            AlbumMusica albumMusicaEsperado =
                    new AlbumMusica(174,"Pink",2022);
            //assert
            Assertions.assertTrue(albumMusicaEsperado.equals(albumMusicaEncontrado));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void getAlbumes() {
    }

    @Test
    void getEmpleados() {
    }
}