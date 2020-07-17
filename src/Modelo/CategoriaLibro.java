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
public class CategoriaLibro extends Libros2{
    

    public CategoriaLibro() {
    }

    public CategoriaLibro(String titulo_libro, int pag_libro, int precio_libro, String nom_cate) {
        super(titulo_libro, pag_libro, precio_libro, nom_cate);
    }

    public CategoriaLibro(String isbn_libro, String titulo_libro, int pag_libro, int precio_libro, String nom_cate) {
        super(isbn_libro, titulo_libro, pag_libro, precio_libro, nom_cate);
    }

    

}
