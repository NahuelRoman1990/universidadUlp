/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoAdatos;


import entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;

/**
 *
 * @author roman
 */
public class MateriaData {
    
     private Connection con = null;
     
     public MateriaData() {

        con = Conexion.getConnection();
    }
     
     public void guardarMateria(Materia materia){
         String sql = "INSERT INTO materia(nombre, año,estado)"
                 +"VALUES(?,?,?)";
         try {
             PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
             ps.setString(1, materia.getNombre());
             ps.setInt(2, materia.getAnioMateria());
             ps.setBoolean(3, materia.isActivo());
             ps.executeUpdate();
             
             ResultSet rs=ps.getGeneratedKeys();
             
             if(rs.next()){
                 materia.setIdMateria(rs.getInt(1));
                 JOptionPane.showMessageDialog(null, "Materia Guardada");
                 
             }
             ps.close();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia");
         }
         
     }
     
     public Materia buscarMateria(int id){
         return null;

     }
     
     public void modificarMateria(Materia materia){
         
     }
     
     public void eliminarMateria(int id){
         
     }
     
     public List<Materia> listarMateria(){
         return null;
         
     }
}
