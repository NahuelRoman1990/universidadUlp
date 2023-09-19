/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import accesoAdatos.AlumnoData;
import accesoAdatos.InscripcionData;
import accesoAdatos.MateriaData;
import entidades.Alumno;
import entidades.Materia;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author roman
 */
public class AlumnoPorMateria extends javax.swing.JInternalFrame {

    private InscripcionData idata = new InscripcionData();
    private MateriaData md = new MateriaData();
    private AlumnoData ad = new AlumnoData();
    private DefaultTableModel modelo=new DefaultTableModel();

    /**
     * Creates new form AlumnoPorMateria
     */
    public AlumnoPorMateria() {
        initComponents();
        cargarCombo();
        cabeceraListarMateria();

    }

    private void cargarCombo() {
        md.listarMateria();
        for (Materia mate : md.listarMateria()) {
            
       
            jcbListadoMaterias.addItem(mate);
        }
        
    } 
    
    private void cabeceraListarMateria(){
        modelo.addColumn("ID");
        modelo.addColumn("DNI");
        modelo.addColumn("APELLIDO");
        modelo.addColumn("NOMBRE");
        jtAlumno.setModel(modelo);
    }
    
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbListadoMaterias = new javax.swing.JComboBox<>();
        JscrollAlumMateria = new javax.swing.JScrollPane();
        jtAlumno = new javax.swing.JTable();
        jbSalir = new javax.swing.JButton();

        jLabel1.setText("Listado de Alumnos por Materia");

        jLabel2.setText("Seleccione una materia:");

        jcbListadoMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbListadoMateriasActionPerformed(evt);
            }
        });

        jtAlumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "DNI", "Apellido", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JscrollAlumMateria.setViewportView(jtAlumno);

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
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbListadoMaterias, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel1)
                .addContainerGap(176, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JscrollAlumMateria)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jcbListadoMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JscrollAlumMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jcbListadoMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbListadoMateriasActionPerformed
      
//        if (jtAlumno.getRowCount()>=0){
//          borrarFilas();  
//      }
            
      Materia materiaSelect =(Materia)jcbListadoMaterias.getSelectedItem();
      List<Alumno> listaAlumno = idata.obtenerAlumnosXMaterias(materiaSelect.getIdMateria());
      for(Alumno alumno:listaAlumno){
          modelo.addRow(new Object[]{alumno.getIdAlumno(),alumno.getDni(),alumno.getApellido(),alumno.getNombre()});
          
      }
    }//GEN-LAST:event_jcbListadoMateriasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JscrollAlumMateria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Materia> jcbListadoMaterias;
    private javax.swing.JTable jtAlumno;
    // End of variables declaration//GEN-END:variables

private void borrarFilas(){
    int fila = jtAlumno.getRowCount()-1;
    for(;fila>=0;fila--){
        modelo.removeRow(fila);
    }
    
}


}
