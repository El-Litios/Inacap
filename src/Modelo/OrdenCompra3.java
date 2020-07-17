/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.sql.Date;

/**
 *
 * @author Mark-
 */
public class OrdenCompra3 extends Libros{
    private int cod_orden;
    private String folio_orden;
    private Date fecha_emision;

    public OrdenCompra3() {
    }

    public OrdenCompra3(String folio_orden, String titulo_libro) {
        super(titulo_libro);
        this.folio_orden = folio_orden;
    }

    public int getCod_orden() {
        return cod_orden;
    }

    public void setCod_orden(int cod_orden) {
        this.cod_orden = cod_orden;
    }

    public String getFolio_orden() {
        return folio_orden;
    }

    public void setFolio_orden(String folio_orden) {
        this.folio_orden = folio_orden;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }
    
    
}
