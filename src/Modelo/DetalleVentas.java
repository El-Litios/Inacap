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
public class DetalleVentas extends Libros3{
    private int cod_detventa;

    public DetalleVentas() {
    }

    public DetalleVentas(int cod_detventa, String titulo_libro, int pag_libro, int precio_libro, int cod_opcion, Date fecha, Time hora, String nom_tipoo, String nom_cliente, String nom_traba) {
        super(titulo_libro, pag_libro, precio_libro, cod_opcion, fecha, hora, nom_tipoo, nom_cliente, nom_traba);
        this.cod_detventa = cod_detventa;
    }

    public DetalleVentas(int cod_detventa, String isbn_libro, String titulo_libro, int pag_libro, String cod_bof, String precio_iva, Date fecha, Time hora, String rut_cliente, String nom_cliente, String rut_traba, String nom_traba) {
        super(isbn_libro, titulo_libro, pag_libro, cod_bof, precio_iva, fecha, hora, rut_cliente, nom_cliente, rut_traba, nom_traba);
        this.cod_detventa = cod_detventa;
    }

    public DetalleVentas(int cod_detventa, String isbn_libro, String titulo_libro, int pag_libro, String folio, String precio_iva, String rut_cliente, String nom_cliente, String rut_traba, String nom_traba) {
        super(isbn_libro, titulo_libro, pag_libro, folio, precio_iva, rut_cliente, nom_cliente, rut_traba, nom_traba);
        this.cod_detventa = cod_detventa;
    }

    
   

    public int getCod_detventa() {
        return cod_detventa;
    }

    public void setCod_detventa(int cod_detventa) {
        this.cod_detventa = cod_detventa;
    }
    
    
}
