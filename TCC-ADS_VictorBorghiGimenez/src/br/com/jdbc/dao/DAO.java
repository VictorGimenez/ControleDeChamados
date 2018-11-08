/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.dao;

import java.util.List;

/**
 *
 * @author Victor
 */
//Interface geral, onde T representa cada classe e K o tipo Long
public interface DAO <T, K> {
    
    public void inserir(T o) throws DAOException;
    
    public void alterar(T o) throws DAOException;
    
    public void excluir(T o) throws DAOException;
    
    public T pesquisar(K id) throws DAOException;
    
    public List<T> listar() throws DAOException;
    
}
