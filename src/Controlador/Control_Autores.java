/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.AutorLibro;
import Modelo.Autores;
import Modelo.NacionAutor;
import Modelo.PaisAutor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mark-
 */
public class Control_Autores {  
    
    //editar Autores.
    public void EditarAutores(int Cod, String nom, String pseu, String app, String apm, int CodNac){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("UPDATE autores SET nom_autor='"+nom+"',pseu_autor='"+pseu+"', "
                    + "app_autor='"+app+"',apm_autor='"+apm+"',cod_nac='"+CodNac+"' "
                    + "WHERE cod_autor='"+Cod+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Edit Autores= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //insertar autores.
    public void InsertarAutores(String nom, String pseu, String app, String apm, int CodNacion){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("INSERT INTO autores (nom_autor,pseu_autor,app_autor,apm_autor,cod_nac) "
                    + "VALUES ('"+nom+"','"+pseu+"','"+app+"','"+apm+"','"+CodNacion+"')");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Add Autores= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    
    //listar combo paises
    public List comboPais(){
    List <PaisAutor> lista=new ArrayList<>();
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT cod_pais, nom_pais FROM paisautor");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new PaisAutor(rs.getInt("cod_pais"), rs.getString("nom_pais")));
            }
        } catch (SQLException e) {
            System.out.println("Error ListPaises= "+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    //ingresar nacionalidades
    public void IngresarNacion(String nom, int codp){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("INSERT INTO nacionautor (nom_nac,cod_pais) "
                    + "VALUES ('"+nom+"','"+codp+"')");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error AddNacion= "+e);
        }finally {
        con.desconectar();
        }
    }
    
    public void EliminarNacion(int cod){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("DELETE FROM nacionautor WHERE cod_nac='"+cod+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Eliminar Nacion= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //listar nacionalidad=paises para combobox
    public List comboNacPais(){
        Control_Conexion con=Control_Conexion.getConnection();
        List<NacionAutor> lista = new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT cod_nac, nom_pais," +
            "concat(nom_nac,'/',nom_pais) AS nom_nac " +
            "FROM " +
            "nacionautor " +
            "INNER JOIN paisautor " +
            "ON (nacionautor.cod_pais = paisautor.cod_pais)");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new NacionAutor(rs.getInt("cod_nac"), rs.getString("nom_nac")));
            }
        } catch (SQLException e) {
            System.out.println("Error ComboNacP= "+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    //eliminar autores
    public void EliminarAutores(int cod){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("DELETE FROM autores WHERE cod_autor='"+cod+"' ");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error EliminarAutores= "+"\n"+e);
        }finally{
        con.desconectar();
        }
        
    }
     
    //listar Autores
    public List listarAutores(String Dato){
        Control_Conexion con=Control_Conexion.getConnection();
        List<Autores> lista=new ArrayList<>();
        try {
        con.conectar();
        PreparedStatement sql=con.estado().prepareStatement("SELECT " +
        "cod_autor,nom_autor,pseu_autor,app_autor,apm_autor,nom_nac,nom_pais FROM autores " +
        "INNER JOIN nacionautor " +
        "ON (autores.cod_nac = nacionautor.cod_nac) " +
        "INNER JOIN paisautor " +
        "ON (nacionautor.cod_pais = paisautor.cod_pais) "
        + "WHERE nom_autor LIKE '%"+Dato+"%' OR pseu_autor LIKE '%"+Dato+"%' OR app_autor LIKE '%"+Dato+"%' OR apm_autor LIKE '"+Dato+"' "
        + "OR nom_nac LIKE '%"+Dato+"%' OR nom_pais LIKE '%"+Dato+"%'");
        ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new Autores(rs.getInt("cod_autor"), 
                        rs.getString("nom_autor"), 
                        rs.getString("pseu_autor"), 
                        rs.getString("app_autor"), 
                        rs.getString("apm_autor"), 
                        rs.getString("nom_nac"), 
                        rs.getString("nom_pais")));
            }
            
        } catch (SQLException e) {
            System.out.println("ERROR ListAutores: "+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    //listar nacionalidades
    public List listaNacionalidad(String dato){
    List <NacionAutor> lista=new ArrayList<>();
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT " +
            "cod_nac" +
            ",nom_nac" +
            ",nom_pais " +
            "FROM " +
            "nacionautor " +
            "INNER JOIN paisautor " +
            "ON (nacionautor.cod_pais = paisautor.cod_pais) "
                    + "WHERE nom_nac LIKE '%"+dato+"%' OR  nom_pais LIKE '%"+dato+"%'");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new NacionAutor(rs.getInt("cod_nac"), rs.getString("nom_nac"), rs.getString("nom_pais")));
            }
        } catch (SQLException e) {
            System.out.println("Error listanac= "+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
}
