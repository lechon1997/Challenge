/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRESENTACION;

import PERSISTENCIA.DB;

/**
 *
 * @author Leo
 */
public class IngresarCategoria extends javax.swing.JFrame {

    /**
     * Creates new form IngresarCategoria
     */
    public IngresarCategoria() {
        initComponents();
        this.setResizable(false);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ETnombreCat = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ComboNivel = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        ETpuntos = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("INGRESAR CATEGORÍA");

        jLabel1.setText("Nombre categoría");

        ETnombreCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ETnombreCatActionPerformed(evt);
            }
        });

        jLabel2.setText("Dificultad");

        ComboNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Nivel 1", "Nivel 2", "Nivel 3", "Nivel 4", "Nivel 5" }));
        ComboNivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboNivelActionPerformed(evt);
            }
        });

        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Puntos");

        ETpuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ETpuntosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(ETnombreCat, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ETpuntos)
                            .addComponent(ComboNivel, 0, 139, Short.MAX_VALUE))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ETnombreCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ETpuntos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ComboNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ETnombreCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ETnombreCatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ETnombreCatActionPerformed

    private void ComboNivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboNivelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboNivelActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DB db = DB.getInstance();
        
        if(ETnombreCat.getText().isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(this, "Debe ingresar el nombre de la categoría.");
        }else if(ETpuntos.getText().isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(this, "Debe ingresar los puntos para esta categoría.");
        }else if(ComboNivel.getSelectedIndex() == 0){
            javax.swing.JOptionPane.showMessageDialog(this, "Debe ingresar la dificultad de la categoría.");
        }else if(!ETpuntos.getText().matches("[0-9]*")){
            javax.swing.JOptionPane.showMessageDialog(this, "Puntuación inválida, solo se permiten valores numéricos positivos");
        }else{
            try{
                
                String nombreCategoria = ETnombreCat.getText().toUpperCase();
                int puntos = Integer.parseInt(ETpuntos.getText());
                int nivel = ComboNivel.getSelectedIndex();
                
                if(db.verificarCategoria(nombreCategoria)){
                    javax.swing.JOptionPane.showMessageDialog(this, "La categoría ingresada ya existe");
                }else{
                    boolean res = db.ingresarCategoria(nombreCategoria, nivel, puntos);

                    if(res == true){
                        javax.swing.JOptionPane.showMessageDialog(this, "Categoría ingresada correctamente");
                    }else{
                        javax.swing.JOptionPane.showMessageDialog(this, "No se pudo ingresar la categoría debido a un error inesperado");
                    }
                }

            }catch(Exception x){
                javax.swing.JOptionPane.showMessageDialog(this, "No se pudo ingresar la categoría debido a un error inesperado");
            }
                        
        }
        
        
        
        System.out.println(String.valueOf(ComboNivel.getSelectedIndex()));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ETpuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ETpuntosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ETpuntosActionPerformed

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
            java.util.logging.Logger.getLogger(IngresarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresarCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboNivel;
    private javax.swing.JTextField ETnombreCat;
    private javax.swing.JTextField ETpuntos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
