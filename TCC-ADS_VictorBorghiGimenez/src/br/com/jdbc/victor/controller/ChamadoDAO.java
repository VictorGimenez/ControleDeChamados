/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.victor.controller;

import br.com.jdbc.dao.DAO;
import br.com.jdbc.dao.DAOException;
import br.com.jdbc.victor.model.Chamado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Victor
 */
public interface ChamadoDAO extends DAO <Chamado, Long> {
    
    public List<Chamado> listarPorPrioridade() throws DAOException;
    public Long gerarProximaId() throws DAOException;
    
}
