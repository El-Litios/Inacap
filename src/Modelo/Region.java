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
public class Region {
    private int cod_region;
    private String nom_region;
    private String ord_region;

    public Region() {
    }

    public Region(int cod_region, String nom_region, String ord_region) {
        this.cod_region = cod_region;
        this.nom_region = nom_region;
        this.ord_region = ord_region;
    }

    public Region(String nom_region) {
        this.nom_region = nom_region;
    }

    public int getCod_region() {
        return cod_region;
    }

    public void setCod_region(int cod_region) {
        this.cod_region = cod_region;
    }

    public String getNom_region() {
        return nom_region;
    }

    public void setNom_region(String nom_region) {
        this.nom_region = nom_region;
    }

    public String getOrd_region() {
        return ord_region;
    }

    public void setOrd_region(String ord_region) {
        this.ord_region = ord_region;
    }
    
    
}
