
package vistas;


public class MenuPrincipal extends javax.swing.JFrame {

    
    public MenuPrincipal() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdEscritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmAlumno = new javax.swing.JMenu();
        jmItemAlumnoFormulario = new javax.swing.JMenuItem();
        jmMateria = new javax.swing.JMenu();
        jmItemMateriaFormulario = new javax.swing.JMenuItem();
        jmAdministracion = new javax.swing.JMenu();
        jmManejoIncripcion = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jmConsultas = new javax.swing.JMenu();
        jmItemAlumnosPorMateria = new javax.swing.JMenuItem();
        jmSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jdEscritorioLayout = new javax.swing.GroupLayout(jdEscritorio);
        jdEscritorio.setLayout(jdEscritorioLayout);
        jdEscritorioLayout.setHorizontalGroup(
            jdEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );
        jdEscritorioLayout.setVerticalGroup(
            jdEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        jmAlumno.setText("Alumno");

        jmItemAlumnoFormulario.setText("Formulario Alumno");
        jmItemAlumnoFormulario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmItemAlumnoFormularioActionPerformed(evt);
            }
        });
        jmAlumno.add(jmItemAlumnoFormulario);

        jMenuBar1.add(jmAlumno);

        jmMateria.setText("Materia");

        jmItemMateriaFormulario.setText("Formulario Materia");
        jmItemMateriaFormulario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmItemMateriaFormularioActionPerformed(evt);
            }
        });
        jmMateria.add(jmItemMateriaFormulario);

        jMenuBar1.add(jmMateria);

        jmAdministracion.setText("Administracion");
        jmAdministracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAdministracionActionPerformed(evt);
            }
        });

        jmManejoIncripcion.setText("Manejo de Inscripciones");
        jmManejoIncripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmManejoIncripcionActionPerformed(evt);
            }
        });
        jmAdministracion.add(jmManejoIncripcion);

        jMenuItem4.setText("Manipulacion de Notas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jmAdministracion.add(jMenuItem4);

        jMenuBar1.add(jmAdministracion);

        jmConsultas.setText("Consultas");

        jmItemAlumnosPorMateria.setText("Alumnos por Materia");
        jmItemAlumnosPorMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmItemAlumnosPorMateriaActionPerformed(evt);
            }
        });
        jmConsultas.add(jmItemAlumnosPorMateria);

        jMenuBar1.add(jmConsultas);

        jmSalir.setText("Salir");
        jmSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSalirActionPerformed(evt);
            }
        });
        jMenuBar1.add(jmSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jdEscritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jdEscritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmItemMateriaFormularioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmItemMateriaFormularioActionPerformed
        jdEscritorio.removeAll();
        jdEscritorio.repaint();
        MenuMaterias mm = new MenuMaterias();
        mm.setVisible(true);
        jdEscritorio.add(mm);
        jdEscritorio.moveToFront(mm);
        
    }//GEN-LAST:event_jmItemMateriaFormularioActionPerformed

    private void jmItemAlumnoFormularioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmItemAlumnoFormularioActionPerformed
        jdEscritorio.removeAll();
        jdEscritorio.repaint();
        MenuAlumnos ma = new MenuAlumnos();
        ma.setVisible(true);
        jdEscritorio.add(ma);
        jdEscritorio.moveToFront(ma);
        
    }//GEN-LAST:event_jmItemAlumnoFormularioActionPerformed

    private void jmManejoIncripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmManejoIncripcionActionPerformed
        jdEscritorio.removeAll();
        jdEscritorio.repaint();
        ManejoDeInscripcion mi = new ManejoDeInscripcion();
        mi.setVisible(true);
        jdEscritorio.add(mi);
        jdEscritorio.moveToFront(mi);
    }//GEN-LAST:event_jmManejoIncripcionActionPerformed

    private void jmAdministracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAdministracionActionPerformed
        // TODO add your handling code here:
                                                  
        
        
    
    }//GEN-LAST:event_jmAdministracionActionPerformed

    private void jmItemAlumnosPorMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmItemAlumnosPorMateriaActionPerformed
        jdEscritorio.removeAll();
        jdEscritorio.repaint();
        AlumnoPorMateria apm = new AlumnoPorMateria();
        apm.setVisible(true);
        jdEscritorio.add(apm);
        jdEscritorio.moveToFront(apm);
    }//GEN-LAST:event_jmItemAlumnosPorMateriaActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        jdEscritorio.removeAll();
        jdEscritorio.repaint();
        ManipulacionNotas mn = new  ManipulacionNotas();
        mn.setVisible(true);
        jdEscritorio.add(mn);
        jdEscritorio.moveToFront(mn);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jmSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSalirActionPerformed

        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jmSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JDesktopPane jdEscritorio;
    private javax.swing.JMenu jmAdministracion;
    private javax.swing.JMenu jmAlumno;
    private javax.swing.JMenu jmConsultas;
    private javax.swing.JMenuItem jmItemAlumnoFormulario;
    private javax.swing.JMenuItem jmItemAlumnosPorMateria;
    private javax.swing.JMenuItem jmItemMateriaFormulario;
    private javax.swing.JMenuItem jmManejoIncripcion;
    private javax.swing.JMenu jmMateria;
    private javax.swing.JMenu jmSalir;
    // End of variables declaration//GEN-END:variables
}
