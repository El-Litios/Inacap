/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.RolTrabajador;
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
public class Control_Trabajador {
    
    //listar Roles de trabajadores para comboBox
    public List comboboxRoles(){
    Control_Conexion con=Control_Conexion.getConnection();
    List<RolTrabajador> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT cod_rol, nom_rol FROM roles_trabajador");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new RolTrabajador(rs.getInt("cod_rol"), rs.getString("nom_rol")));
            }
        } catch (SQLException e) {
            System.out.println("Error Combo Box Rol= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    //eliminar trabajadores
    public void EliminarTrabajadores(int cod){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("DELETE FROM trabajador WHERE cod_traba='"+cod+"' ");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Eliminar Trabajadores= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //editar trabajadores
    public void EditarTrabajadores(int cod, String rut, String nom, String direc1, String direc2, String tel1, String tel2, String correo, Date fec, int codRol){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("UPDATE trabajador SET "
                    + "rut_traba='"+rut+"',nom_traba='"+nom+"',direc1_traba='"+direc1+"',direc2_traba='"+direc2+"',tel1_traba='"+tel1+"',tel2_traba='"+tel2+"',correo_traba='"+correo+"' "
                            + " ,fecini_traba='"+fec+"',cod_rol='"+codRol+"' "
                            + "WHERE cod_traba='"+cod+"' ");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Editar Trabajadores= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //insertar Trabajadores
    public void InsertarTrabajadores(String rut, String nom, String direc1, String direc2, String tel1, String tel2, String correo, Date fec, int codRol){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("INSERT INTO trabajador "
                    + "(rut_traba,nom_traba,direc1_traba,direc2_traba,tel1_traba,tel2_traba,correo_traba,fecini_traba,cod_rol) "
                    + "VALUES "
                    + "('"+rut+"','"+nom+"','"+direc1+"','"+direc2+"','"+tel1+"','"+tel2+"','"+correo+"' "
                            + " ,'"+fec+"','"+codRol+"' )");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error insertar Trabajadores= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //listar trabajadores
    public List listarTrabajador(String dato){
    List<Trabajador> lista=new ArrayList<>();
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT cod_traba, rut_traba, nom_traba, direc1_traba, direc2_traba " +
            ",tel1_traba" +
            ",tel2_traba" +
            ",correo_traba" +
            ",fecini_traba" +
            ",nom_rol " +
            "FROM " +
            "trabajador " +
            "INNER JOIN roles_trabajador " +
            "ON (trabajador.cod_rol = roles_trabajador.cod_rol) "
            + "WHERE rut_traba LIKE '%"+dato+"%' OR nom_traba LIKE '%"+dato+"%' OR correo_traba LIKE '%"+dato+"%' OR fecini_traba LIKE '%"+dato+"%' OR nom_rol LIKE '%"+dato+"%'");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new Trabajador(rs.getInt("cod_traba"), 
                        rs.getString("rut_traba"), 
                        rs.getString("nom_traba"), 
                        rs.getString("direc1_traba"), 
                        rs.getString("direc2_traba"), 
                        rs.getString("tel1_traba"), 
                        rs.getString("tel2_traba"), 
                        rs.getString("correo_traba"), 
                        rs.getDate("fecini_traba"), 
                        rs.getString("nom_rol")));
            }
        } catch (SQLException e) {
            System.out.println("Error Lista de Trabajadores= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
}
