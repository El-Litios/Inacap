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
public class Editorial {
    private int cod_edit;
    private String nom_edit;

    public Editorial() {
    }

    public Editorial(int cod_edit, String nom_edit) {
        this.cod_edit = cod_edit;
        this.nom_edit = nom_edit;
    }

    public Editorial(String nom_edit) {
        this.nom_edit = nom_edit;
    }

    
    
    public int getCod_edit() {
        return cod_edit;
    }

    public void setCod_edit(int cod_edit) {
        this.cod_edit = cod_edit;
    }

    public String getNom_edit() {
        return nom_edit;
    }

    public void setNom_edit(String nom_edit) {
        this.nom_edit = nom_edit;
    }
    
    @Override
    public String toString(){
        return nom_edit;
    }
    
}
