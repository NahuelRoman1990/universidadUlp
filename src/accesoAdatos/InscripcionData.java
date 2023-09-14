/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoAdatos;

import entidades.Inscripcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author roman
 */
public class InscripcionData {
    private Connection con=null;
    
    
    public InscripcionData(){
        this.con=Conexion.getConnection();
    }
    
    
    public void guardarInscripcion(Inscripcion insc){
        String sql="INSERT INTO inscripcion(idAlumno, idMateria, nota) VALUES(?,?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, insc.getAlumno().getIdAlumno());
            ps.setInt(2, insc.getMateria().getIdMateria());
            ps.setDouble(3, insc.getNota());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripcion Registrada");
            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de inscripcion");
        }
    }
    
    public void actualizarNota(int idAlumno, int idMateria, double nota){
        
     String sql="UPDATE inscripcion SET nota = ? WHERE idAlumno = ? ANDA idMATERIA = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            ps.executeUpdate();
            int filas=ps.executeUpdate();
            if(filas>0){
                JOptionPane.showMessageDialog(null, "Nota Actualizada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
    }
}
