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
public class FacturaCompra2 extends Distribuidor {
    private int cod_fact;
    private int prec_neto;
    private int costo_iva;
    private int prec_iva;
    private Date fec_compra;

    public FacturaCompra2() {
    }

    public FacturaCompra2(int prec_iva, Date fec_compra, String nom_dist) {
        super(nom_dist);
        this.prec_iva = prec_iva;
        this.fec_compra = fec_compra;
    }

    

    public int getCod_fact() {
        return cod_fact;
    }

    public void setCod_fact(int cod_fact) {
        this.cod_fact = cod_fact;
    }

    public int getPrec_neto() {
        return prec_neto;
    }

    public void setPrec_neto(int prec_neto) {
        this.prec_neto = prec_neto;
    }

    public int getCosto_iva() {
        return costo_iva;
    }

    public void setCosto_iva(int costo_iva) {
        this.costo_iva = costo_iva;
    }

    public int getPrec_iva() {
        return prec_iva;
    }

    public void setPrec_iva(int prec_iva) {
        this.prec_iva = prec_iva;
    }

    public Date getFec_compra() {
        return fec_compra;
    }

    public void setFec_compra(Date fec_compra) {
        this.fec_compra = fec_compra;
    }
    
    
}
