/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.BoletaOfactura;
import Modelo.MetodoPago;
import Modelo.TipoBF;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mark-
 */

//BOLETAS O FACTURAS DE ARRIENDOS O VENTAS DE LIBROS
public class Control_Boleta_o_Factura {
    
    //combo box para el metodo de pago
     public List comboBoxMetodoP(){
    Control_Conexion con=Control_Conexion.getConnection();
    List<MetodoPago> lista = new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT cod_metod, nom_metod FROM metodopago");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new MetodoPago(rs.getInt("cod_metod"), rs.getString("nom_metod")));
            }
        } catch (SQLException e) {
            System.out.println("Error ComboBox Metodo de Pago= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    //combo box para el tipo (boleta o factura)
    public List comboBoxTipoBoF(){
    Control_Conexion con=Control_Conexion.getConnection();
    List<TipoBF> lista = new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT cod_tipobf,nom_tipobf FROM tipobf");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new TipoBF(rs.getInt("cod_tipobf"), rs.getString("nom_tipobf")));
            }
        } catch (SQLException e) {
            System.out.println("Error ComboBox Tipo BF= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
    
    //eliminar boletas o facturas
    public void EliminarBoF(int cod){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("DELETE FROM boletaofactura WHERE cod_bof='"+cod+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Eliminar Boletas o Facturas= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //editar boletas o facturas
    public void EditarBoF(int cod, String fol, int precioneto, Date fecha, String hora, int codtipo, int metod){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("UPDATE boletaofactura SET "
                    + "folio='"+fol+"',precio_neto='"+precioneto+"',"
                            + "costoiva=precio_neto*0.19, "
                            + "precio_iva=precio_neto+costoiva,"
                            + "fecha='"+fecha+"',"
                            + "hora='"+hora+"',"        
                            + "cod_tipobf='"+codtipo+"',cod_metod='"+metod+"' WHERE cod_bof='"+cod+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Editar Boletas o Facturas= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //insertar boletas o facturas
    public void InsertarBoF(String fol, int precioneto, Date fecha, String hora, int codtipo, int metod){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("INSERT INTO boletaofactura "
                    + "(folio, precio_neto, costoiva, precio_iva, fecha, hora, cod_tipobf, cod_metod) "
                    + "VALUES ('"+fol+"','"+precioneto+"','"+precioneto+"'*0.19,'"+precioneto+"'+costoiva,'"+fecha+"','"+hora+"','"+codtipo+"','"+metod+"')");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Insertar Boletas o Facturas= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    }
    
    //listar boletas o facturas
    public List ListarBoF(String dato){
    Control_Conexion con=Control_Conexion.getConnection();
    List<BoletaOfactura> lista=new ArrayList<>();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("SELECT " +
            "cod_bof," +
            "folio," +
            "precio_neto," +
            "costoiva," +
            "precio_iva," +
            "fecha," +
            "hora," +        
            "nom_tipobf," +
            "nom_metod " +
            "FROM " +
            "boletaofactura " +
            "INNER JOIN tipobf " +
            "ON (boletaofactura.cod_tipobf = tipobf.cod_tipobf) " +
            "INNER JOIN biblioteca.metodopago " +
            "ON (boletaofactura.cod_metod = metodopago.cod_metod) "
            + "WHERE folio LIKE '%"+dato+"%' OR precio_neto LIKE '%"+dato+"%' OR precio_iva LIKE '%"+dato+"%' "
            + "OR fecha LIKE '%"+dato+"%' OR hora LIKE '%"+dato+"%' OR nom_tipobf LIKE '%"+dato+"%' OR "
            + "nom_metod LIKE '%"+dato+"%'");
            ResultSet rs=sql.executeQuery();
            while (rs.next()) {                
                lista.add(new BoletaOfactura(rs.getInt("cod_bof"), 
                        rs.getString("folio"),
                        rs.getInt("precio_neto"), 
                        rs.getInt("costoiva"), 
                        rs.getInt("precio_iva"), 
                        rs.getDate("fecha"), 
                        rs.getTime("hora"),
                        rs.getString("nom_tipobf"), 
                        rs.getString("nom_metod")));
            }
        } catch (SQLException e) {
            System.out.println("Error Listar boletas o Facturas= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    return lista;
    }
}
