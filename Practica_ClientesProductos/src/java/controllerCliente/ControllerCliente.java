/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerCliente;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelCliente.Cliente;
import modelCliente.Conexion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



/**
 *
 * @author Miguel
 */
@Controller
//Anotación URL.
//@RequestMapping("/cliente")
public class ControllerCliente {
    //Definimos la conexion
    Conexion cn = new Conexion(); //Conexion programa-base de datos
    Connection con = cn.connect(); //Camino por el que viajan los datos
    
    //EL metodo ModelAndView sirve para enlazar un solo formulario a un controller o un metodo del controller
    //El ModelAndView comunica el servlet con los jsp's.
    @RequestMapping(value="crearcliente",method=RequestMethod.GET)
    public ModelAndView crearCliente(){
        Cliente cliente = new Cliente();
        //Con los parametros "commando" y es objeto, nos autorellena el objeto.
        //crearcliente es la página con la que enlazamos, command es el enlace, cliente es el objeto
        ModelAndView resultado = new ModelAndView("crearcliente");
        //Se puede enviar así,en Spring
            //sendRedirect
        //Antes se usaba de esta forma
        //request.getRequestDispatcher("/WEB-INF/jsp/crearcliente.jsp").forward(request, response);
       //Al devolver el resultado, indicamos que debe dirigirse a crearcliente.
       resultado.addObject("cliente", cliente); 
       return resultado;
    }
    //Con RequestMethod indicamos el modo de envio de Datos
   /*@RequestMapping(value="crearcliente.htm",method=RequestMethod.POST)
   //Con la anotacion de clase ModelAttributee indicamos que el objeto generico, es de tipo cliente.
   //Hacemos un casting del objeto generico al cliente 
   public ModelAndView crearCliente(@ModelAttribute("cliente") Cliente cliente){

        //Añadimos el cliente a la BD
        //Generamos la sentencia SQL
        String sql = "INSERT INTO cliente (cliente_nombre, cliente_apellido, edad) VALUES (?,?,?)";
        
        try {
            //Hacemos el Prepared Statement
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellido());
            pst.setInt(3, cliente.getEdad());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
           
        }
        
       //Manera antigua
        //request.setAttribute("mensaje", msg);
        
        //Con el objeto ModelAndView pasamos información del controller a la vista.
        ModelAndView resultado = new ModelAndView("mostrarcliente");
        //Se puede enviar así,en Spring
            //sendRedirect
        //Antes se usaba de esta forma
        //request.getRequestDispatcher("/WEB-INF/jsp/crearcliente.jsp").forward(request, response);
        resultado.addObject("cliente",cliente);
        return resultado;
    }*/
    @RequestMapping(value="crearcliente",method=RequestMethod.POST)
   //Con la anotacion de clase ModelAttributee indicamos que el objeto generico, es de tipo cliente.
   //Hacemos casting del cliente y creamos el objeto Model para enviar .
   public String crearCliente(@ModelAttribute("cliente") Cliente cliente,Model model){

        //Añadimos el cliente a la BD
        //Generamos la sentencia SQL
        String sql = "INSERT INTO cliente (cliente_nombre, cliente_apellido, edad) VALUES (?,?,?)";
        
        try {
            //Hacemos el Prepared Statement
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellido());
            pst.setInt(3, cliente.getEdad());
            pst.executeUpdate();
            
        } catch (SQLException ex) {
           
        }
        
       //Manera antigua
        //request.setAttribute("mensaje", msg);
        
        
        //Se puede enviar así,en Spring
            //sendRedirect
        //Antes se usaba de esta forma
        //request.getRequestDispatcher("/WEB-INF/jsp/crearcliente.jsp").forward(request, response);
        model.addAttribute("cliente",cliente);
        return "mostrarcliente";
    }
   @RequestMapping("visualizarcliente")
   public String visualizarcliente(Model model){
       ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
       //Obtenemos los clientes de la BD
       
        String sql="SELECT * FROM cliente";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Cliente aux = new Cliente();
                aux.setNombre(rs.getString("cliente_nombre"));
                aux.setApellido(rs.getString("cliente_apellido"));
                //System.out.println(aux.getNombre());
                aux.setEdad(rs.getInt("edad"));
                aux.setId(rs.getInt("cliente_id"));
                listaClientes.add(aux);
                
            }
             model.addAttribute("lista",listaClientes);
      
        } catch (SQLException ex) {
            Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       //Los añadimos a la ArrayList
       return "visualizarcliente";
   }
   //Metodo con URL amigable 
   @RequestMapping(value="modificarcliente",method=RequestMethod.GET)
   public String modificarCliente(@RequestParam int id, Model model){
       //Creamos la sentencia SQL
       String sql="SELECT * FROM cliente WHERE cliente_id ="+id;
       //Creamos un cliente para poder extraer los datos del resultado del sql
       Cliente aux = new Cliente();
       try {
           
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(sql);
           while(rs.next()){
               aux.setNombre(rs.getString("cliente_nombre"));
               aux.setApellido(rs.getString("cliente_apellido"));
               
           }
           model.addAttribute("cliente",aux);
       } catch (Exception e) {
       }
        return "modificarcliente";
    }
   
   @RequestMapping(value="modificarcliente/{id}/",method=RequestMethod.GET)
   public String modificarCliente(@PathVariable String id, Model model){
       //Creamos la sentencia SQL
       String sql="SELECT * FROM cliente WHERE cliente_id ="+id;
       //Creamos un cliente para poder extraer los datos del resultado del sql
       Cliente aux = new Cliente();
       try {
           
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(sql);
           while(rs.next()){
               aux.setNombre(rs.getString("cliente_nombre"));
               aux.setApellido(rs.getString("cliente_apellido"));
               
           }
           model.addAttribute("cliente",aux);
       } catch (Exception e) {
       }
        return "modificarcliente";
    }
  
   @RequestMapping(value="eliminar/{id}/",method=RequestMethod.GET)
    public String eliminarCliente(@PathVariable String id, Model model){
        String msg;
        try {
            //Creamos la sentencia SQL
            String sql = "DELETE FROM cliente WHERE cliente_id ="+id;
            
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            
            msg = "Usuario eliminado correctamente";
        } catch (SQLException ex) {
            Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
            msg = "Error al eliminar el usuario";
        }
        
        model.addAttribute("msg",msg);
        return "eliminar";
    }
    @RequestMapping("obtenercliente")
     public String obtenerCliente(HttpServletRequest request, Model model){
         String name= request.getParameter("nombre");
         String lastname = request.getParameter("apellido1");
         model.addAttribute("nombre",name);
         model.addAttribute("apellido",lastname);
         return "crear cliente";
     }
}
