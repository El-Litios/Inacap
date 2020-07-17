/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.sql.Date;

public class Trabajador extends RolTrabajador{
    private int cod_traba;
    private String rut_traba;
    private String nom_traba;
    private String direc1_traba;
    private String direc2_traba;
    private String tel1_traba;
    private String tel2_traba;
    private String correo_traba;
    private Date fecini_traba;

    public Trabajador() {
    }

    public Trabajador(int cod_traba, String nom_traba) {
        this.cod_traba = cod_traba;
        this.nom_traba = nom_traba;
    }

    public Trabajador(String rut_traba, String nom_traba) {
        this.rut_traba = rut_traba;
        this.nom_traba = nom_traba;
    }

    public Trabajador(int cod_traba, String rut_traba, String nom_traba, String direc1_traba, String direc2_traba, String tel1_traba, String tel2_traba, String correo_traba, Date fecini_traba, String nom_rol) {
        super(nom_rol);
        this.cod_traba = cod_traba;
        this.rut_traba = rut_traba;
        this.nom_traba = nom_traba;
        this.direc1_traba = direc1_traba;
        this.direc2_traba = direc2_traba;
        this.tel1_traba = tel1_traba;
        this.tel2_traba = tel2_traba;
        this.correo_traba = correo_traba;
        this.fecini_traba = fecini_traba;
    }

    
    
    public Trabajador(int cod_traba, String rut_traba, String nom_traba, String direc1_traba, String direc2_traba, String tel1_traba, String tel2_traba, String correo_traba, Date fecini_traba) {
        this.cod_traba = cod_traba;
        this.rut_traba = rut_traba;
        this.nom_traba = nom_traba;
        this.direc1_traba = direc1_traba;
        this.direc2_traba = direc2_traba;
        this.tel1_traba = tel1_traba;
        this.tel2_traba = tel2_traba;
        this.correo_traba = correo_traba;
        this.fecini_traba = fecini_traba;
    }

    public Trabajador(String nom_traba) {
        this.nom_traba = nom_traba;
    }

    public int getCod_traba() {
        return cod_traba;
    }

    public void setCod_traba(int cod_traba) {
        this.cod_traba = cod_traba;
    }

    public String getRut_traba() {
        return rut_traba;
    }

    public void setRut_traba(String rut_traba) {
        this.rut_traba = rut_traba;
    }

    public String getNom_traba() {
        return nom_traba;
    }

    public void setNom_traba(String nom_traba) {
        this.nom_traba = nom_traba;
    }

    public String getDirec1_traba() {
        return direc1_traba;
    }

    public void setDirec1_traba(String direc1_traba) {
        this.direc1_traba = direc1_traba;
    }

    public String getDirec2_traba() {
        return direc2_traba;
    }

    public void setDirec2_traba(String direc2_traba) {
        this.direc2_traba = direc2_traba;
    }

    public String getTel1_traba() {
        return tel1_traba;
    }

    public void setTel1_traba(String tel1_traba) {
        this.tel1_traba = tel1_traba;
    }

    public String getTel2_traba() {
        return tel2_traba;
    }

    public void setTel2_traba(String tel2_traba) {
        this.tel2_traba = tel2_traba;
    }

    public String getCorreo_traba() {
        return correo_traba;
    }

    public void setCorreo_traba(String correo_traba) {
        this.correo_traba = correo_traba;
    }

    public Date getFecini_traba() {
        return fecini_traba;
    }

    public void setFecini_traba(Date fecini_traba) {
        this.fecini_traba = fecini_traba;
    }
    
    @Override
    public String toString(){
        return nom_traba;
    }
    
    
    
}
