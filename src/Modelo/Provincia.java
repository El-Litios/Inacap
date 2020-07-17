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
public class Provincia extends Region{
    private int cod_provincia;
    private String nom_provincia;

    public Provincia() {
    }

    public Provincia(int cod_provincia, String nom_provincia, String nom_region) {
        super(nom_region);
        this.cod_provincia = cod_provincia;
        this.nom_provincia = nom_provincia;
    }

    public Provincia(String nom_provincia, String nom_region) {
        super(nom_region);
        this.nom_provincia = nom_provincia;
    }

    public int getCod_provincia() {
        return cod_provincia;
    }

    public void setCod_provincia(int cod_provincia) {
        this.cod_provincia = cod_provincia;
    }

    public String getNom_provincia() {
        return nom_provincia;
    }

    public void setNom_provincia(String nom_provincia) {
        this.nom_provincia = nom_provincia;
    }
    
    
}
