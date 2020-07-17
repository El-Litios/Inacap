/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.Categoria;
import Modelo.CategoriaLibro;
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
public class Control_CategoriaLibro {
    //listar Categorias en Libros
    public List ListarCategLibro(String dato){
    Control_Conexion con=Control_Conexion.getConnection();
    List<CategoriaLibro> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT  isbn_libro," +
            "titulo_libro" +
            ",pag_libro" +
            ",precio_libro" +
            ",nom_cate " +
            "FROM " +
            "categorialibro " +
            "INNER JOIN libro " +
            "ON (categorialibro.cod_libro = libro.cod_libro) " +
            "INNER JOIN categoria " +
            "ON (categorialibro.cod_categoria = categoria.cod_cate) "
            + "WHERE titulo_libro LIKE '%"+dato+"%' OR nom_cate LIKE '%"+dato+"%' OR isbn_libro LIKE '%"+dato+"%'");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new CategoriaLibro(rs.getString("isbn_libro"),rs.getString("titulo_libro"), 
                        rs.getInt("pag_libro"), 
                        rs.getInt("precio_libro"), 
                        rs.getString("nom_cate")));
            }
        } catch (SQLException e) {
            System.out.println("Error Listar Categorias en Libros= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    //Insertar Categorias en Libros
    public void InsertarCategLibro(int codc, int codl){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("INSERT INTO categorialibro (cod_libro, cod_categoria ) "
                    + "VALUES ('"+codl+"','"+codc+"')");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Insertar Categorias en Libros= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //Editar Categorias en Libros
     public void EditarCategLibro(int codc, int codl){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("UPDATE categorialibro SET "
                    + "cod_libro='"+codc+"', cod_categoria='"+codl+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Editar Idiomas en Libros= "+"\n"+e);
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
            PreparedStatement sql=con.estado().prepareStatement("SELECT cod_libro, isbn_libro FROM libro WHERE cod_estado=6");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new Libros(rs.getInt("cod_libro"), rs.getString("isbn_libro")));
            }
        } catch (SQLException e) {
            System.out.println("Error ComboBox Libros En Reposicion= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    //ComboBox Categorias disponibles
    public List ComboBoxCate(){
    Control_Conexion con=Control_Conexion.getConnection();
    List<Categoria> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT cod_cate, nom_cate FROM categoria ");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new Categoria(rs.getInt("cod_cate"), rs.getString("nom_cate")));
            }
        } catch (SQLException e) {
            System.out.println("Error ComboBox Categorias Disponibles= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
}
