/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.victor.model;

import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author Victor
 */
public class Prioridade {
    
    private Long idPrioridade;
    private Long idChamado; 
    private String descProblema;
    private int numPrioridade, codFuncionario;
    private String status;
    private String descricao;
    
    
   
    
    public Prioridade(Long idChamado, int numPrioridade, int codFuncionario, String descProblema, String status, String descricao) {
        this.idChamado = idChamado;
        this.numPrioridade = numPrioridade;
        this.codFuncionario = codFuncionario;
        this.descProblema = descProblema;
        this.status = status;
        this.descricao = descricao;
    }

    public Prioridade(Long idChamado, int numPrioridade, int codFuncionario, String descProblema) {
        this.idChamado = idChamado;
        this.numPrioridade = numPrioridade;
        this.codFuncionario = codFuncionario;
        this.descProblema = descProblema;
    }
    
    
    public Prioridade(){
        this.idChamado = getIdChamado();
        this.numPrioridade = getNumPrioridade();
        this.codFuncionario = getCodFuncionario();
        this.descProblema = getDescProblema();
        this.status = getStatus();
        this.descricao = getDescricao();
    }
    
    /**
     * @return the idPrioridade
     */
    public Long getIdPrioridade() {
        return idPrioridade;
    }

    /**
     * @param idPrioridade the idPrioridade to set
     */
    public void setIdPrioridade(Long idPrioridade) {
        this.idPrioridade = idPrioridade;
    }

    /**
     * @return the idChamado
     */
    public Long getIdChamado() {
        return idChamado;
    }

    /**
     * @param idChamado the numChamado to set
     */
    public void setIdChamado(Long idChamado) {
        this.idChamado = idChamado;
    }

    /**
     * @return the codPrioridade
     */
    public int getNumPrioridade() {
        return numPrioridade;
    }

    /**
     * @param numPrioridade the codPrioridade to set
     */
    public void setNumPrioridade(int numPrioridade) {
        this.numPrioridade = numPrioridade;
    }

    /**
     * @return the codFuncionario
     */
    public int getCodFuncionario() {
        return codFuncionario;
    }

    /**
     * @param codFuncionario the codFuncionario to set
     */
    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;     
    }
    
    /**
     * @return the descProblema
     */
    public String getDescProblema() {
        return descProblema;
    }

    /**
     * @param descProblema the descProblema to set
     */
    public void setDescProblema(String descProblema) {
        this.descProblema = descProblema;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String status){
       this.status = status;
    }

    
    
    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Prioridade{" + "idPrioridade=" + idPrioridade + ", idChamado=" + idChamado + ", descProblema=" + getDescProblema() + ", numPrioridade=" + numPrioridade + ", codFuncionario=" + codFuncionario + ", status=" + status + ", descricao=" + descricao + '}';
    }

        
}
