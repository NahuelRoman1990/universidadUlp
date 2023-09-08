/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadulp;

import accesoAdatos.AlumnoData;
import accesoAdatos.Conexion;
import entidades.Alumno;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author roman
 */
public class UniversidadUlp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection con=Conexion.getConnection();
        
        Alumno juan = new Alumno(1,35583190, "Amado", "Angela", LocalDate.of(1990, 12, 27), true);
        AlumnoData alu=new AlumnoData();
        ///alu.guardarAlumno(juan);
        //alu.modificarAlumno(juan);
        alu.eliminarAlumno(1);
    }
    
}
