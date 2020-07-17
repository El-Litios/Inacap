
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Control_Conexion {
    private static Control_Conexion cc;
    private Connection conn;
    private String url="jdbc:mysql://127.0.0.1/biblioteca";
    private String usu="root";
    private String pass="";
    private String driver="com.mysql.jdbc.Driver";
    
    
    //constructor
    private Control_Conexion(){ 
       conectar();
    }
    
    public static Control_Conexion getConnection(){
        if (cc==null) {
            cc =new Control_Conexion();
        }
        return cc;
    }
    
    public Connection conectar(){
     try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,usu,pass);
            if (conn != null){
                System.out.println("CONCECTADO A :"+url);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("ERROR Conex "+e);
        }
     return conn;
    }
    
    public void desconectar(){
        try {
            if (conn != null) {
                conn.close();
                conn=null;
            }
        } catch (SQLException e) {
        System.out.println("ERROR desconectar "+e);
        }
    }
    
    public  Connection estado(){
    return conn;
    }
    
    
    
     
    
}
