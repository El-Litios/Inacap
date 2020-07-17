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
public class PaisDist2 extends Comuna{
    private int cod_pais;
    private int iso1_pais;
    private int iso2_pais;
    private String nom_pais;

    public PaisDist2() {
    }

    
    
    public PaisDist2(String nom_pais, String nom_comuna) {
        super(nom_comuna);
        this.nom_pais = nom_pais;
    }

    public int getCod_pais() {
        return cod_pais;
    }

    public void setCod_pais(int cod_pais) {
        this.cod_pais = cod_pais;
    }

    public int getIso1_pais() {
        return iso1_pais;
    }

    public void setIso1_pais(int iso1_pais) {
        this.iso1_pais = iso1_pais;
    }

    public int getIso2_pais() {
        return iso2_pais;
    }

    public void setIso2_pais(int iso2_pais) {
        this.iso2_pais = iso2_pais;
    }

    public String getNom_pais() {
        return nom_pais;
    }

    public void setNom_pais(String nom_pais) {
        this.nom_pais = nom_pais;
    }
    
    
    
}
