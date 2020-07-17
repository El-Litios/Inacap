/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.DetalleVentas;
import Modelo.Libros;
import Modelo.Opcion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mark-
 */
public class Control_Ventas {
    public List ListaVenta(String dato){
    Control_Conexion con=Control_Conexion.getConnection();
    List<DetalleVentas> lista = new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT " +
            "cod_detventa " +
            ",rut_traba " +
            ",nom_traba " +
            ",rut_cliente " +
            ",nom_cliente " +
            ",folio " +
            ",precio_iva " +
            ",isbn_libro"+
            ",titulo_libro " +
            ",pag_libro " +        
            "FROM " +
            "detalleventas " +
            "INNER JOIN opcion " +
            "ON (detalleventas.cod_venta = opcion.cod_opcion) " +
            "INNER JOIN libro " +
            "ON (detalleventas.cod_libro = libro.cod_libro) " +
            "INNER JOIN trabajador " +
            "ON (opcion.cod_traba = trabajador.cod_traba) " +
            "INNER JOIN cliente " +
            "ON (opcion.cod_cliente = cliente.cod_cliente) " +
            "INNER JOIN boletaofactura " +
            "ON (opcion.cod_bof = boletaofactura.cod_bof) " 
                    + "WHERE rut_traba LIKE '%"+dato+"%' OR nom_traba LIKE '%"+dato+"%' OR rut_cliente LIKE '%"+dato+"%' OR nom_cliente LIKE '%"+dato+"%' "
                            + "OR precio_iva LIKE '%"+dato+"%' OR fecha LIKE  '%"+dato+"%' OR isbn_libro LIKE '%"+dato+"%' "
                                    + "OR titulo_libro LIKE '%"+dato+"%' AND cod_tipoo=1");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new DetalleVentas(rs.getInt("cod_detventa"), 
                        rs.getString("isbn_libro"),
                        rs.getString("titulo_libro"), 
                        rs.getInt("pag_libro"), 
                        rs.getString("folio"), 
                        rs.getString("precio_iva"),
                        rs.getString("rut_cliente"), 
                        rs.getString("nom_cliente"), 
                        rs.getString("rut_traba"), 
                        rs.getString("nom_traba")));
            }
        } catch (SQLException e) {
            System.out.println("Error Listar Ventas= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    
    public void InsertarVenta(int codOpc, int codL){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("INSERT INTO detalleventas (cod_venta, cod_libro) "
                    + "VALUES ('"+codOpc+"','"+codL+"')");
            PreparedStatement sql2=con.estado().prepareStatement("UPDATE libro SET cod_estado=6 WHERE cod_libro='"+codL+"'");
            sql.execute();
            sql2.execute();
        } catch (SQLException e) {
            System.out.println("Error Insertar Ventas de Libros= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    public void EditarVenta(int cod,int codOpc, int codL){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("UPDATE detalleventa SET cod_venta='"+codOpc+"', cod_libro='"+codL+"' "
                    + "WHERE cod_detventa='"+cod+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Editar Ventas de Libros= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    public void EliminarVenta(int cod){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("DELETE FROM detalleventa WHERE cod_detventa='"+cod+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Eliminar Ventas de Libros= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    public List ComboBoxOpc(){
    Control_Conexion con=Control_Conexion.getConnection();
    List<Opcion> lista = new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT " +
            "cod_opcion" +
            ",Concat(folio,' / ',rut_traba,' ',nom_traba,' / ',rut_cliente,' ',nom_cliente) AS folio " +
            "FROM " +
            "opcion " +
            "INNER JOIN cliente " +
            "ON (opcion.cod_cliente = cliente.cod_cliente) " +
            "INNER JOIN boletaofactura " +
            "ON (opcion.cod_bof = boletaofactura.cod_bof) " +
            "INNER JOIN trabajador " +
            "ON (opcion.cod_traba = trabajador.cod_traba) "
            + "WHERE cod_tipoo=1");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new Opcion(rs.getInt("cod_opcion"), 
                        rs.getString("folio")));
            }
        } catch (SQLException e) {
            System.out.println("Error ComboBox Opcion de Ventas= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    public List ComboBoxLibros(){
    Control_Conexion con=Control_Conexion.getConnection();
    List<Libros> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT " +
            "cod_libro," +
            "concat(isbn_libro,'/',titulo_libro) as titulo_libro " +
            "FROM " +
            "libro " +
            "WHERE cod_estado=1");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new Libros(rs.getInt("cod_libro"), rs.getString("titulo_libro")));
            }
        } catch (SQLException e) {
            System.out.println("Error ComboBox Libros En STOCK para ventas= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
}
