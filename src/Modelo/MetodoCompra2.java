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
public class MetodoCompra2 extends Distribuidor {
    private int cod_metC;
    private String nom_metC;

    public MetodoCompra2() {
    }

    public MetodoCompra2(String nom_metC, String nom_dist) {
        super(nom_dist);
        this.nom_metC = nom_metC;
    }

    public MetodoCompra2(String nom_dist) {
        super(nom_dist);
    }

    
    
    public int getCod_metC() {
        return cod_metC;
    }

    public void setCod_metC(int cod_metC) {
        this.cod_metC = cod_metC;
    }

    public String getNom_metC() {
        return nom_metC;
    }

    public void setNom_metC(String nom_metC) {
        this.nom_metC = nom_metC;
    }
    
    
}
