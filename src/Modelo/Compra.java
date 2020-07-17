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
public class Compra extends OrdenCompra2{
    private int cod_compra;
    private String comentarios;

    public Compra() {
    }

    public Compra(int cod_compra, String comentarios, String folio_orden, Date fecha_emision, String nom_traba, int prec_iva, Date fec_compra, String nom_dist) {
        super(folio_orden, fecha_emision, nom_traba, prec_iva, fec_compra, nom_dist);
        this.cod_compra = cod_compra;
        this.comentarios = comentarios;
    }

    public Compra(int cod_compra, String comentarios) {
        this.cod_compra = cod_compra;
        this.comentarios = comentarios;
    }

    
    
    public int getCod_compra() {
        return cod_compra;
    }

    public void setCod_compra(int cod_compra) {
        this.cod_compra = cod_compra;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
    
}
