/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import accesoAdatos.AlumnoData;
import accesoAdatos.InscripcionData;
import accesoAdatos.MateriaData;
import com.sun.webkit.dom.EventImpl;
import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vistas.ManejoDeInscripcion;

/**
 *
 * @author Erni
 */
public class ManipulacionNotas extends javax.swing.JInternalFrame {

    private InscripcionData idata = new InscripcionData();
    private MateriaData md = new MateriaData();
    private AlumnoData ad = new AlumnoData();
    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            if (c == 3) {
                return true;
            } else {
                return false;
            }
        }
    };

    public ManipulacionNotas() {
        initComponents();
        cargarCombo();
        cargarCabecera();
        cargarMateriasInscriptas();

    }

    private void cargarCombo() {

        for (Alumno alu : ad.listarAlumnos()) {

            jcbAlumno.addItem(alu);
        }

    }

    private void cargarCabecera() {
        modelo.addColumn("CCÓDIGO");
        modelo.addColumn("ID MATERIA");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("NOTA");
        jtInscripcion.setModel(modelo);
    }

    private void borrarFilas() {
        int fila = jtInscripcion.getRowCount() - 1;
        for (; fila >= 0; fila--) {
            modelo.removeRow(fila);
        }

    }

    private void cargarMateriasInscriptas() {
        borrarFilas();

        Alumno alumno = (Alumno) jcbAlumno.getSelectedItem();

        List<Inscripcion> inscripcion = idata.obtenerInscripcionPorAlumno(alumno.getIdAlumno());
        
            for (Inscripcion insc : inscripcion) {
            modelo.addRow(new Object[]{insc.getIdInscripcion(), insc.getMateria().getIdMateria(), insc.getMateria().getNombre(), insc.getNota()});

        
        }
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtInscripcion = new javax.swing.JTable();
        jbGuardar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jcbAlumno = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Actualización de notas");

        jLabel2.setText("Seleccione un alumno");

        jtInscripcion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtInscripcion);

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jcbAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAlumnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(85, 85, 85)
                        .addComponent(jcbAlumno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbGuardar)
                        .addGap(123, 123, 123)
                        .addComponent(jbSalir)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(99, 99, 99))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbSalir))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jcbAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAlumnoActionPerformed
        cargarMateriasInscriptas();
    }//GEN-LAST:event_jcbAlumnoActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed

         try {
    for (int i = 0; i < jtInscripcion.getRowCount(); i++) {
        Object nota = jtInscripcion.getValueAt(i, 3);
        
        if (nota instanceof String) {
            
            double notaDouble = Double.parseDouble((String) nota);

            if (notaDouble >= 0 && notaDouble <= 10) {
                int idMateria = (Integer) jtInscripcion.getValueAt(i, 1);

                Alumno alumno = (Alumno) jcbAlumno.getSelectedItem();
                int idAlumno = alumno.getIdAlumno();

                idata.actualizarNota(idAlumno, idMateria, notaDouble);
            } else {
                JOptionPane.showMessageDialog(this, "La nota debe encontrarse entre 0 y 10");
            }
        } 
    }
    JOptionPane.showMessageDialog(null, "Notas Actualizadas");
} catch (NumberFormatException nf) {
    JOptionPane.showMessageDialog(this, "La nota debe ser un número decimal");
}
//            } catch (ClassCastException cce) {
//                JOptionPane.showMessageDialog(this, "Presione enter para guardar la nota");
//            }

        

//        if (fila != -1) {
//            
//            try{
//            int idIncs = (Integer) jtInscripcion.getValueAt(fila, 0);
//            int idMateria = (Integer) jtInscripcion.getValueAt(fila, 1);
//            double nota = Double.parseDouble((String) jtInscripcion.getValueAt(fila, 3));
//            Alumno alumno = (Alumno) jcbAlumno.getSelectedItem();
//            int idAlumno = alumno.getIdAlumno();
//            if(nota>=0 && nota <=10){  
//            idata.actualizarNota(idAlumno, idMateria, nota);
//            }else{
//                JOptionPane.showMessageDialog(this, "La nota debe encontrarse entre 0 y 10");
//            }
//            }catch (NumberFormatException nf){
//                JOptionPane.showMessageDialog(this, "La nota debe ser un número decimal");
//                jtInscripcion.setValueAt("", fila, 3);
//            }catch (ClassCastException cce){
//                JOptionPane.showMessageDialog(this, "Presione enter para guardar la nota");
//            }
//
//        }
    }//GEN-LAST:event_jbGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Alumno> jcbAlumno;
    private javax.swing.JTable jtInscripcion;
    // End of variables declaration//GEN-END:variables
}
