/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.victor.modelo;

import br.com.jdbc.dao.DAOException;
import br.com.jdbc.victor.controller.ChamadoDAO;
import br.com.jdbc.victor.model.Chamado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Victor
 */
public class ChamadoModel extends AbstractTableModel {

    private ChamadoDAO chamados;
    private List<Chamado> listchamados = new ArrayList<>();

    public ChamadoModel(ChamadoDAO chamados) throws DAOException {
        this.chamados = chamados;
    }
    
    public void atualizarModelo() throws DAOException{
        listchamados = chamados.listarPorPrioridade();
    } 

    
    @Override
    public String getColumnName(int coluna) {
        switch(coluna){
            case 0: return "OS Nº";
            case 1: return "Cod Prioridade";
            case 2: return "Data Inicial";
            case 3: return "Horario Inicial";
            default: return "[no]";
        }         
    }
    
    @Override
    public int getRowCount() {
        return listchamados.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    
    @Override
    public Object getValueAt(int linha, int coluna) {
        Chamado chamado = listchamados.get(linha);
           switch(coluna){
               case 0 : return chamado.getIdChamado();
               case 1 : return chamado.getCodPrioridade();
               case 2 : return chamado.getDataInicial();
               case 3 : return chamado.getHorarioInicial();
           default :
               return "";       
           }
    }
    
}