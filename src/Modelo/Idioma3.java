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
public class Idioma3 extends Autores3{
     private int cod_idioma;
    private String nom_idioma;

    public Idioma3() {
    }

    public Idioma3(String nom_idioma, String nom_autor, String pseu_autor, String titulo_libro, int pag_libro, int precio_libro, int Stock, String nom_edit) {
        super(nom_autor, pseu_autor, titulo_libro, pag_libro, precio_libro, Stock, nom_edit);
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
    
    
}
