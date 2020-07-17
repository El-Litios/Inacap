/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.DetalleArriendo;
import Modelo.Libros;
import Modelo.Opcion;
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
public class Control_Arriendos {
    //listar arriendos
    public List ListaArriendo(String dato){
    Control_Conexion con=Control_Conexion.getConnection();
    List<DetalleArriendo> lista = new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT " +
            "cod_detarriendo" +
            ",fec_entrega" +
            ",fec_estimada" +
            ",isbn_libro" +
            ",titulo_libro" +
            ",pag_libro" +
            ",folio" +
            ",precio_iva" +
            ",fecha" +
            ",hora" +
            ",rut_cliente" +
            ",nom_cliente" +
            ",rut_traba" +
            ",nom_traba " +
            "FROM " +
            "detarriendo " +
            "INNER JOIN opcion " +
            "ON (detarriendo.cod_arriendo = opcion.cod_opcion) " +
            "INNER JOIN trabajador " +
            "ON (opcion.cod_traba = trabajador.cod_traba) " +
            "INNER JOIN cliente " +
            "ON (opcion.cod_cliente = cliente.cod_cliente) " +
            "INNER JOIN boletaofactura " +
            "ON (opcion.cod_bof = boletaofactura.cod_bof) " +
            "INNER JOIN libro " +
            "ON (detarriendo.cod_libro = libro.cod_libro) "
            + "WHERE fec_entrega LIKE '%"+dato+"%' OR fec_estimada LIKE '%"+dato+"%' OR isbn_libro LIKE '%"+dato+"%' OR titulo_libro LIKE '%"+dato+"%' "
                    + "OR pag_libro LIKE '%"+dato+"%' OR folio LIKE '%"+dato+"%' OR folio LIKE '%"+dato+"%' OR precio_iva LIKE '%"+dato+"%' "
                            + "OR fecha LIKE '%"+dato+"%' OR hora LIKE '%"+dato+"%' OR rut_cliente LIKE '%"+dato+"%' OR nom_cliente LIKE '%"+dato+"%' "
                                    + "OR rut_traba LIKE '%"+dato+"%' OR nom_traba LIKE '%"+dato+"%'");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new DetalleArriendo(rs.getInt("cod_detarriendo"), 
                        rs.getDate("fec_entrega"), 
                        rs.getDate("fec_estimada"), 
                        rs.getString("isbn_libro"), 
                        rs.getString("titulo_libro"), 
                        rs.getInt("pag_libro"), 
                        rs.getString("folio"), 
                        rs.getString("precio_iva"), 
                        rs.getDate("fecha"), 
                        rs.getTime("hora"), 
                        rs.getString("rut_cliente"), 
                        rs.getString("nom_cliente"), 
                        rs.getString("rut_traba"), 
                        rs.getString("nom_traba")));
            }
        } catch (SQLException e) {
            System.out.println("Error Listar Arriendos= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    //insertar arriendos
    public void InsertarArriendo(int codOpc, int codL, Date fece, Date fecd){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("INSERT INTO detarriendo (cod_arriendo, cod_libro, fec_entrega, fec_estimada) "
                    + "VALUES ('"+codOpc+"','"+codL+"','"+fece+"','"+fecd+"')");
            PreparedStatement sql2=con.estado().prepareStatement("UPDATE libro SET cod_estado=3 WHERE cod_libro='"+codL+"'");
            sql.execute();
            sql2.execute();
        } catch (SQLException e) {
            System.out.println("Error Insertar Arriendos de Libros= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    public void EditarArriendo(int cod,int codOpc, int codL, Date fece, Date fecd){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("UPDATE detarriendo SET cod_arriendo='"+codOpc+"', cod_libro='"+codL+"', "
                    + "fec_entrega='"+fece+"', fec_estimada='"+fecd+"' "
                    + "WHERE cod_detventa='"+cod+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Editar Ventas de Libros= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    public void EliminarArriendo(int cod){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("DELETE FROM detarriendo WHERE cod_detarriendo='"+cod+"'");
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
            + "WHERE cod_tipoo=2");
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
