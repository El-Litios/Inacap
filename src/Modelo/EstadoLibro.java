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
public class EstadoLibro {
    private int cod_estado;
    private String nom_estado;

    public EstadoLibro() {
    }

    
    
    public EstadoLibro(int cod_estado, String nom_estado) {
        this.cod_estado = cod_estado;
        this.nom_estado = nom_estado;
    }

    public int getCod_estado() {
        return cod_estado;
    }

    public void setCod_estado(int cod_estado) {
        this.cod_estado = cod_estado;
    }

    public String getNom_estado() {
        return nom_estado;
    }

    public void setNom_estado(String nom_estado) {
        this.nom_estado = nom_estado;
    }
    
    public String toString(){
    return nom_estado;
    }
}
