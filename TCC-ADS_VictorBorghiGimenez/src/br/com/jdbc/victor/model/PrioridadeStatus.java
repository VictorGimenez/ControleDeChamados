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
public class PrioridadeStatus {
    private long idPrioridadeStatus;
    private String status;

    public PrioridadeStatus() {
    }

    public PrioridadeStatus(String status) {
        this.status = status;
    }

    /**
     * @return the idPrioridadeStatus
     */
    public long getIdPrioridadeStatus() {
        return idPrioridadeStatus;
    }

    /**
     * @param idPrioridadeStatus the idPrioridadeStatus to set
     */
    public void setIdPrioridadeStatus(long idPrioridadeStatus) {
        this.idPrioridadeStatus = idPrioridadeStatus;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "" + status + "";
    }
    
    
}
