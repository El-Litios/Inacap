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
public class MetodoCompra {
    private int cod_metC;
    private String nom_metC;

    public MetodoCompra() {
    }

    public MetodoCompra(int cod_metC, String nom_metC) {
        this.cod_metC = cod_metC;
        this.nom_metC = nom_metC;
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
    
    @Override
    public String toString(){
        return nom_metC;
    }
}
