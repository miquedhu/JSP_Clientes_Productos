/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelCliente;

import java.sql.Connection;
//import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Miguel
 */
public class Conexion {
    //DATOS DE LA CONEXION
    public String bd = "jsp_cliente";
    //Mejora, modularizamos el nombre del servidor
    public String srv = "127.0.0.1";
    //URL con jdbc para indicar el metodo de conexion y colocamos el el puerto después del enlace
    public String url = "jdbc:mysql://"+srv+":3306/"+bd;
    //Nombre de usuario de la base de datos
    public String user = "root";
    //Nombre de usuario de la contraseña
    public String pass = "";
   
    //1.ESTABLCER CONEXION
    //FUNCION QUE CONECTA CON LA BASE DE DATOS Y JAVA.
    public Connection connect(){
        //Ruta del driver de conexión
         Connection conexion = null;
        try {
            //Nombre del drivers
            Class.forName("org.gjt.mm.mysql.Driver");//Indicamos dónde esta el Driver
           DriverManager.getConnection(url, user, pass);
           conexion=DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion establecida con exito");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Conexion erronea");
            
        }
        return conexion;
     
    }
    //El constructor
    public Conexion() {
    }
    
}
