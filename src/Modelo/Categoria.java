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
public class Categoria {
    private int cod_cate;
    private String nom_cate;

    public Categoria() {
    }

    public Categoria(String nom_cate) {
        this.nom_cate = nom_cate;
    }

    
    
    public Categoria(int cod_cate, String nom_cate) {
        this.cod_cate = cod_cate;
        this.nom_cate = nom_cate;
    }

    public int getCod_cate() {
        return cod_cate;
    }

    public void setCod_cate(int cod_cate) {
        this.cod_cate = cod_cate;
    }

    public String getNom_cate() {
        return nom_cate;
    }

    public void setNom_cate(String nom_cate) {
        this.nom_cate = nom_cate;
    }
    
    @Override
    public String toString(){
    return nom_cate;
    }
}
