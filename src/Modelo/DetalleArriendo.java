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
public class DetalleArriendo extends Libros4{
    private int cod_detArriendo;
    private Date fecha_entrega;
    private Date fecha_estimada;

    public DetalleArriendo() {
    }

    public DetalleArriendo(int cod_detArriendo, Date fecha_estimada, String isbn_libro, String titulo_libro, int pag_libro, String folio, String precio_iva, Date fecha, Time hora, String rut_cliente, String nom_cliente, String rut_traba, String nom_traba) {
        super(isbn_libro, titulo_libro, pag_libro, folio, precio_iva, fecha, hora, rut_cliente, nom_cliente, rut_traba, nom_traba);
        this.cod_detArriendo = cod_detArriendo;
        this.fecha_estimada = fecha_estimada;
    }

    public DetalleArriendo(int cod_detArriendo, Date fecha_entrega, Date fecha_estimada, String isbn_libro, String titulo_libro, int pag_libro, String folio, String precio_iva, Date fecha, Time hora, String rut_cliente, String nom_cliente, String rut_traba, String nom_traba) {
        super(isbn_libro, titulo_libro, pag_libro, folio, precio_iva, fecha, hora, rut_cliente, nom_cliente, rut_traba, nom_traba);
        this.cod_detArriendo = cod_detArriendo;
        this.fecha_entrega = fecha_entrega;
        this.fecha_estimada = fecha_estimada;
    }

    public DetalleArriendo(Date fecha_entrega, Date fecha_estimada, String isbn_libro, String titulo_libro, int pag_libro, String folio, String precio_iva, Date fecha, Time hora, String rut_cliente, String nom_cliente, String rut_traba, String nom_traba) {
        super(isbn_libro, titulo_libro, pag_libro, folio, precio_iva, fecha, hora, rut_cliente, nom_cliente, rut_traba, nom_traba);
        this.fecha_entrega = fecha_entrega;
        this.fecha_estimada = fecha_estimada;
    }


    public DetalleArriendo(Date fecha_entrega, Date fecha_estimada) {
        this.fecha_entrega = fecha_entrega;
        this.fecha_estimada = fecha_estimada;
    }

    public DetalleArriendo(Date fecha_entrega, Date fecha_estimada, String isbn_libro, String titulo_libro, String folio, String precio_iva, String rut_cliente, String nom_cliente, String rut_traba, String nom_traba) {
        super(isbn_libro, titulo_libro, folio, precio_iva, rut_cliente, nom_cliente, rut_traba, nom_traba);
        this.fecha_entrega = fecha_entrega;
        this.fecha_estimada = fecha_estimada;
    }

 
    public int getCod_detArriendo() {
        return cod_detArriendo;
    }

    public void setCod_detArriendo(int cod_detArriendo) {
        this.cod_detArriendo = cod_detArriendo;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public Date getFecha_estimada() {
        return fecha_estimada;
    }

    public void setFecha_estimada(Date fecha_estimada) {
        this.fecha_estimada = fecha_estimada;
    }
    
    
}
