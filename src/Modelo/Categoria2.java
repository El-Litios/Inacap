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
public class Categoria2 extends Idioma3{
    private int cod_cate;
    private String nom_cate;

    public Categoria2() {
    }

    public Categoria2(String nom_cate, String nom_idioma, String nom_autor, String pseu_autor, String titulo_libro, int pag_libro, int precio_libro, int Stock, String nom_edit) {
        super(nom_idioma, nom_autor, pseu_autor, titulo_libro, pag_libro, precio_libro, Stock, nom_edit);
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
    
    
}
