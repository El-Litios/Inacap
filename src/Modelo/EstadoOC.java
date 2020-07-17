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
public class EstadoOC  extends Trabajador3{
    private int cod_estado;
    private String nom_estado;

    public EstadoOC() {
    }

    public EstadoOC(int cod_estado, String nom_estado) {
        this.cod_estado = cod_estado;
        this.nom_estado = nom_estado;
    }

    public EstadoOC(String nom_estado, String nom_traba, String nom_dist) {
        super(nom_traba, nom_dist);
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
    
    @Override
    public String toString(){
        return nom_estado;
    }
    
}
