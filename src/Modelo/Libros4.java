/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Mark-
 */
public class Libros4 extends Opcion{
    private int cod_libro;
    private String isbn_libro;
    private String titulo_libro;
    private int pag_libro;
    private int precio_libro;

    public Libros4() {
    }

    public Libros4(String titulo_libro, int pag_libro, int precio_libro, int cod_opcion, Date fecha, Time hora, String nom_tipoo, String nom_cliente, String nom_traba) {
        super(cod_opcion, fecha, hora, nom_tipoo, nom_cliente, nom_traba);
        this.titulo_libro = titulo_libro;
        this.pag_libro = pag_libro;
        this.precio_libro = precio_libro;
    }

    public Libros4(String isbn_libro, String titulo_libro, String cod_bof, String precio_iva, Date fecha, Time hora, String rut_cliente, String nom_cliente, String rut_traba, String nom_traba) {
        super(cod_bof, precio_iva, fecha, hora, rut_cliente, nom_cliente, rut_traba, nom_traba);
        this.isbn_libro = isbn_libro;
        this.titulo_libro = titulo_libro;
    }

    public Libros4(String isbn_libro, String titulo_libro, int pag_libro, String folio, String precio_iva, Date fecha, Time hora, String rut_cliente, String nom_cliente, String rut_traba, String nom_traba) {
        super(folio, precio_iva, fecha, hora, rut_cliente, nom_cliente, rut_traba, nom_traba);
        this.isbn_libro = isbn_libro;
        this.titulo_libro = titulo_libro;
        this.pag_libro = pag_libro;
    }

    public Libros4(String isbn_libro, String titulo_libro, String folio, String precio_iva, String rut_cliente, String nom_cliente, String rut_traba, String nom_traba) {
        super(folio, precio_iva, rut_cliente, nom_cliente, rut_traba, nom_traba);
        this.isbn_libro = isbn_libro;
        this.titulo_libro = titulo_libro;
    }

    

    public int getCod_libro() {
        return cod_libro;
    }

    public void setCod_libro(int cod_libro) {
        this.cod_libro = cod_libro;
    }

    public String getIsbn_libro() {
        return isbn_libro;
    }

    public void setIsbn_libro(String isbn_libro) {
        this.isbn_libro = isbn_libro;
    }

    public String getTitulo_libro() {
        return titulo_libro;
    }

    public void setTitulo_libro(String titulo_libro) {
        this.titulo_libro = titulo_libro;
    }

    public int getPag_libro() {
        return pag_libro;
    }

    public void setPag_libro(int pag_libro) {
        this.pag_libro = pag_libro;
    }

    public int getPrecio_libro() {
        return precio_libro;
    }

    public void setPrecio_libro(int precio_libro) {
        this.precio_libro = precio_libro;
    }
    
    
}
