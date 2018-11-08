/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.dao;

import br.com.jdbc.victor.controller.ChamadoDAO;
import br.com.jdbc.victor.controller.PrioridadeDAO;
import br.com.jdbc.victor.controller.PrioridadeDetalheDAO;
import br.com.jdbc.victor.controller.PrioridadeStatusDAO;

/**
 *
 * @author Victor
 */

//Interface que possibilita o recebimento de objetos das classes ChamadoDAO e PrioridadeDAO
public interface DAOManager {
    
    ChamadoDAO getChamadoDAO();
    
    PrioridadeDAO getPrioridadeDAO();
    
    PrioridadeDetalheDAO getPrioridadeDetalheDAO();
    
    PrioridadeStatusDAO getPrioridadeStatusDAO();
    
}
