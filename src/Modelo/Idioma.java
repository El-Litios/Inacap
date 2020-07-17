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
public class Idioma {
    private int cod_idioma;
    private String nom_idioma;

    public Idioma() {
    }

    public Idioma(int cod_idioma, String nom_idioma) {
        this.cod_idioma = cod_idioma;
        this.nom_idioma = nom_idioma;
    }

    public int getCod_idioma() {
        return cod_idioma;
    }

    public void setCod_idioma(int cod_idioma) {
        this.cod_idioma = cod_idioma;
    }

    public String getNom_idioma() {
        return nom_idioma;
    }

    public void setNom_idioma(String nom_idioma) {
        this.nom_idioma = nom_idioma;
    }
    
    @Override
    public String toString(){
    return nom_idioma;
    }
    
    
}
