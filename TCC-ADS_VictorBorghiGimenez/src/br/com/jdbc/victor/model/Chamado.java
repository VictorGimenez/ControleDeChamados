/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.victor.model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Victor
 */
public class Chamado {
    private Long idChamado;
    private String prioridade;
    private int codPrioridade;
    private int codFuncionario;
    private String descProblema;
    private Date dataInicial;
    private Time horarioInicial, horarioFinal;
    
    
    public Chamado(String prioridade, int codPrioridade, int codFuncionario, String descProblema, Date dataInicial, Time horarioInicial, Time horarioFinal) {
        this.prioridade = prioridade;
        this.codPrioridade = codPrioridade;
        this.codFuncionario = codFuncionario;
        this.descProblema = descProblema;
        this.dataInicial = dataInicial;
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
    }
    
    public Chamado(int codPrioridade, Long idChamado){
        this.codPrioridade = codPrioridade;
        this.idChamado = idChamado;
    }
    
    public Chamado(){
       this.prioridade = getPrioridade();
       this.codPrioridade = getCodPrioridade();
       this.codFuncionario = getCodFuncionario();
       this.descProblema = getDescProblema();
       this.dataInicial = getDataInicial();
       this.horarioInicial = getHorarioInicial();
       this.horarioFinal = getHorarioFinal();
    }

    public Chamado(int codPrioridade, Long idChamado, String descProblema, Date dataInicial, Time horarioInicial) {
        this.codPrioridade = codPrioridade;
        this.idChamado = idChamado;
        this.descProblema = descProblema;
        this.dataInicial = dataInicial;
        this.horarioInicial = horarioInicial;
    }
    
    
    /**
     * @return the idChamado
     */
    public Long getIdChamado() {
        return idChamado;
    }

    /**
     * @param idChamado the idChamado to set
     */
    public void setIdChamado(Long idChamado) {
        this.idChamado = idChamado;
    }
    /**
     * @return the prioridade
     */
    public String getPrioridade() {
        return prioridade;
    }

    /**
     * @param prioridade the prioridade to set
     */
    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }
    
    /**
     * @return the dataInicial
     */
    public Date getDataInicial() {
        return dataInicial;
    }

    /**
     * @param dataInicial the dataInicial to set
     */
    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    /**
     * @return the horarioInicial
     */
    public Time getHorarioInicial() {
        return horarioInicial;
    }

    /**
     * @param horarioInicial the horarioInicial to set
     */
    public void setHorarioInicial(Time horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    /**
     * @return the horarioFinal
     */
    public Time getHorarioFinal() {
        return horarioFinal;
    }

    /**
     * @param horarioFinal the horarioFinal to set
     */
    public void setHorarioFinal(Time horarioFinal) {
        this.horarioFinal = horarioFinal;
    }
    
    /**
     * @return the codPrioridade
     */
    public int getCodPrioridade() {
        return codPrioridade;
    }

    /**
     * @param codPrioridade the codPrioridade to set
     */
    public void setCodPrioridade(int codPrioridade) {
        this.codPrioridade = codPrioridade;
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

    @Override
    public String toString() {
        return "Chamado{" + "idChamado=" + idChamado + ", prioridade=" + prioridade + ", codPrioridade=" + codPrioridade + ", codFuncionario=" + codFuncionario + ", descProblema=" + descProblema + ", dataInicial=" + dataInicial + ", horarioInicial=" + horarioInicial + ", horarioFinal=" + horarioFinal + '}';
    }
        

}
