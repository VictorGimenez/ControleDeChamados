
package br.com.jdbc.victor.view;

import br.com.jdbc.dao.DAOException;
import br.com.jdbc.victor.dao.entidadesdao.MySQLDaoManager;
import br.com.jdbc.victor.dao.entidadesdao.MySQLPrioridadeDAO;
import br.com.jdbc.victor.model.Prioridade;
import br.com.jdbc.victor.model.PrioridadeStatus;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class FormPrioridade extends javax.swing.JDialog {
    private Prioridade prioridade;
    private boolean editavel;
    private MySQLPrioridadeDAO priordao;
    private FormGestor fgest;
    private MySQLDaoManager man;

    int cont = 0;
    
    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public boolean isEditavel(){
        return editavel;
    }
    
    public FormPrioridade(MySQLPrioridadeDAO thePriorDao, FormGestor theFgest){
       /*this(); 
       priordao = thePriorDao;
       fgest = theFgest;*/       
    }
    
    public FormPrioridade(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        desabilitarTextField();
        this.cbStatus.removeAllItems();
        try {
            MySQLDaoManager man = new MySQLDaoManager("root", "", "localhost", "atendimentos", 3306);
            List<PrioridadeStatus> input = new ArrayList<PrioridadeStatus>();
            input = man.getPrioridadeStatusDAO().listar();
            cbStatus.setModel(new DefaultComboBoxModel(input.toArray()));
            cont++;
        } catch (DAOException ex) {
            Logger.getLogger(FormNovaChamada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfChamado = new javax.swing.JTextField();
        tfCodPrioridade = new javax.swing.JTextField();
        tfCodFuncionario = new javax.swing.JTextField();
        btCancelar = new javax.swing.JButton();
        btPesquisar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btSubmeter = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfDescricao = new javax.swing.JTextArea();
        cbStatus = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        tfDescProblema = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Prioridades dos Atendimentos");

        jLabel2.setText("Nº OS:");

        jLabel8.setText("Funcionario Código:");

        jLabel9.setText("Status:");

        jLabel3.setText("Prioridade Código:");

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btSubmeter.setText("Submeter Campos");
        btSubmeter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSubmeterActionPerformed(evt);
            }
        });

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        jLabel1.setText("Observação Final:");

        tfDescricao.setColumns(20);
        tfDescricao.setRows(5);
        jScrollPane1.setViewportView(tfDescricao);

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Concluido ", "Andamento", "Cancelado" }));

        jLabel4.setText("Descrição do Problema:");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(btAlterar)
                        .addGap(50, 50, 50)
                        .addComponent(btSubmeter)
                        .addGap(62, 62, 62)
                        .addComponent(btCancelar)
                        .addGap(67, 67, 67)
                        .addComponent(btVoltar))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfDescProblema, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfCodFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCodPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(tfChamado, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btPesquisar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfChamado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCodPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfCodFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfDescProblema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(21, 21, 21)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                        .addGap(21, 21, 21)))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCancelar)
                    .addComponent(btAlterar)
                    .addComponent(btSubmeter)
                    .addComponent(btVoltar))
                .addGap(23, 23, 23))
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

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        try {
            MySQLDaoManager man = new MySQLDaoManager("root", "", "localhost", "atendimentos", 3306);
            if(tfChamado.getText().length() == 0 || tfCodPrioridade.getText().length() == 0){
                JOptionPane.showMessageDialog(rootPane, "Não é possível pesquisar, Favor preencher OS e Prioridade", "", JOptionPane.INFORMATION_MESSAGE);
            }
            if(tfChamado.getText().length() != 0 && tfCodPrioridade.getText().length() != 0){
                Prioridade pri = man.getPrioridadeDAO().pesquisar(Long.parseLong(tfChamado.getText()), Integer.parseInt(tfCodPrioridade.getText()));
                setPrioridade(pri);
                setEditable(true);
                carregarCampos();
            } 
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro no MySQL", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível encontrar o registro citado", "Registro Inválido", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        habilitarApenasId();
        limparCampos();
        btPesquisar.setEnabled(true);
    }//GEN-LAST:event_btAlterarActionPerformed

    
    private void btSubmeterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSubmeterActionPerformed
        try {                                           
            Prioridade prioridade = new Prioridade();
            MySQLDaoManager man = new MySQLDaoManager("root", "", "localhost", "atendimentos", 3306);
            
            try {
                prioridade.setStatus(cbStatus.getSelectedItem().toString());
                prioridade.setDescricao(this.tfDescricao.getText());
                
                if(tfChamado.getText().length() != 0 && tfCodPrioridade.getText().length() != 0){
                   prioridade.setIdChamado(Long.parseLong(tfChamado.getText()));
                   prioridade.setNumPrioridade(Integer.parseInt(tfCodPrioridade.getText()));
                   man.getPrioridadeDAO().alterar(prioridade);
                }
                if(tfChamado.getText() != null && tfCodFuncionario.getText() != null && tfCodPrioridade.getText() != null && cbStatus.getSelectedItem() != null && tfDescricao.getText() != null){
                    JOptionPane.showMessageDialog(rootPane, "Registro Alterado Com Sucesso", "Alteração Realizada", JOptionPane.INFORMATION_MESSAGE);
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Favor preencher os campos novamente", "Inserção não realizada", JOptionPane.INFORMATION_MESSAGE);
                    habilitarTextField();
                    limparCampos();
                }
            } catch (DAOException ex) {
                JOptionPane.showMessageDialog(rootPane, "Erro no MySQL", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao estabelecer conexão", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btSubmeterActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
                  
        if(tfChamado.getText().length()!=0 && tfCodPrioridade.getText().length()!=0 && tfCodFuncionario.getText().length()!=0 && tfDescricao.getText().length()!= 0){
           int opcaoSelecionada = JOptionPane.showConfirmDialog(rootPane, "Deseja salvar as alterações?", "Atenção", JOptionPane.YES_NO_OPTION);
            
            if(opcaoSelecionada == JOptionPane.YES_OPTION){
                btSubmeterActionPerformed(evt);
                dispose();
            }
        setVisible(false);
        dispose();
        }
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        setPrioridade(null);
        setEditable(false);
        carregarCampos();
        btSubmeter.setEnabled(false);
        btCancelar.setEnabled(false);
    }//GEN-LAST:event_btCancelarActionPerformed

    
    private void carregarCampos(){
        if(prioridade != null){
           tfChamado.setText(String.valueOf(prioridade.getIdChamado()));
           tfCodPrioridade.setText(String.valueOf(prioridade.getNumPrioridade()));
           tfCodFuncionario.setText(String.valueOf(prioridade.getCodFuncionario()));
           tfDescProblema.setText(String.valueOf(prioridade.getDescProblema()));
           cbStatus.setSelectedItem(String.valueOf(prioridade.getStatus()));
           tfDescricao.setText(String.valueOf(prioridade.getDescricao()));
           tfChamado.setEnabled(true);
           tfCodFuncionario.setEnabled(true);
           tfCodPrioridade.setEnabled(true);
           cbStatus.setEnabled(true);
           tfDescricao.setEnabled(true);
        } else {
           tfChamado.setText("");
           tfCodPrioridade.setText("");
           tfCodFuncionario.setText("");
           tfDescProblema.setText("");
           tfDescricao.setText("");
        }
        tfChamado.requestFocus();
    }

    
    public void limparCampos(){
        tfChamado.setText("");
        tfCodPrioridade.setText("");
        tfCodFuncionario.setText("");
        tfDescProblema.setText("");
        tfDescricao.setText("");
        tfChamado.requestFocus();
        btSubmeter.setEnabled(true);
    }
    
    public void desabilitarTextField(){
        btPesquisar.setEnabled(false);
        tfChamado.setEnabled(false);
        tfCodPrioridade.setEnabled(false);
        tfCodFuncionario.setEnabled(false);
        tfDescProblema.setEnabled(false);
        cbStatus.setEnabled(false);
        btSubmeter.setEnabled(false);
        tfChamado.requestFocus();
    }
    
    public void habilitarTextField(){
        tfChamado.setEnabled(true);
        tfCodPrioridade.setEnabled(true);
        tfCodFuncionario.setEnabled(true);
        tfDescProblema.setEnabled(true);
        cbStatus.setEnabled(true);
        tfChamado.requestFocus();
    }
    
    public void habilitarApenasId(){
        tfChamado.setEnabled(true);
        tfCodPrioridade.setEnabled(true);
        tfCodFuncionario.setEnabled(false);
        tfDescProblema.setEnabled(false);
        cbStatus.setEnabled(false);
        tfChamado.requestFocus();
    } 
    
    public void setEditable(boolean editavel){
        this.editavel = editavel;   
        cbStatus.setEditable(editavel);
        tfDescricao.setEditable(editavel);
    }
        
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> {
            try {
                FormPrioridade dialog = new FormPrioridade(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(FormPrioridade.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSubmeter;
    private javax.swing.JButton btVoltar;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField tfChamado;
    private javax.swing.JTextField tfCodFuncionario;
    private javax.swing.JTextField tfCodPrioridade;
    private javax.swing.JTextField tfDescProblema;
    private javax.swing.JTextArea tfDescricao;
    // End of variables declaration//GEN-END:variables

}
