/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;


import Modelo.AutorLibro;
import Modelo.Autores;
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
public class Control_AutorLibro {
    //Listar autores en Libros
    public List ListarAutorLibro(String dato){
    Control_Conexion con=Control_Conexion.getConnection();
    List<AutorLibro> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT " +
            "nom_autor" +
            ",pseu_autor" +
            ",titulo_libro" +
            ",pag_libro" +
            ",precio_libro " +
            "FROM " +
            "autorlibro " +
            "INNER JOIN autores " +
            "ON (autorlibro.cod_autor = autores.cod_autor) " +
            "INNER JOIN libro " +
            "ON (autorlibro.cod_libro = libro.cod_libro) "
            + "WHERE nom_autor LIKE '%"+dato+"%' OR pseu_autor LIKE '%"+dato+"%' OR titulo_libro LIKE '%"+dato+"%' ");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new AutorLibro(rs.getString("nom_autor"), 
                        rs.getString("pseu_autor"), 
                        rs.getString("titulo_libro"), 
                        rs.getInt("pag_libro"), 
                        rs.getInt("precio_libro")));
            }
        } catch (SQLException e) {
            System.out.println("Error Listar Autores en Libros= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    //Insertar Autores en Libros
    public void InsertarAutorLibro(int coda, int codl){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("INSERT INTO autorlibro (cod_autor, cod_libro ) "
                    + "VALUES ('"+coda+"','"+codl+"')");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Insertar Autores en Libros= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //Editar Autores en Libros
     public void EditarAutorLibro(int coda, int codl){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("UPDATE autorlibro SET "
                    + "cod_autor='"+coda+"', cod_libro='"+codl+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Editar Autores en Libros= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //Eliminar Categorias en Libros
    
    
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
            "WHERE cod_estado=1");
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
    
    //ComboBox Autores disponibles
    public List ComboBoxAutor(){
    Control_Conexion con=Control_Conexion.getConnection();
    List<Autores> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT cod_autor, concat(nom_autor,'/',pseu_autor) as nom_autor FROM autores");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new Autores(rs.getInt("cod_autor"), rs.getString("nom_autor")));
            }
        } catch (SQLException e) {
            System.out.println("Error ComboBox Autores Disponibles= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
}
