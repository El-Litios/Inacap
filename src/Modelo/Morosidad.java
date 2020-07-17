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
public class Morosidad extends EstadoMorosidad{
    private int cod_morosidad;
    private int dias_morosidad;
    private int monto_morosidad;

    public Morosidad() {
    }

    public Morosidad(int cod_morosidad, int dias_morosidad, int monto_morosidad, String nom_estadoM, Date fec_arriendo, Date fec_estimada) {
        super(nom_estadoM, fec_arriendo, fec_estimada);
        this.cod_morosidad = cod_morosidad;
        this.dias_morosidad = dias_morosidad;
        this.monto_morosidad = monto_morosidad;
    }

    public Morosidad(int cod_morosidad, int dias_morosidad, int monto_morosidad, String nom_estadoM, Date fecha_entrega, Date fecha_estimada, String isbn_libro, String titulo_libro, String folio, String precio_iva, String rut_cliente, String nom_cliente, String rut_traba, String nom_traba) {
        super(nom_estadoM, fecha_entrega, fecha_estimada, isbn_libro, titulo_libro, folio, precio_iva, rut_cliente, nom_cliente, rut_traba, nom_traba);
        this.cod_morosidad = cod_morosidad;
        this.dias_morosidad = dias_morosidad;
        this.monto_morosidad = monto_morosidad;
    }

    

    public int getCod_morosidad() {
        return cod_morosidad;
    }

    public void setCod_morosidad(int cod_morosidad) {
        this.cod_morosidad = cod_morosidad;
    }

    public int getDias_morosidad() {
        return dias_morosidad;
    }

    public void setDias_morosidad(int dias_morosidad) {
        this.dias_morosidad = dias_morosidad;
    }

    public int getMonto_morosidad() {
        return monto_morosidad;
    }

    public void setMonto_morosidad(int monto_morosidad) {
        this.monto_morosidad = monto_morosidad;
    }
    
}
