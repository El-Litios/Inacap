/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Distribuidor;
import Modelo.EstadoOC;
import Modelo.OrdenCompra;
import Modelo.Trabajador;
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
public class Control_OrdenDeCompra {
    
    
    
    //Lista Ordenes de Compra
    public List ListarOrdenesC(String dato){
    Control_Conexion con=Control_Conexion.getConnection();
    List<OrdenCompra> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT " +
            "cod_orden" +
            ",folio_orden" +
            ",fecha_emision" +
            ",nom_dist" +
            ",nom_traba" +
            ",nom_estado " +
            "FROM " +
            "orden_compra " +
            "INNER JOIN distribuidor " +
            "ON (orden_compra.cod_distribuidor = distribuidor.cod_dist) " +
            "INNER JOIN trabajador " +
            "ON (orden_compra.cod_trabajador = trabajador.cod_traba) " +
            "INNER JOIN estado_orden " +
            "ON (orden_compra.cod_estado = estado_orden.cod_estado) "
            + "WHERE nom_estado LIKE '%"+dato+"%' OR folio_orden  LIKE '%"+dato+"%'");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new OrdenCompra(rs.getInt("cod_orden"), 
                        rs.getString("folio_orden"), 
                        rs.getDate("fecha_emision"), 
                        rs.getString("nom_estado"), 
                        rs.getString("nom_traba"), 
                        rs.getString("nom_dist")));
            }
        } catch (SQLException e) {
            System.out.println("Error Listar Ordenes de Compra= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    //insertar ordenes de compra
    public void InsertarOrdenesC(String folio, Date fec, int dist, int traba, int estado){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("INSERT INTO orden_compra "
            + "(folio_orden, fecha_emision, cod_distribuidor, cod_trabajador, cod_estado) VALUES "
            + "('"+folio+"','"+fec+"','"+dist+"','"+traba+"','"+estado+"')");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Insertar Ordenes de Compra= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //editar ordenes de compra
    public void EditarOrdenesC(int cod, String folio, Date fec, int dist, int traba, int estado){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("UPDATE orden_compra SET folio_orden='"+folio+"', "
            + "fecha_emision='"+fec+"', cod_distribuidor='"+dist+"', cod_trabajador='"+traba+"', cod_estado='"+estado+"' "
            + "WHERE cod_orden='"+cod+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Editar Ordenes de Compra= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //eliminar ordenes de compra
    public void EliminarOrdenesC(int cod){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("DELETE FROM orden_compra WHERE cod_orden='"+cod+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Eliminar Ordenes de Compra= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //ComboBox Distribuidor
    public List ComboBoxDistribuidor(){
    Control_Conexion con=Control_Conexion.getConnection();
    List<Distribuidor> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT cod_dist, nom_dist FROM distribuidor");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new Distribuidor(rs.getInt("cod_dist"), rs.getString("nom_dist")));
            }
        } catch (SQLException e) {
            System.out.println("Error Combo Box Distribuidor= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    //ComboBox Trabajador
    public List ComboBoxTrabajador(){
    Control_Conexion con=Control_Conexion.getConnection();
    List<Trabajador> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT cod_traba, nom_traba FROM trabajador");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new Trabajador(rs.getInt("cod_traba"), rs.getString("nom_traba")));
            }
        } catch (SQLException e) {
            System.out.println("Error Combo Box Trabajador= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    //ComboBox Estados de la Orden
    public List ComboBoxEstadoOrden(){
    Control_Conexion con=Control_Conexion.getConnection();
    List<EstadoOC> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT * FROM estado_orden");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new EstadoOC(rs.getInt("cod_estado"), rs.getString("nom_estado")));
            }
        } catch (SQLException e) {
            System.out.println("Error Combo Box Estado de Orden de Compra= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    //ComboBox Ordenes de Compra
    public List ComboBoxOrdenes(){
    Control_Conexion con=Control_Conexion.getConnection();
    List<OrdenCompra> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT " +
            "cod_orden" +
            ",folio_orden " +
            "FROM " +
            "orden_compra ");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new OrdenCompra(rs.getInt("cod_orden"), 
                        rs.getString("folio_orden")));
            }
        } catch (SQLException e) {
            System.out.println("Error ComboBox Ordenes de Compra= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
}
