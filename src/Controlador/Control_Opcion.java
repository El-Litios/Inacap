/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.BoletaOfactura;
import Modelo.BoletaOfactura2;
import Modelo.Cliente;
import Modelo.Opcion;
import Modelo.TipoOpcion;
import Modelo.Trabajador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mark-
 */
public class Control_Opcion {
    public List ListaOpc(String dato){
    Control_Conexion con=Control_Conexion.getConnection();
    List<Opcion> lista = new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT " +
            "cod_opcion" +
            ",nom_traba" +
            ",nom_cliente" +
            ",fecha" +
            ",hora" +
            ",nom_tipoo " +
            "FROM " +
            "opcion " +
            "INNER JOIN trabajador " +
            "ON (opcion.cod_traba = trabajador.cod_traba) " +
            "INNER JOIN cliente " +
            "ON (opcion.cod_cliente = cliente.cod_cliente) " +
            "INNER JOIN boletaofactura " +
            "ON (opcion.cod_bof = boletaofactura.cod_bof) " +
            "INNER JOIN tipoopcion " +
            "ON (opcion.cod_tipoo = tipoopcion.cod_tipoo) "
                    + "WHERE nom_traba LIKE '%"+dato+"%' OR nom_cliente LIKE '%"+dato+"%' OR nom_tipoo LIKE '%"+dato+"%' "
                    + "fecha LIKE '%"+dato+"%' OR hora LIKE '%"+dato+"%' ");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new Opcion(rs.getInt("cod_opcion"), 
                        rs.getDate("fecha"), 
                        rs.getTime("hora"), 
                        rs.getString("nom_tipoo"), 
                        rs.getString("nom_cliente"), 
                        rs.getString("nom_traba")));
            }
        } catch (SQLException e) {
            System.out.println("Error Listar Opcion = "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    
    public void EliminarOpc(int cod){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("DELETE FROM opcion WHERE cod_opcion='"+cod+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Eliminar Opciones= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    
    public List ComboBoxTrabajador(){
    Control_Conexion con=Control_Conexion.getConnection();
    List<Trabajador> lista = new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT cod_traba,  CONCAT(rut_traba,'/',nom_traba) AS nom_traba "
                    + "FROM trabajador");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new Trabajador(rs.getInt("cod_traba"), rs.getString("nom_traba")));
            }
        } catch (SQLException e) {
            System.out.println("Error ComboBox de Trabajador= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    
   public List ComboBoxCliente(){
    Control_Conexion con=Control_Conexion.getConnection();
    List<Cliente> lista = new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT cod_cliente, CONCAT(rut_cliente,'/',nom_cliente) AS nom_cliente "
                    + "FROM cliente");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new Cliente(rs.getInt("cod_cliente"), rs.getString("nom_cliente")));
            }
        } catch (SQLException e) {
            System.out.println("Error ComboBox de Cliente= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
   
   
   public List ComboBoxTipoO(){
    Control_Conexion con=Control_Conexion.getConnection();
    List<TipoOpcion> lista = new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT cod_tipoo, nom_tipoo "
                    + "FROM Tipoopcion");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new TipoOpcion(rs.getInt("cod_tipoo"), rs.getString("nom_tipoo")));
            }
        } catch (SQLException e) {
            System.out.println("Error ComboBox de Tipo Opcion (Arriendo o Venta)= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
   
   public List ComboBoxBoF(){
    Control_Conexion con=Control_Conexion.getConnection();
    List<BoletaOfactura> lista = new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT cod_bof, folio "
                    + "FROM boletaofactura");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new BoletaOfactura(rs.getInt("cod_bof"), rs.getString("folio")));
            }
        } catch (SQLException e) {
            System.out.println("Error ComboBox de Boleta o Factura para OPCION= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
   
   public void InsertarOpcArriendo(int codT, int codC, int codBF){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("INSERT INTO opcion (cod_traba, cod_cliente, cod_bof, cod_tipoo) "
                    + "VALUES ('"+codT+"','"+codC+"','"+codBF+"',2)");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Insertar Opciones de Arriendo= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
   
   public void InsertarOpcVenta(int codT, int codC, int codBF){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("INSERT INTO opcion (cod_traba, cod_cliente, cod_bof, cod_tipoo) "
                    + "VALUES ('"+codT+"','"+codC+"','"+codBF+"',1)");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Insertar Opciones de Ventas= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
   
   
   
   public void EditarOpcArriendo(int cod, int codT, int codC, int codBF){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("UPDATE opcion SET cod_traba='"+codT+"',cod_cliente='"+codT+"',cod_bof='"+codT+"' "
                    + "WHERE cod_opcion='"+cod+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Editar Opciones para Arriendo= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
   
   public void EditarOpcVenta(int cod, int codT, int codC, int codBF){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("UPDATE opcion SET cod_traba='"+codT+"',cod_cliente='"+codT+"',cod_bof='"+codT+"' "
                    + "WHERE cod_opcion='"+cod+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Editar Opciones para Venta= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
}
