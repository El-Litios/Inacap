/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author Mark-
 */
public class TipoOpcion extends Cliente2{
    private int cod_tipoo;
    private String nom_tipoo;

    public TipoOpcion() {
    }

    public TipoOpcion(int cod_tipoo, String nom_tipoo) {
        this.cod_tipoo = cod_tipoo;
        this.nom_tipoo = nom_tipoo;
    }

    public TipoOpcion(String nom_tipoo) {
        this.nom_tipoo = nom_tipoo;
    }

    public TipoOpcion(String nom_tipoo, String nom_cliente, String nom_traba) {
        super(nom_cliente, nom_traba);
    }

    public TipoOpcion(String rut_cliente, String nom_cliente, String rut_traba, String nom_traba) {
        super(rut_cliente, nom_cliente, rut_traba, nom_traba);
    }
    
    

    public int getCod_tipoo() {
        return cod_tipoo;
    }

    public void setCod_tipoo(int cod_tipoo) {
        this.cod_tipoo = cod_tipoo;
    }

    public String getNom_tipoo() {
        return nom_tipoo;
    }

    public void setNom_tipoo(String nom_tipoo) {
        this.nom_tipoo = nom_tipoo;
    }
    
    
}
