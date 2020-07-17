/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mark-
 */
public class Control_Clientes {
    
    //Eliminar Clientes
    public void EliminarClientes(int cod){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("DELETE FROM cliente WHERE cod_cliente='"+cod+"' ");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Eliminar Cliente= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //Editar Clientes
    public void EditarClientes(int cod, String rut, String nom, String direc1, String direc2, String tel1, String tel2, String correo, Date fec){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("UPDATE cliente SET "
                    + "rut_cliente='"+rut+"',nom_cliente='"+nom+"',direc1_cliente='"+direc1+"',direc2_cliente='"+direc2+"', "
                    + "tel1_cliente='"+tel1+"',tel2_cliente='"+tel2+"',co_cliente='"+correo+"',fecn_cliente='"+fec+"' "
                    + "WHERE cod_cliente='"+cod+"' ");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Editar Clientes= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //insertar Clientes
    public void InsertarClientes(String rut, String nom, String direc1, String direc2, String tel1, String tel2, String correo, Date fec){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("INSERT INTO cliente "
                    + "(rut_cliente,nom_cliente,direc1_cliente,direc2_cliente,tel1_cliente,tel2_cliente,co_cliente,fecn_cliente) "
                    + "VALUES ('"+rut+"','"+nom+"','"+direc1+"','"+direc2+"', "
                    + " '"+tel1+"','"+tel2+"','"+correo+"','"+fec+"')");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Insertar Clientes= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //Listar Clientes
    public List ListaClientes(String Dato){
    Control_Conexion con=Control_Conexion.getConnection();
    List<Cliente> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT " +
            "cod_cliente" +
            ",rut_cliente" +
            ",nom_cliente" +
            ",direc1_cliente" +
            ",direc2_cliente" +
            ",tel1_cliente" +
            ",tel2_cliente " +
            ",co_cliente" +
            ",fecn_cliente " +
            "FROM " +
            "cliente "
            + "WHERE rut_cliente LIKE '%"+Dato+"%' OR nom_cliente LIKE '%"+Dato+"%' OR direc1_cliente LIKE '%"+Dato+"%' OR direc2_cliente LIKE '%"+Dato+"%' "
            + "OR tel1_cliente LIKE '%"+Dato+"%' OR tel2_cliente LIKE '%"+Dato+"%' OR co_cliente LIKE '%"+Dato+"%'");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new Cliente(rs.getInt("cod_cliente"), 
                        rs.getString("rut_cliente"), 
                        rs.getString("nom_cliente"), 
                        rs.getString("direc1_cliente"), 
                        rs.getString("direc2_cliente"), 
                        rs.getString("tel1_cliente"), 
                        rs.getString("tel2_cliente"), 
                        rs.getString("co_cliente"), 
                        rs.getDate("fecn_cliente")));
            }
        } catch (SQLException e) {
            System.out.println("Error Listar Clientes= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
}