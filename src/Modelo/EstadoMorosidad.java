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
public class EstadoMorosidad extends DetalleArriendo{
    private int cod_estadoM;
    private String nom_estadoM;

    public EstadoMorosidad() {
    }

    public EstadoMorosidad(String nom_estadoM, Date fecha_entrega, Date fecha_estimada) {
        super(fecha_entrega, fecha_estimada);
        this.nom_estadoM = nom_estadoM;
    }

    public EstadoMorosidad(String nom_estadoM, Date fecha_entrega, Date fecha_estimada, String isbn_libro, String titulo_libro, int pag_libro, String folio, String precio_iva, Date fecha, Time hora, String rut_cliente, String nom_cliente, String rut_traba, String nom_traba) {
        super(fecha_entrega, fecha_estimada, isbn_libro, titulo_libro, pag_libro, folio, precio_iva, fecha, hora, rut_cliente, nom_cliente, rut_traba, nom_traba);
        this.nom_estadoM = nom_estadoM;
    }

    public EstadoMorosidad(String nom_estadoM, Date fecha_entrega, Date fecha_estimada, String isbn_libro, String titulo_libro, String folio, String precio_iva, String rut_cliente, String nom_cliente, String rut_traba, String nom_traba) {
        super(fecha_entrega, fecha_estimada, isbn_libro, titulo_libro, folio, precio_iva, rut_cliente, nom_cliente, rut_traba, nom_traba);
        this.nom_estadoM = nom_estadoM;
    }

    

    public int getCod_estadoM() {
        return cod_estadoM;
    }

    public void setCod_estadoM(int cod_estadoM) {
        this.cod_estadoM = cod_estadoM;
    }

    public String getNom_estadoM() {
        return nom_estadoM;
    }

    public void setNom_estadoM(String nom_estadoM) {
        this.nom_estadoM = nom_estadoM;
    }
    
}
