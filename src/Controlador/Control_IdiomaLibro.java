/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;


import Modelo.Idioma;
import Modelo.IdiomaLibro;
import Modelo.Libros;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mark-
 */
public class Control_IdiomaLibro {
    //listar idiomas en libros
    public List ListarIdiomaLibro(String dato){
    Control_Conexion con=Control_Conexion.getConnection();
    List<IdiomaLibro> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT " +
            "nom_idioma" +
            ",isbn_libro" +
            ",titulo_libro" +
            ",pag_libro" +
            ",precio_libro " +
            "FROM " +
            "idiomalibro " +
            "INNER JOIN libro " +
            "ON (idiomalibro.cod_libro = libro.cod_libro) " +
            "INNER JOIN idioma " +
            "ON (idiomalibro.cod_idioma = idioma.cod_idioma) "
            + "WHERE isbn_libro LIKE '%"+dato+"%' OR titulo_libro LIKE '%"+dato+"%' OR nom_idioma LIKE '%"+dato+"%'");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new IdiomaLibro(rs.getString("nom_idioma"), 
                        rs.getString("isbn_libro"),
                        rs.getString("titulo_libro"), 
                        rs.getInt("pag_libro"), 
                        rs.getInt("precio_libro")));
            }
        } catch (SQLException e) {
            System.out.println("Error Listar Idiomas en Libros= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    //insertar idiomas en libros
    public void InsertarIdiomaLibro(int codi, int codl){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("INSERT INTO idiomalibro (cod_idioma, cod_libro) "
                    + "VALUES ('"+codi+"','"+codl+"')");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Insertar Idiomas en Libros= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //editar idiomas en libros
    public void EditarIdiomaLibro(int codi, int codl){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("UPDATE idiomalibro SET "
                    + "cod_idioma='"+codi+"', cod_libro='"+codl+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Editar Idiomas en Libros= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //ComboBox idiomas disponibles
    public List ComboBoxIdiomas(){
    Control_Conexion con=Control_Conexion.getConnection();
    List<Idioma> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT cod_idioma, nom_idioma FROM idioma");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new Idioma(rs.getInt("cod_idioma"), rs.getString("nom_idioma")));
            }
        } catch (SQLException e) {
            System.out.println("Error ComboBox idiomas disponibles= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    //listar libros disponibles
    public List ComboBoxLibros(){
    Control_Conexion con=Control_Conexion.getConnection();
    List<Libros> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT cod_libro, titulo_libro FROM libro WHERE cod_estado=6");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new Libros(rs.getInt("cod_libro"), rs.getString("titulo_libro")));
            }
        } catch (SQLException e) {
            System.out.println("Error ComboBox Libros En Reposicion= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
}
