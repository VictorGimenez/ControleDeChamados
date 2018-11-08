/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.victor.controller;

import br.com.jdbc.dao.DAO;
import br.com.jdbc.dao.DAOException;
import br.com.jdbc.victor.model.Prioridade;
import java.util.List;

/**
 *
 * @author Victor
 */
public interface PrioridadeDAO extends DAO <Prioridade, Long> {
    public Prioridade pesquisar(Long idChamado, int numPrioridade) throws DAOException;
    public List<Prioridade> listarPrioridade(String status) throws DAOException;
}
