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
public class Opcion extends BoletaOfactura2{
    private int cod_opcion;

    public Opcion() {
    }

    public Opcion(int cod_opcion, Date fecha, Time hora, String nom_tipoo, String nom_cliente, String nom_traba) {
        super(fecha, hora, nom_tipoo, nom_cliente, nom_traba);
        this.cod_opcion = cod_opcion;
    }

    public Opcion(int cod_opcion,String folio, String precio_iva, Date fecha, Time hora, String rut_cliente, String nom_cliente, String rut_traba, String nom_traba) {
        super(folio, precio_iva, fecha, hora, rut_cliente, nom_cliente, rut_traba, nom_traba);
        this.cod_opcion = cod_opcion;
    }

    public Opcion(String folio, String precio_iva, Date fecha, Time hora, String rut_cliente, String nom_cliente, String rut_traba, String nom_traba) {
        super(folio, precio_iva, fecha, hora, rut_cliente, nom_cliente, rut_traba, nom_traba);
    }

    public Opcion(int cod_opcion, String folio) {
        super(folio);
        this.cod_opcion = cod_opcion;
    }

    public Opcion(String folio, String precio_iva, String rut_cliente, String nom_cliente, String rut_traba, String nom_traba) {
        super(folio, precio_iva, rut_cliente, nom_cliente, rut_traba, nom_traba);
    }

   
    

    public int getCod_opcion() {
        return cod_opcion;
    }

    public void setCod_opcion(int cod_opcion) {
        this.cod_opcion = cod_opcion;
    }
    
    
}
