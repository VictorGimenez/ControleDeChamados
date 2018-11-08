
package br.com.jdbc.victor.view;

import br.com.jdbc.dao.DAOException;
import br.com.jdbc.dao.DAOManager;
import br.com.jdbc.victor.dao.entidadesdao.MySQLDaoManager;
import br.com.jdbc.victor.modelo.PrioridadeModel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FormGestor extends javax.swing.JFrame {

    private MySQLDaoManager manager;
    private PrioridadeModel model;
    
    
    public FormGestor() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        btOpPrioridade = new javax.swing.JButton();
        btOpTrabalhos = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Área do Gestor do Serviço");

        btOpPrioridade.setText("Prioridades de Chamados");
        btOpPrioridade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOpPrioridadeActionPerformed(evt);
            }
        });

        btOpTrabalhos.setText("Trabalhos a Realizar");
        btOpTrabalhos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOpTrabalhosActionPerformed(evt);
            }
        });

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btOpPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btOpTrabalhos, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(169, 169, 169))))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(btOpPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btOpTrabalhos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btVoltar)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btOpPrioridadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOpPrioridadeActionPerformed
        try {
            FormPrioridade frmpri = new FormPrioridade(this, rootPaneCheckingEnabled);
            frmpri.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(FormGestor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btOpPrioridadeActionPerformed

    private void btOpTrabalhosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOpTrabalhosActionPerformed
        try {                                              
            manager = new MySQLDaoManager("root", "", "localhost", "atendimentos", 3306);
            try {
                FormTrabalhos frmTrabalhos = new FormTrabalhos(manager);
                frmTrabalhos.setVisible(true);
            } catch (DAOException ex) {
                Logger.getLogger(FormGestor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FormGestor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btOpTrabalhosActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        setVisible(false);
        dispose();
        FormInicio frmIni = new FormInicio();
        frmIni.setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormGestor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btOpPrioridade;
    private javax.swing.JButton btOpTrabalhos;
    private javax.swing.JButton btVoltar;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
