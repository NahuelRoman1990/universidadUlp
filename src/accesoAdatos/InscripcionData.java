/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoAdatos;

import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author roman
 */
public class InscripcionData {

    private Connection con = null;
    private MateriaData md = new MateriaData();
    private AlumnoData ad = new AlumnoData();

    public InscripcionData() {
        this.con = Conexion.getConnection();
    }

    public void guardarInscripcion(Inscripcion insc) {
        String sql = "INSERT INTO inscripcion(idAlumno, idMateria, nota) VALUES(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, insc.getAlumno().getIdAlumno());
            ps.setInt(2, insc.getMateria().getIdMateria());
            ps.setDouble(3, insc.getNota());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripcion Registrada");
            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de inscripcion");
        }
    }

    public void actualizarNota(int idAlumno, int idMateria, double nota) {

        String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno = ? AND idMateria = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            ps.executeUpdate();
            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Nota Actualizada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
    }

    public void bajaInscripcioMateria(int idAlumno, int idMateria) {

        String sql = "DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Inscripcion Borrada");

            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");
        }
    }

    public List<Inscripcion> obtenerInscripciones() {

        ArrayList<Inscripcion> cursos = new ArrayList<>();

        String sql = "SELECT * FROM inscripcion";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Inscripcion insc = new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripcio"));
                Alumno alum = ad.buscarAlumno(rs.getInt("idAlumno"));
                Materia mat = md.buscarMateria(rs.getInt("idMateria"));
                insc.setAlumno(alum);
                insc.setMateria(mat);
                insc.setNota(rs.getDouble("nota"));
                cursos.add(insc);
            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion");

        }
        return cursos;
    }

    public List<Materia> obtenerMateriasCursadas(int idAlumno) {

        ArrayList<Materia> materias = new ArrayList<>();

        String sql = "SELECT inscripcion.idMateria, nombre, año FROM inscripcion, materia WHERE inscripcion.idMateria ="
                + " materia.idMateria AND inscripcion.idAlumno = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materias.add(materia);

            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion");

        }
        return materias;
    }
    public List<Materia> obtenerMateriaNoCursadas(int idAlumno){
        ArrayList<Materia> materias=new ArrayList<>();
        
        String sql = "SELECT * FROM materia WHERE estado = 1 AND idMateria not in"
                + "SELECT idMateria FROM inscripcion WHERE idAlumno = ?";
        
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materias.add(materia);

            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripcion");

        }
        return materias;
        
        
        
    }
}
