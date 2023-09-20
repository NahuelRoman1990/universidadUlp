/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadulp;

import accesoAdatos.AlumnoData;
import accesoAdatos.Conexion;
import accesoAdatos.InscripcionData;
import accesoAdatos.MateriaData;
import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;

public class UniversidadUlp {

    public static void main(String[] args) {
        // TODO code application logic here
        Connection con = Conexion.getConnection();

        //Alumno juan = new Alumno(1, 35583190, "Amado", "Angela", LocalDate.of(1990, 12, 27), true);
        AlumnoData alu = new AlumnoData();
        ///alu.guardarAlumno(juan);
        //alu.modificarAlumno(juan);
        //alu.eliminarAlumno(5);
        
        Alumno alumnoEncontrado = alu.buscarAlumno(3);
        System.out.println("Buscar alumno");
        System.out.println("DNI: "+ alumnoEncontrado.getDni());
        System.out.println("Apellido: "+ alumnoEncontrado.getApellido());
        System.out.println("fin---");
        Materia mat = new Materia(1, "Programacion", 6, true);
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
        // mate.modificarMateria(mat);
        //mate.eliminarMateria(1);
//        for(Materia materia:mate.listarMateria()){
//            System.out.println("ID materia: "+materia.getIdMateria());
//            System.out.println("Nombre: "+materia.getNombre());
//            System.out.println("Año: "+materia.getAnioMateria());
//            System.out.println("-------");
//        }
       // Inscripcion insc = new Inscripcion(juan, mat, 8);
        InscripcionData idata = new InscripcionData();
        //idata.guardarInscripcion(insc);

        //idata.actualizarNota(1, 1, 9);
        //idata.bajaInscripcionMateria(1, 1);
//          for(Inscripcion inscrip:idata.obtenerInscripciones()){
//              System.out.println("Apellido "+inscrip.getAlumno().getApellido());
//              System.out.println("Nombre "+inscrip.getAlumno().getNombre());
//              System.out.println("Materia "+inscrip.getMateria().getNombre());
//              System.out.println("Nota "+inscrip.getNota());
//              System.out.println("--------");
//              
//              
//          };
//        for (Materia materia : idata.obtenerMateriasCursadas(3)) {
//            System.out.println("ID Materia: "+materia.getIdMateria());
//            System.out.println("Nombre: "+materia.getNombre());
//            System.out.println("Año: "+materia.getAnioMateria());
//         
//        };
//        for (Materia materia : idata.obtenerMateriaNoCursadas(3)) {
//            System.out.println("ID Materia: "+materia.getIdMateria());
//            System.out.println("Nombre: "+materia.getNombre());
//            System.out.println("Año: "+materia.getAnioMateria());
//            System.out.println("----------");
//         
//        };
//        for (Inscripcion inscrip : idata.obtenerInscripcionPorAlumno(3)) {
//            System.out.println("Apellido " + inscrip.getAlumno().getApellido());
//            System.out.println("Nombre " + inscrip.getAlumno().getNombre());
//            System.out.println("Materia " + inscrip.getMateria().getNombre());
//            System.out.println("Nota " + inscrip.getNota());
//            System.out.println("--------");
//
//        };
        for (Alumno alumno : idata.obtenerAlumnosXMaterias(2)) {
            System.out.println(alumno.getApellido());
            System.out.println(alumno.getNombre());
            System.out.println(alumno.getDni());
            System.out.println(alumno.getFechaNac());
            System.out.println("-------");
        }

    }

}
