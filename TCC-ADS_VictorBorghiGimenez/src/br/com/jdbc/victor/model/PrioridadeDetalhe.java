/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.victor.model;

/**
 *
 * @author Vickz
 */
public class PrioridadeDetalhe {
    private long idPrioridadeDetalhe;
    private String prioridade;

    public PrioridadeDetalhe() {
        
    }
    
    public PrioridadeDetalhe(String prioridade) {
        this.prioridade = prioridade;
    }
    
    
    
    /**
     * @return the idPrioridadeDetalhe
     */
    public long getIdPrioridadeDetalhe() {
        return idPrioridadeDetalhe;
    }

    /**
     * @return the prioridade
     */
    public String getPrioridade() {
        return prioridade;
    }
   
    /**
     * @param idPrioridadeDetalhe the idPrioridadeDetalhe to set
     */
    public void setIdPrioridadeDetalhe(long idPrioridadeDetalhe) {
        this.idPrioridadeDetalhe = idPrioridadeDetalhe;
    }

    /**
     * @param prioridade the prioridade to set
     */
    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return "" + prioridade + "";
    }
    
       
}
