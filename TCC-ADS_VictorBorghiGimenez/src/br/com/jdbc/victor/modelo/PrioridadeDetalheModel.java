/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.victor.modelo;

import br.com.jdbc.dao.DAOException;
import br.com.jdbc.victor.controller.PrioridadeDetalheDAO;
import br.com.jdbc.victor.model.PrioridadeDetalhe;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vickz
 */
public class PrioridadeDetalheModel extends AbstractTableModel {
    
    private PrioridadeDetalheDAO prioridadedetalhes;
    private List<PrioridadeDetalhe> listprioridadedetalhes = new ArrayList<>();

    public PrioridadeDetalheModel(PrioridadeDetalheDAO prioridadedetalhes) throws DAOException {
        this.prioridadedetalhes = prioridadedetalhes;
    }
    
    public void atualizarModelo() throws DAOException{
        listprioridadedetalhes = prioridadedetalhes.listar();
    } 
    
    @Override
    public int getRowCount() {
        return listprioridadedetalhes.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        PrioridadeDetalhe prioridadedetalhe = listprioridadedetalhes.get(linha);
           switch(coluna){
               case 0 : return prioridadedetalhe.getPrioridade();
           default :
               return "";       
           }
    }
    
    
}
