/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.Compra;
import Modelo.Comuna;
import Modelo.Distribuidor;
import Modelo.PaisDist;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mark-
 */
public class Control_Distribuidor {
    
    //comboBox paises de origen de distribuidores
    public List comboBoxPais(){
    Control_Conexion con=Control_Conexion.getConnection();
    List<PaisDist> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT cod_pais, nom_pais FROM pais");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new PaisDist(rs.getInt("cod_pais"), rs.getString("nom_pais")));
            }
        } catch (SQLException e) {
            System.out.println("Error ComboBox Comunas= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    //comboBox comunas
    public List comboBoxComunas(){
    Control_Conexion con=Control_Conexion.getConnection();
    List<Comuna> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT cod_comuna, nom_comuna FROM comuna");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new Comuna(rs.getInt("cod_comuna"), rs.getString("nom_comuna")));
            }
        } catch (SQLException e) {
            System.out.println("Error ComboBox Comunas= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    //eliminar distribuidores
    public void EliminarDistribuidores(int cod){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("DELETE FROM distribuidor WHERE cod_dist='"+cod+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Eliminar Distribuidores= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //editar distribuidores
    public void editarDistribuidores(int codD, String rut, String nom, String dir, String tel, int tiempo, String em, String contac, int codC, int codP){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("UPDATE distribuidor SET "
                    + "rut_dist='"+rut+"',nom_dist='"+nom+"',dir_dist='"+dir+"',tel_dist='"+tel+"',tiempo_dist='"+tiempo+"', "
                    + "email_dist='"+em+"',contacto_dist='"+contac+"',cod_comuna='"+codC+"',cod_pais='"+codP+"' "
                    + "WHERE cod_dist='"+codD+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Editar Distribuidores= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //insertar distribuidores
    public void insertarDistribuidores(String rut, String nom, String dir, String tel, int tiempo, String em, String contac, int codC, int codP){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("INSERT INTO distribuidor (rut_dist, nom_dist, dir_dist, tel_dist, tiempo_dist, " +
            "email_dist, contacto_dist, cod_comuna, cod_pais) "
            + "VALUES ('"+rut+"','"+nom+"','"+dir+"','"+tel+"','"+tiempo+"','"+em+"','"+contac+"','"+codC+"','"+codP+"')");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Insertar Distribuidores= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //listar distribuidores
    public List ListarDistribuidores(String dato){
    Control_Conexion con=Control_Conexion.getConnection();
    List<Distribuidor> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT cod_dist, rut_dist, nom_dist, dir_dist, tel_dist, tiempo_dist, " +
            "email_dist, contacto_dist, nom_comuna, nom_pais FROM distribuidor " +
            "INNER JOIN pais " +
            "ON (distribuidor.cod_pais = pais.cod_pais) " +
            "INNER JOIN comuna " +
            "ON (distribuidor.cod_comuna = comuna.cod_comuna) "
            + "WHERE rut_dist LIKE '%"+dato+"%' OR nom_dist LIKE '%"+dato+"%' OR dir_dist LIKE '%"+dato+"%' OR tel_dist LIKE '%"+dato+"%' OR tiempo_dist LIKE '%"+dato+"%' OR "
            + "email_dist LIKE '%"+dato+"%' OR contacto_dist LIKE '%"+dato+"%'");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new Distribuidor(rs.getInt("cod_dist"), 
                        rs.getString("rut_dist"), 
                        rs.getString("nom_dist"), 
                        rs.getString("dir_dist"), 
                        rs.getString("tel_dist"), 
                        rs.getInt("tiempo_dist"), 
                        rs.getString("email_dist"), 
                        rs.getString("contacto_dist"), 
                        rs.getString("nom_pais"), 
                        rs.getString("nom_comuna")));
            }
        } catch (SQLException e) {
            System.out.println("Error Listar Distribuidores= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
}
