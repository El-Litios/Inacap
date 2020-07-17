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
public class MetodoPago {
    private int cod_metod;
    private String nom_metod;

    public MetodoPago() {
    }

    public MetodoPago(int cod_metod, String nom_metod) {
        this.cod_metod = cod_metod;
        this.nom_metod = nom_metod;
    }

    public MetodoPago(String nom_metod) {
        this.nom_metod = nom_metod;
    }

    
    
    public int getCod_metod() {
        return cod_metod;
    }

    public void setCod_metod(int cod_metod) {
        this.cod_metod = cod_metod;
    }

    public String getNom_metod() {
        return nom_metod;
    }

    public void setNom_metod(String nom_metod) {
        this.nom_metod = nom_metod;
    }
    
    @Override
    public String toString(){
    return nom_metod;
    }
    
}
