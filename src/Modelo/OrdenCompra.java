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
public class OrdenCompra extends EstadoOC{
    private int cod_orden;
    private String folio_orden;
    private Date fecha_emision;

    public OrdenCompra() {
    }

    public OrdenCompra(int cod_orden, String folio_orden, Date fecha_emision, String nom_estado, String nom_traba, String nom_dist) {
        super(nom_estado, nom_traba, nom_dist);
        this.cod_orden = cod_orden;
        this.folio_orden = folio_orden;
        this.fecha_emision = fecha_emision;
    }

    public OrdenCompra(int cod_orden, String folio_orden) {
        this.cod_orden = cod_orden;
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
    
    @Override
    public String toString(){
        return folio_orden;
    }
    
}
