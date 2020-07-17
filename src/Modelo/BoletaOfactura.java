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
public class BoletaOfactura extends Tipobf2{
    private int cod_bof;
    private String folio;
    private int precio_neto;
    private int costoiva;
    private int precio_iva;
    private Date fecha;
    private Time hora;

    public BoletaOfactura() {
    }


    public BoletaOfactura(int cod_bof, String folio, int precio_neto, int costoiva, int precio_iva, Date fecha, Time hora, String nom_tipobf, String nom_metod) {
        super(nom_tipobf, nom_metod);
        this.cod_bof = cod_bof;
        this.folio = folio;
        this.precio_neto = precio_neto;
        this.costoiva = costoiva;
        this.precio_iva = precio_iva;
        this.fecha = fecha;
        this.hora = hora;
    }

    public BoletaOfactura(int cod_bof, String folio) {
        this.cod_bof = cod_bof;
        this.folio = folio;
    }
    
    

    public int getCod_bof() {
        return cod_bof;
    }

    public void setCod_bof(int cod_bof) {
        this.cod_bof = cod_bof;
    }

    public int getPrecio_neto() {
        return precio_neto;
    }

    public void setPrecio_neto(int precio_neto) {
        this.precio_neto = precio_neto;
    }

    public int getCostoiva() {
        return costoiva;
    }

    public void setCostoiva(int costoiva) {
        this.costoiva = costoiva;
    }

    public int getPrecio_iva() {
        return precio_iva;
    }

    public void setPrecio_iva(int precio_iva) {
        this.precio_iva = precio_iva;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    @Override
    public String toString(){
    return folio;
    }
    
    
}
