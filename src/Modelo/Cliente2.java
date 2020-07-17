/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.util.Date;

/**
 *
 * @author Mark-
 */
public class Cliente2 extends Trabajador {
    private int cod_cliente;
    private String rut_cliente;
    private String nom_cliente;
    private String direc1_cliente;
    private String direc2_cliente;
    private String tel1_cliente;
    private String tel2_cliente;
    private String co_cliente;
    private Date fecn_cliente;

    public Cliente2() {
    }

    public Cliente2(String nom_cliente, String nom_traba) {
        super(nom_traba);
        this.nom_cliente = nom_cliente;
    }

    public Cliente2(String rut_cliente, String nom_cliente, String rut_traba, String nom_traba) {
        super(rut_traba, nom_traba);
        this.rut_cliente = rut_cliente;
        this.nom_cliente = nom_cliente;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getRut_cliente() {
        return rut_cliente;
    }

    public void setRut_cliente(String rut_cliente) {
        this.rut_cliente = rut_cliente;
    }

    public String getNom_cliente() {
        return nom_cliente;
    }

    public void setNom_cliente(String nom_cliente) {
        this.nom_cliente = nom_cliente;
    }

    public String getDirec1_cliente() {
        return direc1_cliente;
    }

    public void setDirec1_cliente(String direc1_cliente) {
        this.direc1_cliente = direc1_cliente;
    }

    public String getDirec2_cliente() {
        return direc2_cliente;
    }

    public void setDirec2_cliente(String direc2_cliente) {
        this.direc2_cliente = direc2_cliente;
    }

    public String getTel1_cliente() {
        return tel1_cliente;
    }

    public void setTel1_cliente(String tel1_cliente) {
        this.tel1_cliente = tel1_cliente;
    }

    public String getTel2_cliente() {
        return tel2_cliente;
    }

    public void setTel2_cliente(String tel2_cliente) {
        this.tel2_cliente = tel2_cliente;
    }

    public String getCo_cliente() {
        return co_cliente;
    }

    public void setCo_cliente(String co_cliente) {
        this.co_cliente = co_cliente;
    }

    public Date getFecn_cliente() {
        return fecn_cliente;
    }

    public void setFecn_cliente(Date fecn_cliente) {
        this.fecn_cliente = fecn_cliente;
    }
    
    public String toString(){
        return rut_cliente+"-"+nom_cliente+"-";
    }
}
