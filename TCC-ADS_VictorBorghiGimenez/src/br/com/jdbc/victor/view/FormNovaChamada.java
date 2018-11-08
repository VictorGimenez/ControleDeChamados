
package br.com.jdbc.victor.view;

import br.com.jdbc.dao.DAOException;
import br.com.jdbc.victor.dao.entidadesdao.MySQLChamadoDAO;
import br.com.jdbc.victor.dao.entidadesdao.MySQLDaoManager;
import br.com.jdbc.victor.dao.entidadesdao.MySQLPrioridadeDetalheDAO;
import br.com.jdbc.victor.modelo.PrioridadeDetalheModel;
import br.com.jdbc.victor.model.Chamado;
import br.com.jdbc.victor.model.Prioridade;
import br.com.jdbc.victor.model.PrioridadeDetalhe;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class FormNovaChamada extends javax.swing.JDialog {
    private Chamado chamado;
    private boolean editavel;
    private MySQLDaoManager man;

    int cont = 0;
    int i = 0;
    
    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }

    public boolean isEditavel() {
        return editavel;
    } 
        
    
    public FormNovaChamada(java.awt.Frame parent, boolean modal) throws SQLException {
        
        super(parent, modal);
        initComponents();
        desabilitarTextField();
        this.cbPrioridadeDetalhe.removeAllItems();
        try {
            MySQLDaoManager man = new MySQLDaoManager("root", "", "localhost", "atendimentos", 3306);
            List<PrioridadeDetalhe> input = new ArrayList<PrioridadeDetalhe>();
            input = man.getPrioridadeDetalheDAO().listar();
            cbPrioridadeDetalhe.setModel(new DefaultComboBoxModel(input.toArray()));
            cont++;
        } catch (DAOException ex) {
            Logger.getLogger(FormNovaChamada.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        dataInicial = new javax.swing.JLabel();
        horarioIni = new javax.swing.JLabel();
        horarioFim = new javax.swing.JLabel();
        cbPrioridadeDetalhe = new javax.swing.JComboBox<>();
        prioridade = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        tfIdChamado = new javax.swing.JTextField();
        btPesquisar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        tfDataInicial = new javax.swing.JFormattedTextField();
        tfHoraInicial = new javax.swing.JFormattedTextField();
        tfHoraFinal = new javax.swing.JFormattedTextField();
        btExcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfIdPrioridadeDetalhe = new javax.swing.JTextField();
        btListarPrioridade = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfCodFunc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfDescProblema = new javax.swing.JTextField();
        btSubmeter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Novos Chamados");

        dataInicial.setText("Data Inicial:");

        horarioIni.setText("Horário Inicial:");

        horarioFim.setText("Horário Final:");

        cbPrioridadeDetalhe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Prioridade Alta (1 Dia)", "Prioridade Média (3 Dias)", "Prioridade Baixa (7 Dias)" }));
        cbPrioridadeDetalhe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPrioridadeDetalheActionPerformed(evt);
            }
        });

        prioridade.setText("Grau Prioridade:");

        id.setText("Nº OS:");

        tfIdChamado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdChamadoActionPerformed(evt);
            }
        });

        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar/Excluir");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        tfDataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        tfDataInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDataInicialActionPerformed(evt);
            }
        });

        tfHoraInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance())));

        tfHoraFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance())));

        btExcluir.setText("Excluir Registro");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        jLabel1.setText("Id Prioridade:");

        tfIdPrioridadeDetalhe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdPrioridadeDetalheActionPerformed(evt);
            }
        });

        btListarPrioridade.setText("Listar Por Prioridade");
        btListarPrioridade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListarPrioridadeActionPerformed(evt);
            }
        });

        jLabel2.setText("Cod Funcionário:");

        jLabel3.setText("Problema Ocorrido:");

        btSubmeter.setText("Submeter Campos");
        btSubmeter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSubmeterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(btNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(btVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btListarPrioridade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addComponent(btSubmeter)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(horarioFim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfHoraFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(horarioIni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfHoraInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(dataInicial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfCodFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfDescProblema, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(id)
                            .addComponent(prioridade))
                        .addGap(10, 10, 10)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPrioridadeDetalhe, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfIdChamado, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfIdPrioridadeDetalhe, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(btPesquisar)
                .addGap(145, 145, 145))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfIdChamado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id)
                    .addComponent(btPesquisar))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prioridade)
                    .addComponent(cbPrioridadeDetalhe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfIdPrioridadeDetalhe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfCodFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDescProblema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(21, 21, 21)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataInicial))
                .addGap(21, 21, 21)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfHoraInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(horarioIni))
                .addGap(23, 23, 23)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfHoraFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(horarioFim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNovo)
                    .addComponent(btAlterar)
                    .addComponent(btCancelar)
                    .addComponent(btSubmeter))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluir)
                    .addComponent(btVoltar)
                    .addComponent(btListarPrioridade))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbPrioridadeDetalheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPrioridadeDetalheActionPerformed
       try {
            
            Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/atendimentos","root","");
            Statement stm1 = con1.createStatement();
            ResultSet rs1 = stm1.executeQuery("SELECT * FROM prioridadedetalhe WHERE prioridade = '" + this.cbPrioridadeDetalhe.getSelectedItem() + "'");
            while(rs1.next()){
                tfIdPrioridadeDetalhe.setText(String.valueOf(rs1.getInt("idPrioridadeDetalhe")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_cbPrioridadeDetalheActionPerformed

    
    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
       try {
            MySQLDaoManager man = new MySQLDaoManager("root", "", "localhost", "atendimentos", 3306);
            habilitarTextField();
            limparCampos();
            setEditable(true); 
            Long output = man.getChamadoDAO().gerarProximaId();
            tfIdChamado.setText(output.toString());
            this.cbPrioridadeDetalhe.setName("alta");
            tfIdPrioridadeDetalhe.setText("1");
       } catch (DAOException ex) {
            Logger.getLogger(FormNovaChamada.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
            Logger.getLogger(FormNovaChamada.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_btNovoActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        habilitarApenasId();
        limparCampos();
        btPesquisar.setEnabled(true);
    }//GEN-LAST:event_btAlterarActionPerformed

    private void tfDataInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDataInicialActionPerformed
        
    }//GEN-LAST:event_tfDataInicialActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        try {
            MySQLDaoManager man = new MySQLDaoManager("root", "", "localhost", "atendimentos", 3306);
            if(tfIdChamado.getText().length() == 0){
                JOptionPane.showMessageDialog(rootPane, "Favor Preencher", "Campo em Branco", JOptionPane.ERROR_MESSAGE);
            } else {
                Chamado cham = man.getChamadoDAO().pesquisar(Long.parseLong(tfIdChamado.getText()));
                setChamado(cham);
                habilitarTextField();
                setEditable(true);
                carregarCampos();
                habilitarBotoes();
            }
        }  catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro no MySQL", "Erro", JOptionPane.ERROR_MESSAGE);
        }  catch (DAOException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não foi possível encontrar o registro citado", "Registro Inválido", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btSubmeterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSubmeterActionPerformed
        try {                                           
            Chamado chamado = new Chamado();
            Prioridade prioridade = new Prioridade();
            MySQLDaoManager man = new MySQLDaoManager("root", "", "localhost", "atendimentos", 3306);  
            
            try { 
                
                if (tfCodFunc.getText().length() != 0 && tfDescProblema.getText().length() != 0 && tfDataInicial.getText().length() != 0 && tfHoraInicial.getText().length() != 0 && tfHoraFinal.getText().length() != 0) {
                    inserirDados(chamado); 
                    Long output = man.getChamadoDAO().gerarProximaId();
                    if(chamado.getIdChamado() == output){
                        man.getChamadoDAO().inserir(chamado);
                        man.getPrioridadeDAO().inserir(prioridade); 
                        JOptionPane.showMessageDialog(rootPane, "Chamado Inserido Com Sucesso", "", JOptionPane.INFORMATION_MESSAGE);
                        btNovoActionPerformed(evt);                        
                    } if(chamado.getIdChamado() < output) {       
                        man.getChamadoDAO().alterar(chamado);                  
                        man.getPrioridadeDAO().alterar(prioridade); 
                        JOptionPane.showMessageDialog(rootPane, "Chamado Alterado Com Sucesso", "", JOptionPane.INFORMATION_MESSAGE);
                        btNovoActionPerformed(evt);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Favor Preencher os Campos", "Inserção não realizada", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (DAOException ex) {
                JOptionPane.showMessageDialog(rootPane, "Erro no MySQL", "Inserção não realizada", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao estabelecer conexão", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btSubmeterActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        setChamado(null);
        cbPrioridadeDetalhe.setEnabled(false);
        setEditable(false);
        limparCampos();
        btSubmeter.setEnabled(false);
    }//GEN-LAST:event_btCancelarActionPerformed

    public void inserirDados(Chamado chamado){
        chamado.setIdChamado(Long.parseLong(tfIdChamado.getText()));
        chamado.setPrioridade(cbPrioridadeDetalhe.getSelectedItem().toString());
        chamado.setCodPrioridade(Integer.parseInt(tfIdPrioridadeDetalhe.getText()));
        chamado.setCodFuncionario(Integer.parseInt(tfCodFunc.getText()));
        chamado.setDescProblema(tfDescProblema.getText());
        chamado.setDataInicial(new java.sql.Date(((java.util.Date)tfDataInicial.getValue()).getTime()));
        chamado.setHorarioInicial(Time.valueOf(tfHoraInicial.getText()));
        chamado.setHorarioFinal(Time.valueOf(tfHoraFinal.getText()));   
    }
    
    
    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
                  
        if(tfCodFunc.getText() != null && tfDescProblema.getText() != null && tfDataInicial.getValue() != null && tfHoraInicial.getValue() != null && tfHoraFinal.getValue() != null){
           int opcaoSelecionada = JOptionPane.showConfirmDialog(rootPane, "Deseja salvar as alterações?", "Atenção", JOptionPane.YES_NO_OPTION);
            
            if(opcaoSelecionada == JOptionPane.YES_OPTION){
                btSubmeterActionPerformed(evt);
                dispose();
                FormInicio frmIni = new FormInicio();
                frmIni.setVisible(true);
            }
        setVisible(false);
        dispose();
        FormInicio frmIni = new FormInicio();
        frmIni.setVisible(true);
        }
        setVisible(false);
        dispose();
        FormInicio frmIni = new FormInicio();
        frmIni.setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        try {
            Chamado chamado = new Chamado();
            MySQLDaoManager man = new MySQLDaoManager("root", "", "localhost", "atendimentos", 3306);
            if(JOptionPane.showConfirmDialog(rootPane, "Deseja excluir? ", "Excluir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                try {
                    if(tfIdChamado.getText().equals("")){
                      carregarCampos();
                      JOptionPane.showMessageDialog(rootPane, "Campo vazio, é necessário fazer a pesquisa", "Excluir", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                      chamado.setIdChamado(Long.parseLong(tfIdChamado.getText()));
                      man.getChamadoDAO().excluir(chamado);    
                      JOptionPane.showMessageDialog(rootPane, "Usuário Excluido", "Excluir", JOptionPane.INFORMATION_MESSAGE);
                      limparCampos();
                    }
                } catch (DAOException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Registro inexistente", "Excluir", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro no SQL", "Excluir", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btListarPrioridadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListarPrioridadeActionPerformed
        try {                                              
            man = new MySQLDaoManager("root", "", "localhost", "atendimentos", 3306);
            try {
                setVisible(false);
                dispose();
                FormTrabProntos frmTrbPrnt = new FormTrabProntos(man);
                frmTrbPrnt.setVisible(true);
                frmTrbPrnt.toFront();
                frmTrbPrnt.requestFocus();
             
            } catch (DAOException ex) {
                Logger.getLogger(FormGestor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(FormGestor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btListarPrioridadeActionPerformed

    private void tfIdPrioridadeDetalheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdPrioridadeDetalheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdPrioridadeDetalheActionPerformed

    private void tfIdChamadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdChamadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdChamadoActionPerformed

    private void carregarCampos(){
        if(chamado != null){
           cbPrioridadeDetalhe.setSelectedItem(chamado.getPrioridade());
           tfIdPrioridadeDetalhe.setText(String.valueOf(chamado.getCodPrioridade()));
           tfCodFunc.setText(String.valueOf(chamado.getCodFuncionario()));
           tfDescProblema.setText(String.valueOf(chamado.getDescProblema()));
           tfDataInicial.setValue(chamado.getDataInicial());
           tfHoraInicial.setValue(chamado.getHorarioInicial());
           tfHoraFinal.setValue(chamado.getHorarioFinal());
           cbPrioridadeDetalhe.setEnabled(true);
           tfIdPrioridadeDetalhe.setEnabled(true);
           tfCodFunc.setEnabled(true);
           tfDataInicial.setEnabled(true);
           tfHoraInicial.setEnabled(true);
           tfHoraFinal.setEnabled(true);
        } else {
           tfCodFunc.setText("");
           tfIdPrioridadeDetalhe.setText("");
           tfDataInicial.setValue(null);
           tfHoraInicial.setValue(null);
           tfHoraFinal.setValue(null);
        }
       tfCodFunc.requestFocus();
    }   
    
    public void limparCampos(){
        tfIdChamado.setText("");
        tfIdPrioridadeDetalhe.setText("");
        tfCodFunc.setText("");
        tfDescProblema.setText("");
        tfDataInicial.setText("");
        tfHoraInicial.setText("");
        tfHoraFinal.setText("");
        tfCodFunc.requestFocus();
        btSubmeter.setEnabled(true);
    }
    
    public void desabilitarTextField(){
        tfIdChamado.setEnabled(false);
        cbPrioridadeDetalhe.setEnabled(false);
        tfCodFunc.setEnabled(false);
        tfDescProblema.setEnabled(false);
        tfIdPrioridadeDetalhe.setEnabled(false);
        tfDataInicial.setEnabled(false);
        tfHoraInicial.setEnabled(false);
        tfHoraFinal.setEnabled(false);
        btSubmeter.setEnabled(false);
        btPesquisar.setEnabled(false);
    }
    
    public void habilitarTextField(){
        tfIdChamado.setEnabled(false);
        cbPrioridadeDetalhe.setEnabled(true);
        tfIdPrioridadeDetalhe.setEnabled(true);
        tfIdPrioridadeDetalhe.setEditable(false);
        tfCodFunc.setEnabled(true);
        tfDescProblema.setEnabled(true);
        tfDataInicial.setEnabled(true);
        tfHoraInicial.setEnabled(true);
        tfHoraFinal.setEnabled(true);
        btExcluir.setEnabled(false);
        tfCodFunc.requestFocus();
    }
    
    public void habilitarApenasId(){
        tfIdChamado.setEnabled(true);
        cbPrioridadeDetalhe.setEnabled(false);
        tfIdPrioridadeDetalhe.setEnabled(false);
        tfCodFunc.setEnabled(false);
        tfDescProblema.setEnabled(false);
        tfDataInicial.setEnabled(false);
        tfHoraInicial.setEnabled(false);
        tfHoraFinal.setEnabled(false);
        tfIdChamado.requestFocus();
    } 
    
    public void setEditable(boolean editavel){
        this.editavel = editavel;   
        cbPrioridadeDetalhe.setEditable(false);
        tfIdPrioridadeDetalhe.setEditable(false);
        tfCodFunc.setEditable(editavel);
        tfDescProblema.setEditable(editavel);
        tfDataInicial.setEditable(editavel);
        tfHoraInicial.setEditable(editavel);
        tfHoraFinal.setEditable(editavel);
    }

    public void habilitarBotoes(){
        tfIdChamado.setEnabled(true);
        cbPrioridadeDetalhe.setEnabled(true);
        tfIdPrioridadeDetalhe.setEnabled(true);
        tfCodFunc.setEnabled(true);
        tfDescProblema.setEnabled(true);
        tfDataInicial.setEnabled(true);
        tfHoraInicial.setEnabled(true);
        tfHoraFinal.setEnabled(true);
        btExcluir.setEnabled(true);
        btSubmeter.setEnabled(true);
        tfIdChamado.requestFocus();
    } 
    
    
    
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> {
            try {
                FormNovaChamada dialog = new FormNovaChamada(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(FormNovaChamada.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btListarPrioridade;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSubmeter;
    private javax.swing.JButton btVoltar;
    private javax.swing.JComboBox<String> cbPrioridadeDetalhe;
    private javax.swing.JLabel dataInicial;
    private javax.swing.JLabel horarioFim;
    private javax.swing.JLabel horarioIni;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel prioridade;
    private javax.swing.JTextField tfCodFunc;
    private javax.swing.JFormattedTextField tfDataInicial;
    private javax.swing.JTextField tfDescProblema;
    private javax.swing.JFormattedTextField tfHoraFinal;
    private javax.swing.JFormattedTextField tfHoraInicial;
    private javax.swing.JTextField tfIdChamado;
    private javax.swing.JTextField tfIdPrioridadeDetalhe;
    // End of variables declaration//GEN-END:variables

        
}
