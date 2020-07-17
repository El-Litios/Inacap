/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.Morosidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mark-
 */
public class Control_Morosidad {
    //listar morosidades
    public List ListaMorosidad(String dato){
    Control_Conexion con=Control_Conexion.getConnection();
    List<Morosidad> lista = new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT " +
            "cod_morosidad" +
            ",dias_morosidad" +
            ",monto_morosidad" +
            ",fec_entrega" +
            ",fec_estimada" +
            ",rut_traba" +
            ",nom_traba" +
            ",rut_cliente" +
            ",nom_cliente" +
            ",folio" +
            ",precio_iva" +
            ",isbn_libro" +
            ",titulo_libro" +
            ",nom_estadom " +
            "FROM " +
            "morosidad " +
            "INNER JOIN detarriendo " +
            "ON (morosidad.cod_arriendo = detarriendo.cod_detarriendo) " +
            "INNER JOIN opcion " +
            "ON (detarriendo.cod_arriendo = opcion.cod_opcion)  " +
            "INNER JOIN trabajador  " +
            "ON (opcion.cod_traba = trabajador.cod_traba) " +
            "INNER JOIN cliente  " +
            "ON (opcion.cod_cliente = cliente.cod_cliente) " +
            "INNER JOIN boletaofactura  " +
            "ON (opcion.cod_bof = boletaofactura.cod_bof) " +
            "INNER JOIN libro " +
            "ON (detarriendo.cod_libro = libro.cod_libro) " +
            "INNER JOIN biblioteca.estadomorosidad " +
            "ON (morosidad.cod_estado = estadomorosidad.cod_estadom) " +
            "WHERE monto_morosidad LIKE '%"+dato+"%' OR fec_entrega LIKE '%"+dato+"%' " +
                "OR fec_estimada LIKE '%"+dato+"%' OR rut_traba LIKE '%"+dato+"%' OR nom_traba LIKE '%"+dato+"%'" +
                "OR rut_cliente LIKE '%"+dato+"%' OR nom_cliente LIKE '%"+dato+"%' OR folio LIKE '%"+dato+"%' " +
                "OR precio_iva LIKE '%"+dato+"%' OR isbn_libro LIKE '%"+dato+"%' OR titulo_libro LIKE '%"+dato+"%' ");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new Morosidad(rs.getInt("cod_morosidad"), 
                        rs.getInt("dias_morosidad"), 
                        rs.getInt("monto_morosidad"),
                        rs.getString("nom_estadom"), 
                        rs.getDate("fec_entrega"), 
                        rs.getDate("fec_estimada"), 
                        rs.getString("isbn_libro"), 
                        rs.getString("titulo_libro"), 
                        rs.getString("folio"), 
                        rs.getString("precio_iva"), 
                        rs.getString("rut_cliente"), 
                        rs.getString("nom_cliente"), 
                        rs.getString("rut_traba"), 
                        rs.getString("nom_traba")));
            }
        } catch (SQLException e) {
            System.out.println("Error Listar Morosidades de Arriendos = "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    //insertar Morosidad en los arriendos
    public void InsertarMorosidad(int codA){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("Insert into morosidad (dias_morosidad, monto_morosidad, cod_arriendo, cod_estado) VALUES " +
            "((SELECT datediff(now(), fec_estimada) from detarriendo where cod_detarriendo='"+codA+"'), 3000*dias_morosidad, '"+codA+"', 2)");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Insertar Insertar Morosidad= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //cambiar morosidad a pagada
    public void EditarMorosidadPagada(int codM){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("UPDATE morosidad SET cod_estado=1 WHERE cod_morosidad='"+codM+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Editar a Morosidad Pagada= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //cambiar morosidad a pagada
    public void EliminarMorosidad(int codM){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("DELETE FROM morosidad WHERE cod_morosidad='"+codM+"'");
            
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Eliminar Morosidad= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //cambiar morosidad a pagada
    public void ActualizarMorosidad(int codM){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("UPDATE morosidad SET cod_morosidad=1 WHERE cod_morosidad='"+codM+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Editar a Morosidad Pagada= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
}
