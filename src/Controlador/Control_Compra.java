/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Compra;
import Modelo.FacturaCompra;
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
public class Control_Compra extends Compra{
    //listar compras 
    public List ListarCompras(String dato){
    Control_Conexion con=Control_Conexion.getConnection();
    List<Compra> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT " +
            "cod_compra " +
            ",comentarios" +
            ",folio_orden" +
            ",fecha_emision" +
            ",nom_traba" +
            ",precio_iva" +
            ",fec_compra" +
            ",nom_dist " +
            "FROM compra " +
            "INNER JOIN factura " +
            "ON (compra.cod_fact = factura.cod_factura) " +
            "INNER JOIN orden_compra " +
            "ON (compra.cod_orden = orden_compra.cod_orden) " +
            "INNER JOIN distribuidor " +
            "ON (factura.cod_dist = distribuidor.cod_dist) " +
            "INNER JOIN trabajador " +
            "ON (orden_compra.cod_trabajador = trabajador.cod_traba) "
            + "WHERE comentarios LIKE '%"+dato+"%' OR folio_orden LIKE '%"+dato+"%' OR nom_traba LIKE '%"+dato+"%' OR "
            + "precio_iva LIKE '%"+dato+"%' OR nom_dist LIKE '%"+dato+"%'");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new Compra(rs.getInt("cod_compra"), 
                        rs.getString("comentarios"), 
                        rs.getString("folio_orden"), 
                        rs.getDate("fecha_emision"), 
                        rs.getString("nom_traba"), 
                        rs.getInt("precio_iva"), 
                        rs.getDate("fec_compra"), 
                        rs.getString("nom_dist")));
            }
        } catch (SQLException e) {
            System.out.println("Error Listar Compra= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    
    //comboBox facturas
    public List ComboBoxFacturas(){
    Control_Conexion con=Control_Conexion.getConnection();
    List<FacturaCompra> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT cod_factura, fec_compra FROM factura");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new FacturaCompra(rs.getInt("cod_factura"), rs.getDate("fec_compra")));
            }
        } catch (SQLException e) {
            System.out.println("Error ComboBox Facturas= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    //comboBox ordenes de Compra
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
    
    public void guardarCompra(String com, int codf, int codo){
        Control_Conexion con= Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("INSERT INTO compra (comentarios, cod_fact, cod_orden) "
                    + "VALUES ('"+com+"','"+codf+"','"+codo+"')");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error agregar nuevas compras"+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    public void BorrarCompra(int cod){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("DELETE FROM compra WHERE cod_compra='"+cod+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error borrar Compras= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    public void EditarCompras(int cod, String comen, int codf, int codo){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("UPDATE compra SET comentarios='"+comen+"', "
                    + "cod_fact='"+codf+"', cod_orden='"+codo+"' WHERE cod_compra='"+cod+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Editar compras+ "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
}
