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
public class Comuna extends Provincia{
    private int cod_comuna;
    private String nom_comuna;

    public Comuna() {
    }

    public Comuna(int cod_comuna, String nom_comuna) {
        this.cod_comuna = cod_comuna;
        this.nom_comuna = nom_comuna;
    }

    
    
    public Comuna(String nom_comuna, String nom_provincia, String nom_region) {
        super(nom_provincia, nom_region);
        this.nom_comuna = nom_comuna;
    }

    public Comuna(String nom_comuna) {
        this.nom_comuna = nom_comuna;
    }

    public int getCod_comuna() {
        return cod_comuna;
    }

    public void setCod_comuna(int cod_comuna) {
        this.cod_comuna = cod_comuna;
    }

    public String getNom_comuna() {
        return nom_comuna;
    }

    public void setNom_comuna(String nom_comuna) {
        this.nom_comuna = nom_comuna;
    }
    
    @Override
    public String toString(){
        return nom_comuna;
    }
}
