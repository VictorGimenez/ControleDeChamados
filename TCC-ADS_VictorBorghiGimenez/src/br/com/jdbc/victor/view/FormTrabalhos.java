
package br.com.jdbc.victor.view;

import br.com.jdbc.dao.DAOException;
import br.com.jdbc.dao.DAOManager;
import br.com.jdbc.victor.controller.PrioridadeDAO;
import br.com.jdbc.victor.dao.entidadesdao.MySQLDaoManager;
import br.com.jdbc.victor.modelo.PrioridadeModel;
import br.com.jdbc.victor.model.Prioridade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FormTrabalhos extends javax.swing.JFrame {

    private DAOManager manager;
    private PrioridadeModel model;
    private FormGestor frmGst;
    
    
    public FormTrabalhos(DAOManager manager) throws DAOException {
        initComponents();
        this.manager = manager;
        this.model = new PrioridadeModel(manager.getPrioridadeDAO());
        this.model.atualizarModelo();
        this.table.setModel(model);
       /* this.table.getSelectionModel().addListSelectionListener(e ->{;
        
        });*/
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btVoltar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbPesquisa = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("A Realizar");
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table);

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        jLabel1.setText("Pesquisar Por Status:");

        cbPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Concluido", "Andamento", "Cancelado" }));
        cbPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPesquisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btVoltar)
                    .addComponent(btExcluir))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if(JOptionPane.showConfirmDialog(rootPane, "Deseja excluir? ", "Excluir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            try {
                Prioridade prioridade = getPrioridade();
                manager.getPrioridadeDAO().excluir(prioridade);
                model.atualizarModelo();
                model.fireTableDataChanged();
            } catch (DAOException ex) {
                Logger.getLogger(FormTrabalhos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void cbPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPesquisaActionPerformed
        //Receber o sobrenome do campo de texto
        try{
            MySQLDaoManager man = new MySQLDaoManager("root", "", "localhost", "atendimentos", 3306);

            String status = (String) cbPesquisa.getSelectedItem();
            //chamar DAO e receber todos os empregados através do sobrenome
            List<Prioridade> prioridades = null;
            //se o último nome estiver em vazio receber todos os empregados
            prioridades = man.getPrioridadeDAO().listarPrioridade(status);
              
            //Criar modelo e atualizar tabela  
            PrioridadeModel model = new PrioridadeModel(prioridades);
            
            table.setModel(model);
            
            /*
            //imprimir empregados (Substituir esse comando pelo comando acima
            for (Empregado temp : empregados){
                System.out.println(temp);
            }
            */
        }catch(DAOException ex){
            Logger.getLogger(FormTrabalhos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FormTrabalhos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbPesquisaActionPerformed

    
    private Prioridade getPrioridade() throws DAOException{
         Long id = (Long) table.getValueAt(table.getSelectedRow(), 0);
         return manager.getPrioridadeDAO().pesquisar(id);
    }
    
 
    public static void main(String args[]) throws SQLException, DAOException {
        
        DAOManager manager = new MySQLDaoManager("root", "", "localhost", "atendimentos", 3306);
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new FormTrabalhos(manager).setVisible(true);
            } catch (DAOException ex) {
                Logger.getLogger(FormTrabalhos.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btVoltar;
    private javax.swing.JComboBox<String> cbPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
