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
public class BoletaOfactura2 extends TipoOpcion{
    private String cod_bof;
    private String folio;
    private int precio_neto;
    private int costoiva;
    private String precio_iva;
    private Date fecha;
    private Time hora;

    public BoletaOfactura2() {
    }


    public BoletaOfactura2(Date fecha, Time hora, String nom_tipoo, String nom_cliente, String nom_traba) {
        super(nom_tipoo, nom_cliente, nom_traba);
        this.fecha = fecha;
        this.hora = hora;
    }

    public BoletaOfactura2(String folio, String precio_iva, Date fecha, Time hora, String nom_tipoo, String nom_cliente, String nom_traba) {
        super(nom_tipoo, nom_cliente, nom_traba);
        this.folio = folio;
        this.precio_iva = precio_iva;
        this.fecha = fecha;
        this.hora = hora;
    }

    public BoletaOfactura2(String folio, String precio_iva, Date fecha, Time hora, String rut_cliente, String nom_cliente, String rut_traba, String nom_traba) {
        super(rut_cliente, nom_cliente, rut_traba, nom_traba);
        this.folio = folio;
        this.precio_iva = precio_iva;
        this.fecha = fecha;
        this.hora = hora;
    }

    public BoletaOfactura2(String folio) {
        this.folio = folio;
    }

    public BoletaOfactura2(String folio, String precio_iva, String rut_cliente, String nom_cliente, String rut_traba, String nom_traba) {
        super(rut_cliente, nom_cliente, rut_traba, nom_traba);
        this.folio = folio;
        this.precio_iva = precio_iva;
    }


    
    
    public String getCod_bof() {
        return cod_bof;
    }

    public void setCod_bof(String cod_bof) {
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

    public String getPrecio_iva() {
        return precio_iva;
    }

    public void setPrecio_iva(String precio_iva) {
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
