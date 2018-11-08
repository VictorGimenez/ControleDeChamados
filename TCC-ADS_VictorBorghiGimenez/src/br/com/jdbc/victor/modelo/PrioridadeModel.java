/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.victor.modelo;

import br.com.jdbc.dao.DAOException;
import br.com.jdbc.victor.controller.PrioridadeDAO;
import br.com.jdbc.victor.model.Prioridade;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Victor
 */
public class PrioridadeModel extends AbstractTableModel {

    private PrioridadeDAO prioridades;
    private List<Prioridade> listprioridades = new ArrayList<>();

    public PrioridadeModel(PrioridadeDAO prioridades) throws DAOException {
        this.prioridades = prioridades;
    }
    
    public PrioridadeModel(List<Prioridade> prioridades){
        listprioridades = prioridades;
    }
    
    public void atualizarModelo() throws DAOException{
        listprioridades = prioridades.listar();
    } 

    @Override
    public String getColumnName(int coluna) {
        switch(coluna){
            case 0: return "Nº OS";
            case 1: return "Código Prioridade";
            case 2: return "Código Funcionário";
            case 3: return "Problema"; 
            case 4: return "Status";
            case 5: return "Descrição";
            default: return "[no]";
        }          
    }
    
    @Override
    public int getRowCount() {
        return listprioridades.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Prioridade prioridade = listprioridades.get(linha);
           switch(coluna){
               case 0 : return prioridade.getIdChamado();
               case 1 : return prioridade.getNumPrioridade();
               case 2 : return prioridade.getCodFuncionario();
               case 3 : return prioridade.getDescProblema();
               case 4 : return prioridade.getStatus();
               case 5 : return prioridade.getDescricao();
           default :
               return "";       
           }
    }

    
}
