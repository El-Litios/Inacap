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
public class Cargo {
    private int cod_cargo;
    private String nom_cargo;

    public Cargo() {
    }

    public Cargo(int cod_cargo, String nom_cargo) {
        this.cod_cargo = cod_cargo;
        this.nom_cargo = nom_cargo;
    }

    public Cargo(String nom_cargo) {
        this.nom_cargo = nom_cargo;
    }
    
    

    public int getCod_cargo() {
        return cod_cargo;
    }

    public void setCod_cargo(int cod_cargo) {
        this.cod_cargo = cod_cargo;
    }

    public String getNom_cargo() {
        return nom_cargo;
    }

    public void setNom_cargo(String nom_cargo) {
        this.nom_cargo = nom_cargo;
    }
    
    @Override
    public String toString(){
    return nom_cargo;
    }
}
