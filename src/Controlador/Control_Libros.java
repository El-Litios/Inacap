
package Controlador;


import Modelo.Categoria2;
import Modelo.Editorial;
import Modelo.EstadoLibro;
import Modelo.Libros;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Control_Libros {
    
    //combobox estado del libro
    public List comboboxEstado(){
    Control_Conexion con=Control_Conexion.getConnection();
    List<EstadoLibro> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT cod_estado, nom_estado FROM estadolibro");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new EstadoLibro(rs.getInt("cod_estado"), rs.getString("nom_estado")));
            }
        } catch (SQLException e) {
            System.out.println("Error ComboEstado= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;    
    }
    
    //combobox editorial
    public List comboboxEditorial(){
    Control_Conexion con=Control_Conexion.getConnection();
    List<Editorial> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT cod_edit, nom_edit FROM editoral");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new Editorial(rs.getInt("cod_edit"), rs.getString("nom_edit")));
            }
        } catch (SQLException e) {
            System.out.println("Error ComboEDitorial= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;    
    }
    
    //venta o arriendo libros (eliminar del stock)
    
    
    //editar libros
    public void EditarLibros(int codLibro, String isbn, String titulo, int pag, int precio, int codEstado, int codEdit){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("UPDATE libro SET isbn_libro='"+isbn+"',titulo_libro='"+titulo+"', "
                    + "pag_libro='"+pag+"', precio_libro='"+precio+"', cod_estado='"+codEstado+"', cod_edit='"+codEdit+"' "
                    + "WHERE cod_libro='"+codLibro+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error EditLibro= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //insertar libros
    public void InsertarLibros(String isbn, String titulo, int pag, int precio, int codEstado, int codEdit){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("INSERT INTO libro "
                    + "(isbn_libro,titulo_libro,pag_libro,precio_libro,cod_estado,cod_edit) "
                    + "VALUES ('"+isbn+"','"+titulo+"','"+pag+"','"+precio+"', "
                    + "'"+codEstado+"', '"+codEdit+"')");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error AddLibro= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //listar libros 
    public List listaLibros(String dato){
    List <Libros> lista=new ArrayList<>();
    Control_Conexion con=Control_Conexion.getConnection();
    try {
        con.conectar();
        PreparedStatement sql=con.estado().prepareStatement("SELECT " +
        "cod_libro,isbn_libro,titulo_libro,pag_libro,precio_libro,nom_estado,nom_edit, count(titulo_libro) AS stock " +
        "FROM " +
        "libro " +
        "INNER JOIN editoral " +
        "ON (libro.cod_edit = editoral.cod_edit) " +
        "INNER JOIN biblioteca.estadolibro " +
        "ON (libro.cod_estado = estadolibro.cod_estado) "
        + "WHERE titulo_libro LIKE '%"+dato+"%' OR isbn_libro LIKE '%"+dato+"%' "+
        "group by titulo_libro");
        ResultSet rs=sql.executeQuery();
        while (rs.next()) {                
            lista.add(new Libros(rs.getInt("cod_libro"), 
                    rs.getString("isbn_libro"), 
                    rs.getString("titulo_libro"), 
                    rs.getInt("pag_libro"), 
                    rs.getInt("precio_libro"), 
                    rs.getInt("stock"), 
                    rs.getString("nom_estado"), 
                    rs.getString("nom_edit")));
           }
        } catch (SQLException e) {
            System.out.println("Error ListPaises= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    //listar libros 
    public List ListarLibros1(String dato){
    List <Libros> lista=new ArrayList<>();
    Control_Conexion con=Control_Conexion.getConnection();
    try {
        con.conectar();
        PreparedStatement sql=con.estado().prepareStatement("SELECT " +
        "cod_libro,isbn_libro,titulo_libro,pag_libro,precio_libro,nom_estado,nom_edit " +
        "FROM " +
        "libro " +
        "INNER JOIN editoral " +
        "ON (libro.cod_edit = editoral.cod_edit) " +
        "INNER JOIN estadolibro " +
        "ON (libro.cod_estado = estadolibro.cod_estado) "
        + " WHERE titulo_libro LIKE '%"+dato+"%' OR isbn_libro LIKE '%"+dato+"%' OR pag_libro LIKE '%"+dato+"%' "
        + "OR nom_estado LIKE '%"+dato+"%' OR nom_edit LIKE '%"+dato+"%'");
        ResultSet rs=sql.executeQuery();
        while (rs.next()) {                
            lista.add(new Libros(rs.getInt("cod_libro"), 
                    rs.getString("isbn_libro"), 
                    rs.getString("titulo_libro"), 
                    rs.getInt("pag_libro"), 
                    rs.getInt("precio_libro"), 
                    rs.getString("nom_estado"), 
                    rs.getString("nom_edit")));
           }
        } catch (SQLException e) {
            System.out.println("Error ListPaises= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
 
    public void EliminarLibros(int cod){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("DELETE FROM libro WHERE cod_libro='"+cod+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Eliminar Libro= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //listar editorial
    public List listaEdit(String dato){
    Control_Conexion con=Control_Conexion.getConnection();
    List<Editorial> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT cod_edit, nom_edit FROM editoral WHERE nom_edit LIKE '%"+dato+"%'");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new Editorial(rs.getInt("cod_edit"), rs.getString("nom_edit")));
            }
        } catch (SQLException e) {
            System.out.println("Error listarEdit= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;    
    }
    
    //insertar editoriales
    public void InsertarEdit(String nom){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("INSERT INTO editoral (nom_edit) "
                    + "VALUES ('"+nom+"')");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error AddEdit= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //editar editoriales
    public void EditarEditoriales(int cod, String nom){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("UPDATE editoral SET "
            + "nom_edit='"+nom+"' WHERE cod_edit='"+cod+"' ");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error EditEditoriales= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //eliminar editoriales
    public void eliminarEditoriales(int cod){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("DELETE FROM editoral WHERE cod_edit='"+cod+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error AddLibro= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    
    
    //listar libros 
    public List llenarTablaL(String dato){
    List <Libros> lista=new ArrayList<>();
    Control_Conexion con=Control_Conexion.getConnection();
    try {
        con.conectar();
        PreparedStatement sql=con.estado().prepareStatement("SELECT " +
        "cod_libro" +
        ",isbn_libro" +
        ",titulo_libro" +
        ",pag_libro " +
        "FROM " +
        "libro " +
        "WHERE cod_estado=3 AND isbn_libro like '%"+dato+"%'");
        ResultSet rs=sql.executeQuery();
        while (rs.next()) {                
            lista.add(new Libros(rs.getInt("cod_libro"), rs.getString("isbn_libro"), rs.getString("titulo_libro"), rs.getInt("pag_libro")));
           }
        } catch (SQLException e) {
            System.out.println("Error Lista Libros para formulario en los Arriendos= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    public void CambiarAStock(int cod){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("UPDATE libro SET "
            + "cod_estado=1 WHERE cod_libro='"+cod+"' ");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Cambiar Libro a STOCK= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    
    
    //listar libros 
    public List ListarLibrosClientes(String dato){
    List <Categoria2> lista=new ArrayList<>();
    Control_Conexion con=Control_Conexion.getConnection();
    try {
        con.conectar();
        PreparedStatement sql=con.estado().prepareStatement("SELECT " +
        " titulo_libro" +
        ",pag_libro" +
        ",precio_libro" +
        ",nom_edit" +
        ",nom_autor" +
        ",pseu_autor" +
        ",nom_idioma" +
        ",nom_cate" +
        ",count(titulo_libro) AS stock " +
        "FROM " +
        "autorlibro " +
        "INNER JOIN biblioteca.libro " +
        "ON (autorlibro.cod_libro = libro.cod_libro) " +
        "INNER JOIN biblioteca.autores " +
        "ON (autorlibro.cod_autor = autores.cod_autor) " +
        "INNER JOIN biblioteca.editoral " +
        "ON (libro.cod_edit = editoral.cod_edit) " +
        "INNER JOIN biblioteca.idiomalibro " +
        "ON (idiomalibro.cod_libro = libro.cod_libro) " +
        "INNER JOIN biblioteca.idioma " +
        "ON (idiomalibro.cod_idioma = idioma.cod_idioma) " +
        "INNER JOIN biblioteca.categorialibro " +
        "ON (categorialibro.cod_libro = libro.cod_libro)" +
        "INNER JOIN biblioteca.categoria " +
        "ON (categorialibro.cod_categoria = categoria.cod_cate)  " +
        "WHERE titulo_libro LIKE '%"+dato+"%' OR nom_edit LIKE '%"+dato+"%' OR nom_autor LIKE '%"+dato+"%' OR pseu_autor LIKE '%"+dato+"%' OR nom_cate LIKE '%"+dato+"%' AND cod_estado=1 " +
        "group  by titulo_libro, nom_edit");
        ResultSet rs=sql.executeQuery();
        while (rs.next()) {                
            lista.add(new Categoria2(rs.getString("nom_cate"), 
                    rs.getString("nom_idioma"), 
                    rs.getString("nom_autor"), 
                    rs.getString("pseu_autor"), 
                    rs.getString("titulo_libro"), 
                    rs.getInt("pag_libro"), 
                    rs.getInt("precio_libro"), 
                    rs.getInt("stock"), 
                    rs.getString("nom_edit")));
           }
        } catch (SQLException e) {
            System.out.println("Error Listar Libros para Cientes= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
}
