/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PRESENTACION;

import PERSISTENCIA.DB;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Leo
 */
public class IngresarPregunta extends javax.swing.JFrame {

    /**
     * Creates new form IngresarPregunta
     */
    public IngresarPregunta() {
        initComponents();
        this.setResizable(false);
        DB db = DB.getInstance();
        try{
            List<String> categorias = db.getCategorias();
            jComboBox1.setModel(new DefaultComboBoxModel(categorias.toArray()));
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(this, "Error al listar las categorias");
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingresar pregunta");

        jLabel1.setText("Ingrese la pregunta");

        jLabel2.setText("Categoría");

        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Respuesta correcta");

        jLabel4.setText("Respuesta incorrecta 1");

        jLabel5.setText("Respuesta incorrecta 2");

        jLabel6.setText("Respuesta incorrecta 3");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1)
                    .addComponent(jTextField2)
                    .addComponent(jTextField1)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3)
                    .addComponent(jTextField4)
                    .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DB db = DB.getInstance();
        if (jComboBox1.getSelectedIndex() == 0){
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccione una categoría por favor");
        }else if(jTextField2.getText().isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(this, "Debe ingresar la pregunta");
        }else if(jTextField1.getText().isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(this, "Debe ingresar la respuesta correcta");
        }else if(jTextField3.getText().isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(this, "Debe ingresar la respuesta incorrecta 1");
        }else if(jTextField4.getText().isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(this, "Debe ingresar la respuesta incorrecta 2");
        }else if(jTextField5.getText().isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(this, "Debe ingresar la respuesta incorrecta 3");
        }else{
            try{
                String NomCategoria = jComboBox1.getSelectedItem().toString();
                String PreguntaStr = jTextField2.getText();
                String RespuestaCorrecta = jTextField1.getText();
                String RespuestaInc1 = jTextField3.getText();
                String RespuestaInc2 = jTextField4.getText();
                String RespuestaInc3 = jTextField5.getText();
                
                if(db.verificarPregunta(PreguntaStr)){
                    javax.swing.JOptionPane.showMessageDialog(this, "La pregunta ingresada ya existe");
                }else if(db.verificarRespuesta(RespuestaCorrecta)){
                    javax.swing.JOptionPane.showMessageDialog(this, "La respuesta correcta ingresada ya existe");
                }else if(db.verificarRespuesta(RespuestaInc1)){
                    javax.swing.JOptionPane.showMessageDialog(this, "La respuesta incorrecta 1 ingresada ya existe");
                }else if(db.verificarRespuesta(RespuestaInc2)){
                    javax.swing.JOptionPane.showMessageDialog(this, "La respuesta incorrecta 2 ingresada ya existe");
                }else if(db.verificarRespuesta(RespuestaInc3)){
                    javax.swing.JOptionPane.showMessageDialog(this, "La respuesta incorrecta 3 ingresada ya existe");
                }else{
                    db.ingresarPregunta(PreguntaStr);
                    db.ingresarRespuesta(RespuestaCorrecta,true);
                    db.ingresarRespuesta(RespuestaInc1,false);
                    db.ingresarRespuesta(RespuestaInc2,false);
                    db.ingresarRespuesta(RespuestaInc3,false);
                    
                    db.ingresar_categoria_pregunta(PreguntaStr, NomCategoria);
                    db.ingresar_pregunta_respuesta(PreguntaStr, RespuestaCorrecta);
                    db.ingresar_pregunta_respuesta(PreguntaStr, RespuestaInc1);
                    db.ingresar_pregunta_respuesta(PreguntaStr, RespuestaInc2);
                    db.ingresar_pregunta_respuesta(PreguntaStr, RespuestaInc3);
                    
                    javax.swing.JOptionPane.showMessageDialog(this, "Pregunta ingresada correctamente");
                }
                
                
            }catch(Exception e){
                javax.swing.JOptionPane.showMessageDialog(this, "No se pudo ingresar la pregunta debido a un error inesperado");
            }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(IngresarPregunta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresarPregunta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresarPregunta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresarPregunta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IngresarPregunta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}