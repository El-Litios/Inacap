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
public class Distribuidor extends PaisDist2{
    private int cod_dist;
    private String rut_dist;
    private String nom_dist;
    private String dir_dist;
    private String tel_dist;
    private int tiempo_dist;
    private String em_dist;
    private String contacto_dist;

    public Distribuidor() {
    }

    public Distribuidor(int cod_dist, String nom_dist) {
        this.cod_dist = cod_dist;
        this.nom_dist = nom_dist;
    }

    public Distribuidor(int cod_dist, String rut_dist, String nom_dist, String dir_dist, String tel_dist, int tiempo_dist, String em_dist, String contacto_dist, String nom_pais, String nom_comuna) {
        super(nom_pais, nom_comuna);
        this.cod_dist = cod_dist;
        this.rut_dist = rut_dist;
        this.nom_dist = nom_dist;
        this.dir_dist = dir_dist;
        this.tel_dist = tel_dist;
        this.tiempo_dist = tiempo_dist;
        this.em_dist = em_dist;
        this.contacto_dist = contacto_dist;
    }

    public Distribuidor(String nom_dist) {
        this.nom_dist = nom_dist;
    }

    public int getCod_dist() {
        return cod_dist;
    }

    public void setCod_dist(int cod_dist) {
        this.cod_dist = cod_dist;
    }

    public String getRut_dist() {
        return rut_dist;
    }

    public void setRut_dist(String rut_dist) {
        this.rut_dist = rut_dist;
    }

    public String getNom_dist() {
        return nom_dist;
    }

    public void setNom_dist(String nom_dist) {
        this.nom_dist = nom_dist;
    }

    public String getDir_dist() {
        return dir_dist;
    }

    public void setDir_dist(String dir_dist) {
        this.dir_dist = dir_dist;
    }

    public String getTel_dist() {
        return tel_dist;
    }

    public void setTel_dist(String tel_dist) {
        this.tel_dist = tel_dist;
    }

    public int getTiempo_dist() {
        return tiempo_dist;
    }

    public void setTiempo_dist(int tiempo_dist) {
        this.tiempo_dist = tiempo_dist;
    }

    public String getEm_dist() {
        return em_dist;
    }

    public void setEm_dist(String em_dist) {
        this.em_dist = em_dist;
    }

    public String getContacto_dist() {
        return contacto_dist;
    }

    public void setContacto_dist(String contacto_dist) {
        this.contacto_dist = contacto_dist;
    }
    
    
    @Override
    public String toString(){
        return nom_dist;
    }
    
    
}
