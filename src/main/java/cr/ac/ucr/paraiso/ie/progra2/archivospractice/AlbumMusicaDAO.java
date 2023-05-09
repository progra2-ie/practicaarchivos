package cr.ac.ucr.paraiso.ie.progra2.archivospractice;

import java.io.*;
import java.util.ArrayList;

public class AlbumMusicaDAO extends RandomAccessFile {

    private static int COD_ALBUM_LENGTH=4;
    private static int TITULO_LENGTH=100;
    private static int ANO_PRODUCTION_LENGTH=4;
    private static int TAMANO_REGISTRO=108;
    private String nombreArchivo;


    public AlbumMusicaDAO(String path) throws FileNotFoundException {
        super(new File(path),"rw");

    }


    public void insertar(AlbumMusica albumMusica) throws IOException{
            this.seek(this.length());
            this.writeInt(albumMusica.getCodAlbum());
            byte [] resultado= this.toBytes(albumMusica.getTitulo(), TITULO_LENGTH);
            this.write(resultado);
            this.writeInt(albumMusica.getAnoProduction());
    }

    public AlbumMusica buscar(int codAlbum) throws IOException {
        int indiceInicial = 0;
        int indiceFinal = (int) ((this.length()/TAMANO_REGISTRO)-1);
        boolean encontrado = false;
        int medio =-1;
        while (!encontrado&&indiceInicial<=indiceFinal){
            medio = (indiceInicial+indiceFinal)/2;
            this.seek(medio*TAMANO_REGISTRO);
            int codigoAlbumActual = this.readInt();
            if (codigoAlbumActual == codAlbum){
                encontrado=true;
            } else if (codAlbum < codigoAlbumActual) {
                indiceFinal= medio-1;

            }else {
                indiceInicial = medio +1;
            }

        }//while
        if (encontrado == false)
            return null;
        else {
            this.seek(medio*TAMANO_REGISTRO);
            AlbumMusica albumMusica =new AlbumMusica(
                    this.readInt(),
                    this.readString(TITULO_LENGTH, this.getFilePointer()),
                    this.readInt()
            );
            return albumMusica;
        }


    }


    public ArrayList getAlbumes(){

        return null;

    }

    private String readString(int tamanoString, long posicion) throws IOException {
        this.seek(posicion);
        byte[] datos = new byte[tamanoString];
        this.readFully(datos);
        String dato = new String(datos).trim();
        return dato;

    }

    public ArrayList<AlbumMusica> getEmpleados() throws IOException {


        return null;
    }

    private byte[] toBytes(String dato, int tamanoString){
        byte[] datos = new byte[tamanoString];
        if (dato.length() > tamanoString){
            byte[] temp = dato.getBytes();
            int i = 0;
            for (byte b : temp) {
                datos[i++] = b;
            }
        }else{
            byte temp[] = dato.getBytes();
            int i = 0;
            for (byte c : temp) {
                datos[i++] = c;
            }

        }

        return datos;
    }



}
