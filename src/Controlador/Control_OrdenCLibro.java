/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;


import Modelo.Libros;
import Modelo.OrdenC_Libros;
import Modelo.OrdenCompra;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mark-
 */
public class Control_OrdenCLibro {
    //listar libros en ordenes de compra
    public List ListarOrdenClibro(String dato){
    Control_Conexion con=Control_Conexion.getConnection();
    List<OrdenC_Libros> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT " +
            "titulo_libro" +
            ",folio_orden" +
            ",precio " +
            "FROM " +
            "ordenc_libro " +
            "INNER JOIN libro " +
            "ON (ordenc_libro.cod_libro = libro.cod_libro) " +
            "INNER JOIN orden_compra " +
            "ON (ordenc_libro.cod_orden = orden_compra.cod_orden) "
            + "WHERE titulo_libro LIKE '%"+dato+"%' OR folio_orden LIKE '%"+dato+"%'");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new OrdenC_Libros(rs.getInt("precio"), rs.getString("folio_orden"), rs.getString("titulo_libro")));
            }
        } catch (SQLException e) {
            System.out.println("Error Listar Libros  en Orden de Compra= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    //insertar libros en ordenes de compra
    public void InsertarOrdenLibro(int codl, int codo){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("INSERT INTO ordenc_libro (cod_libro, cod_orden, precio ) "
                    + "VALUES ('"+codl+"','"+codo+"',(SELECT precio_libro from libro WHERE cod_libro='"+codl+"'))");
            PreparedStatement sql2=con.estado().prepareStatement("UPDATE libro SET cod_estado=5 WHERE cod_libro='"+codl+"'");
            sql.execute();
            sql2.execute();
        } catch (SQLException e) {
            System.out.println("Error Insertar Libros en Orden de Compra= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //editar libros en ordenes de compra
    public void EditarOrdenLibro(int codl, int codo, int precio){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("UPDATE ordenc_libro SET "
                    + "cod_libro='"+codl+"', cod_orden='"+codo+"', precio='"+precio+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Editar Libros en Orden de Compra= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //eliminar libros en ordenes de compra
    
    
    //ComboBox Libros
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
            "WHERE cod_estado=4");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new Libros(rs.getInt("cod_libro"), rs.getString("titulo_libro")));
            }
        } catch (SQLException e) {
            System.out.println("Error ComboBox Libros En Ordenes de Compra= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    //ComboBox ordenes de compra
    public List ComboBoxOrdenes(){
    Control_Conexion con=Control_Conexion.getConnection();
    List<OrdenCompra> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT cod_orden, folio_orden FROM orden_compra "
                    + "WHERE cod_estado='1'");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new OrdenCompra(rs.getInt("cod_orden"), rs.getString("folio_orden")));
            }
        } catch (SQLException e) {
            System.out.println("Error ComboBox Ordenes de Compra= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
}
