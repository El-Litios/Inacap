package Controlador;

import Modelo.Cargo;
import Modelo.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Control_Usuario extends Usuarios {

    public void EliminarUsuarios(int cod){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("DELETE FROM usuarios WHERE cod_usu='"+cod+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Eliminar Usuarios= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    
    }
    
    public void EditarUsuarios(int cod, String usu, String pass, int codR){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("UPDATE usuarios SET "
                    + "nom_usu='"+usu+"', pass_usu='"+pass+"', cod_cargo='"+codR+"' WHERE cod_usu='"+cod+"'");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Editar Usuarios= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    
    }
    
    public void InsertarUsuarios(String usu, String pass, int codR){
    Control_Conexion con=Control_Conexion.getConnection();
        try {
            con.conectar();
            PreparedStatement sql=con.estado().prepareStatement("INSERT INTO usuarios (nom_usu, pass_usu, cod_cargo) VALUES "
                    + "('"+usu+"', '"+pass+"', '"+codR+"')");
            sql.execute();
        } catch (SQLException e) {
            System.out.println("Error Insertar Usuarios= "+"\n"+e);
        }finally{
        con.desconectar();
        }
    
    }
    
    public List listar(String dato){
        Control_Conexion conex = Control_Conexion.getConnection();
        List<Usuarios> lista = new ArrayList<>();
        try {
            conex.conectar();
            PreparedStatement sql=conex.estado().prepareStatement("SELECT " +
            " cod_usu, nom_usu ,pass_usu ,nom_cargo FROM usuarios " +
            " INNER JOIN cargos" +
            " ON (usuarios.cod_cargo = cargos.cod_cargos) "
                    + "WHERE nom_usu LIKE '%"+dato+"%' OR nom_cargo LIKE '%"+dato+"%'");
            ResultSet res=sql.executeQuery();
            while(res.next()){
            lista.add(new Usuarios(res.getInt("cod_usu"), res.getString("nom_usu"), res.getString("pass_usu"), res.getString("nom_cargo")));
            }
        } catch (SQLException e) {
            System.out.println("ERROR ListaUsuarios: "+e);
        }finally{
            conex.desconectar();
        }
        return lista;
    }
    
    
    public List ComboBoxCargosU(){
        Control_Conexion conex = Control_Conexion.getConnection();
        List<Cargo> lista = new ArrayList<>();
        try {
            conex.conectar();
            PreparedStatement sql=conex.estado().prepareStatement("SELECT cod_cargos, nom_cargo FROM Cargos");
            ResultSet res=sql.executeQuery();
            while(res.next()){
            lista.add(new Cargo(res.getInt("cod_cargos"), res.getString("nom_cargo")));
            }
        } catch (SQLException e) {
            System.out.println("ERROR ComboBox para Cargos de Usuarios: "+e);
        }finally{
            conex.desconectar();
        }
        return lista;
    }
    
    
     public boolean login(String usu, String pass, String carnom){
        Control_Conexion conex = Control_Conexion.getConnection();
        try {
            conex.conectar();
            PreparedStatement sql=conex.estado().prepareStatement("SELECT " +
        "nom_usu " +
        ",pass_usu " +
        ",nom_cargo FROM usuarios " +
        "INNER JOIN cargos " +
        "ON (usuarios.cod_cargo = cargos.cod_cargos)"
        +" WHERE nom_usu='"+usu+"' AND pass_usu='"+pass+"' AND nom_cargo='"+carnom+"'");
            ResultSet res=sql.executeQuery();
            if (res.next()){
                this.setNom_usu("nom_usu");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("ERROR: "+e);
        }finally{
            conex.desconectar();
        }
        return false;
    }
    
}
