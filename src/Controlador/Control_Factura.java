/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Distribuidor;
import Modelo.FacturaCompra;
import Modelo.MetodoCompra;
import Modelo.MetodoPago;
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
public class Control_Factura {
    
    //listar facturas
    public List listarFacturas(String dato){
    Control_Conexion con=Control_Conexion.getConnection();
    List<FacturaCompra> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT " +
            "cod_factura" +
            ",prec_neto" +
            ",costo_iva" +
            ",precio_iva" +
            ",fec_compra" +
            ",nom_dist" +
            ",nom_mediop " +
            "FROM " +
            "factura " +
            "INNER JOIN biblioteca.distribuidor " +
            "ON (factura.cod_dist = distribuidor.cod_dist) " +
            "INNER JOIN biblioteca.mediopago " +
            "ON (factura.cod_metodo = mediopago.cod_mediop) "
            + "WHERE prec_neto LIKE '%"+dato+"%' OR costo_iva LIKE '%"+dato+"%' OR precio_iva LIKE '%"+dato+"%' "
            + "OR fec_compra LIKE '%"+dato+"%' OR nom_dist LIKE '%"+dato+"%' OR nom_mediop LIKE '%"+dato+"%'");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new FacturaCompra(rs.getInt("cod_factura"), 
                        rs.getInt("prec_neto"), 
                        rs.getInt("costo_iva"), 
                        rs.getInt("precio_iva"), 
                        rs.getDate("fec_compra"), 
                        rs.getString("nom_mediop"), 
                        rs.getString("nom_dist")));
            }
        } catch (SQLException e) {
            System.out.println("Error Listar Facturas= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    //insertar facturas
    public void InsertarFacturas(int neto, Date fec, int codD, int codM){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("INSERT INTO factura(prec_neto, costo_iva, precio_iva, fec_compra, cod_dist, cod_metodo) "
                    + "VALUES ('"+neto+"','"+neto+"'*0.19,'"+neto+"'+costo_iva,'"+fec+"','"+codD+"','"+codM+"')");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Insertar Facturas= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //editar facturas
    public void EditarFacturas(int cod, int neto, Date fec, int codD, int codM){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("UPDATE factura "
            + "SET prec_neto='"+neto+"', costo_iva=prec_neto*0.19, precio_iva=prec_neto+costo_iva, fec_compra='"+fec+"', cod_dist='"+codD+"', cod_metodo='"+codM+"' "
            + "WHERE cod_factura='"+cod+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Editar Facturas= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }

    //eliminar facturas
    public void eliminar(int cod){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("DELETE FROM factura WHERE cod_factura='"+cod+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Editar Facturas= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //comboBox distribuidor
    public List ComboBoxDistribuidor(){
    Control_Conexion con=Control_Conexion.getConnection();
    List<Distribuidor> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT cod_dist, nom_dist FROM distribuidor ");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new Distribuidor(rs.getInt("cod_dist"), rs.getString("nom_dist")));
            }
        } catch (SQLException e) {
            System.out.println("Error ComboBox Distribuidores= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    //comboBox medio pago
    public List ComboBoxMedioPago(){
    Control_Conexion con=Control_Conexion.getConnection();
    List<MetodoCompra> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT cod_mediop, nom_mediop FROM mediopago ");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new MetodoCompra(rs.getInt("cod_mediop"), rs.getString("nom_mediop")));
            }
        } catch (SQLException e) {
            System.out.println("Error ComboBox Medio de Pago= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
}
