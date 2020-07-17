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
public class IdiomaLibro extends Idioma2 {
    

    public IdiomaLibro() {
    }

    public IdiomaLibro(String nom_idioma, String titulo_libro, int pag_libro, int precio_libro) {
        super(nom_idioma, titulo_libro, pag_libro, precio_libro);
    } 

    public IdiomaLibro(String nom_idioma, String isbn_libro, String titulo_libro, int pag_libro, int precio_libro) {
        super(nom_idioma, isbn_libro, titulo_libro, pag_libro, precio_libro);
    }
    
    
    
}
