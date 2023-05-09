package cr.ac.ucr.paraiso.ie.progra2.archivospractice;

import java.util.Objects;

public class AlbumMusica {

    private int codAlbum;
    private String titulo;
    private int anoProduction;

    public AlbumMusica(){

    }

    public AlbumMusica(int codAlbum, String titulo, int anoProduction) {
        this.codAlbum = codAlbum;
        this.titulo = titulo;
        this.anoProduction = anoProduction;
    }

    public int getCodAlbum() {
        return codAlbum;
    }

    public void setCodAlbum(int codAlbum) {
        this.codAlbum = codAlbum;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoProduction() {
        return anoProduction;
    }

    public void setAnoProduction(int anoProduction) {
        this.anoProduction = anoProduction;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AlbumMusica that = (AlbumMusica) o;
        return codAlbum == that.codAlbum && anoProduction == that.anoProduction && Objects.equals(titulo, that.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codAlbum, titulo, anoProduction);
    }
}
