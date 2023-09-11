/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadulp;

import accesoAdatos.AlumnoData;
import accesoAdatos.Conexion;
import accesoAdatos.MateriaData;
import entidades.Alumno;
import entidades.Materia;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;

public class UniversidadUlp {

    public static void main(String[] args) {
        // TODO code application logic here
        Connection con = Conexion.getConnection();

        //Alumno juan = new Alumno(1,35583190, "Amado", "Angela", LocalDate.of(1990, 12, 27), true);
        AlumnoData alu = new AlumnoData();
        ///alu.guardarAlumno(juan);
        //alu.modificarAlumno(juan);
        //alu.eliminarAlumno(1);
//        Alumno alumnoEncontrado = alu.buscarAlumno(1);
//        System.out.println("DNI: "+ alumnoEncontrado.getDni());
//        System.out.println("Apellido: "+ alumnoEncontrado.getApellido());
        Materia mat = new Materia(1,"Programacion", 6, true);
        MateriaData mate = new MateriaData();
       // mate.guardarMateria(mat);

        /*for(Alumno alumno:alu.listarAlumnos()){
            System.out.println(alumno.getApellido());
            System.out.println(alumno.getDni());
            System.out.println(alumno.getNombre());
            System.out.println(alumno.getFechaNac());
        }*/
        //Materia materiaEncontrada = mate.buscarMateria(1);
        //System.out.println("NOMBRE: "+ materiaEncontrada.getNombre()+" AÑO: "+ materiaEncontrada.getAnioMateria());
        
        mate.modificarMateria(mat);

    }

}
