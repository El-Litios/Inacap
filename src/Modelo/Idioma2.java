/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author Mark-
 */
public class Idioma2 extends Libros{
    private int cod_idioma;
    private String nom_idioma;

    public Idioma2() {
    }

    public Idioma2(String nom_idioma, String titulo_libro, int pag_libro, int precio_libro) {
        super(titulo_libro, pag_libro, precio_libro);
        this.nom_idioma = nom_idioma;
    }

    public Idioma2(String nom_idioma, String isbn_libro, String titulo_libro, int pag_libro, int precio_libro) {
        super(isbn_libro, titulo_libro, pag_libro, precio_libro);
        this.nom_idioma = nom_idioma;
    }


    public int getCod_idioma() {
        return cod_idioma;
    }

    public void setCod_idioma(int cod_idioma) {
        this.cod_idioma = cod_idioma;
    }

    public String getNom_idioma() {
        return nom_idioma;
    }

    public void setNom_idioma(String nom_idioma) {
        this.nom_idioma = nom_idioma;
    }
    
    
}
