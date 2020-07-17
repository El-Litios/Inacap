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
public class NacionAutor extends PaisAutor{
    private int cod_nac;
    private String nom_nac;

    public NacionAutor() {
    }

    public NacionAutor(int cod_nac, String nom_nac, String nom_pais) {
        super(nom_pais);
        this.cod_nac = cod_nac;
        this.nom_nac = nom_nac;
    }

    public NacionAutor(String nom_nac, String nom_pais) {
        super(nom_pais);
        this.nom_nac = nom_nac;
    }

    public NacionAutor(int cod_nac, String nom_nac) {
        this.cod_nac = cod_nac;
        this.nom_nac = nom_nac;
    }

    
    
    public int getCod_nac() {
        return cod_nac;
    }

    public void setCod_nac(int cod_nac) {
        this.cod_nac = cod_nac;
    }

    public String getNom_nac() {
        return nom_nac;
    }

    public void setNom_nac(String nom_nac) {
        this.nom_nac = nom_nac;
    }
    
    
    @Override
    public String toString(){
    return nom_nac;
    }
    
}
