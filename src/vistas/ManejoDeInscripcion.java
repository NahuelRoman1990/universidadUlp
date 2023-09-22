package vistas;

import accesoAdatos.AlumnoData;
import accesoAdatos.InscripcionData;
import accesoAdatos.MateriaData;
import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ManejoDeInscripcion extends javax.swing.JInternalFrame {

    private InscripcionData idata = new InscripcionData();
    private MateriaData md = new MateriaData();
    private AlumnoData ad = new AlumnoData();
    private DefaultTableModel modelo = new DefaultTableModel();

    public ManejoDeInscripcion() {
        initComponents();
        cargarCombo();
        cargarCabecera();
    }

    private void cargarCabecera() {
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Año");

        jtMaterias.setModel(modelo);

    }

    private void cargarCombo() {

        for (Alumno alu : ad.listarAlumnos()) {

            jcbListaAlumno.addItem(alu);
        }

    }
    
    private void cargarMateriasNoInscriptas(){
        jrbMateriasInscriptas.setSelected(false);
        jbAnularInscripcion.setEnabled(false);
        jbInscribir.setEnabled(true);
        borrarFilas();

        //falta borrar la lista cada vez que se cargue
        Alumno alumno = (Alumno) jcbListaAlumno.getSelectedItem();
        List<Materia> materias = idata.obtenerMateriaNoCursadas(alumno.getIdAlumno());
        for (Materia mate : materias) {
            modelo.addRow(new Object[]{mate.getIdMateria(), mate.getNombre(), mate.getAnioMateria()});

        }
    }
    
    private void cargarMateriasInscriptas(){
        jrbMateriasNoInscriptas.setSelected(false);
        jbInscribir.setEnabled(false);
        jbAnularInscripcion.setEnabled(true);
        borrarFilas();

        Alumno alumno = (Alumno) jcbListaAlumno.getSelectedItem();
        //borrar la lista 
        List<Materia> materias = idata.obtenerMateriasCursadas(alumno.getIdAlumno());
        for (Materia mate : materias) {
            modelo.addRow(new Object[]{mate.getIdMateria(), mate.getNombre(), mate.getAnioMateria()});

        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jlFormularioIncripcion = new javax.swing.JLabel();
        jlSeleccionAlumno = new javax.swing.JLabel();
        jcbListaAlumno = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jrbMateriasInscriptas = new javax.swing.JRadioButton();
        jrbMateriasNoInscriptas = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtMaterias = new javax.swing.JTable();
        jbInscribir = new javax.swing.JButton();
        jbAnularInscripcion = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jlFormularioIncripcion.setFont(new java.awt.Font("Arial Black", 2, 14)); // NOI18N
        jlFormularioIncripcion.setText("Formulario de Inscripcion");

        jlSeleccionAlumno.setText("Seleccione un Alumno:");

        jcbListaAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbListaAlumnoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial Black", 2, 14)); // NOI18N
        jLabel2.setText("Listado de Materias");

        jrbMateriasInscriptas.setText("Materias Inscriptas");
        jrbMateriasInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMateriasInscriptasActionPerformed(evt);
            }
        });

        jrbMateriasNoInscriptas.setText("Materias no Inscriptas");
        jrbMateriasNoInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMateriasNoInscriptasActionPerformed(evt);
            }
        });

        jtMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Año"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtMaterias);
        if (jtMaterias.getColumnModel().getColumnCount() > 0) {
            jtMaterias.getColumnModel().getColumn(0).setResizable(false);
            jtMaterias.getColumnModel().getColumn(1).setResizable(false);
            jtMaterias.getColumnModel().getColumn(2).setResizable(false);
        }

        jbInscribir.setText("Inscribir");
        jbInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInscribirActionPerformed(evt);
            }
        });

        jbAnularInscripcion.setText("Anular Inscripcion");
        jbAnularInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnularInscripcionActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlFormularioIncripcion)
                .addGap(96, 96, 96))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jbInscribir)
                        .addGap(71, 71, 71)
                        .addComponent(jbAnularInscripcion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jrbMateriasInscriptas)
                                            .addGap(45, 45, 45)
                                            .addComponent(jrbMateriasNoInscriptas))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jlSeleccionAlumno)
                                            .addGap(45, 45, 45)
                                            .addComponent(jcbListaAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jlFormularioIncripcion)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlSeleccionAlumno)
                    .addComponent(jcbListaAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbMateriasInscriptas)
                    .addComponent(jrbMateriasNoInscriptas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbInscribir)
                    .addComponent(jbAnularInscripcion)
                    .addComponent(jbSalir))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrbMateriasInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMateriasInscriptasActionPerformed
        cargarMateriasInscriptas();
    }//GEN-LAST:event_jrbMateriasInscriptasActionPerformed

    private void jrbMateriasNoInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMateriasNoInscriptasActionPerformed
        cargarMateriasNoInscriptas();

    }//GEN-LAST:event_jrbMateriasNoInscriptasActionPerformed

    private void borrarFilas() {
        int fila = jtMaterias.getRowCount() - 1;
        for (; fila >= 0; fila--) {
            modelo.removeRow(fila);
        }

    }

    private void jcbListaAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbListaAlumnoActionPerformed
     if(jrbMateriasNoInscriptas.isSelected()){
         cargarMateriasNoInscriptas();
         
     }else if(jrbMateriasInscriptas.isSelected()){
         cargarMateriasInscriptas();
     }
    }//GEN-LAST:event_jcbListaAlumnoActionPerformed

    private void jbAnularInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnularInscripcionActionPerformed
         int fila = jtMaterias.getSelectedRow();
        if (fila != -1) {
            int idmate = (Integer) jtMaterias.getValueAt(fila, 0);
            Materia materia = md.buscarMateria(idmate);
            Alumno alumno = (Alumno) jcbListaAlumno.getSelectedItem();
            int idalum = alumno.getIdAlumno();
            idata.bajaInscripcionMateria(idalum, idmate);
            borrarFilas();
            cargarMateriasInscriptas();
            
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una materia");
        }
    }//GEN-LAST:event_jbAnularInscripcionActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInscribirActionPerformed
        int fila = jtMaterias.getSelectedRow();
        if (fila != -1) {
            int idmate = (Integer) jtMaterias.getValueAt(fila, 0);
            Materia materia = md.buscarMateria(idmate);
            Alumno alumno = (Alumno) jcbListaAlumno.getSelectedItem();
            Inscripcion inscripcion = new Inscripcion();
            inscripcion.setMateria(materia);
            inscripcion.setAlumno(alumno);
            idata.guardarInscripcion(inscripcion);
            borrarFilas();
            cargarMateriasNoInscriptas();
            
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una materia");
        }


    }//GEN-LAST:event_jbInscribirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbAnularInscripcion;
    private javax.swing.JButton jbInscribir;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Alumno> jcbListaAlumno;
    private javax.swing.JLabel jlFormularioIncripcion;
    private javax.swing.JLabel jlSeleccionAlumno;
    private javax.swing.JRadioButton jrbMateriasInscriptas;
    private javax.swing.JRadioButton jrbMateriasNoInscriptas;
    private javax.swing.JTable jtMaterias;
    // End of variables declaration//GEN-END:variables
}
