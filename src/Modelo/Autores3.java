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
public class Autores3 extends Libros5{
    private int cod_autor;
    private String nom_autor;
    private String pseu_autor;
    private String app_autor;
    private String apm_autor;

    public Autores3() {
    }

    public Autores3(String nom_autor, String pseu_autor, String titulo_libro, int pag_libro, int precio_libro, int Stock, String nom_edit) {
        super( titulo_libro, pag_libro, precio_libro, Stock, nom_edit);
        this.nom_autor = nom_autor;
        this.pseu_autor = pseu_autor;
    }

    

    

    public int getCod_autor() {
        return cod_autor;
    }

    public void setCod_autor(int cod_autor) {
        this.cod_autor = cod_autor;
    }

    public String getNom_autor() {
        return nom_autor;
    }

    public void setNom_autor(String nom_autor) {
        this.nom_autor = nom_autor;
    }

    public String getPseu_autor() {
        return pseu_autor;
    }

    public void setPseu_autor(String pseu_autor) {
        this.pseu_autor = pseu_autor;
    }

    public String getApp_autor() {
        return app_autor;
    }

    public void setApp_autor(String app_autor) {
        this.app_autor = app_autor;
    }

    public String getApm_autor() {
        return apm_autor;
    }

    public void setApm_autor(String apm_autor) {
        this.apm_autor = apm_autor;
    }
    
    
}
