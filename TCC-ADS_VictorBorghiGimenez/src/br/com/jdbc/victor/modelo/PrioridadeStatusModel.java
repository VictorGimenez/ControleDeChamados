/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.victor.modelo;

import br.com.jdbc.dao.DAOException;
import br.com.jdbc.victor.controller.PrioridadeStatusDAO;
import br.com.jdbc.victor.model.PrioridadeStatus;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Vickz
 */
public class PrioridadeStatusModel extends AbstractTableModel {
    
    private PrioridadeStatusDAO prioridadesstatus;
    private List<PrioridadeStatus> listprioridadestatus = new ArrayList<>();

    public PrioridadeStatusModel(PrioridadeStatusDAO prioridadesstatus) throws DAOException {
        this.prioridadesstatus = prioridadesstatus;
    }
    
    public void atualizarModelo() throws DAOException{
        listprioridadestatus = prioridadesstatus.listar();
    } 
    
    @Override
    public int getRowCount() {
        return listprioridadestatus.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        PrioridadeStatus prioridadestatus = listprioridadestatus.get(linha);
           switch(coluna){
               case 0 : return prioridadestatus.getStatus();
           default :
               return "";       
           }
    }
}
