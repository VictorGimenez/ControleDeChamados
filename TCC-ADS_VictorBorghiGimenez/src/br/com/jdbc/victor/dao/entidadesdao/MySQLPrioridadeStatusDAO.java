/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.victor.dao.entidadesdao;

import br.com.jdbc.dao.DAOException;
import br.com.jdbc.victor.controller.PrioridadeStatusDAO;
import br.com.jdbc.victor.model.PrioridadeStatus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vickz
 */
public class MySQLPrioridadeStatusDAO implements PrioridadeStatusDAO {

    final String GETALL = "SELECT * FROM prioridadestatus";
    
    private Connection con;
    private PreparedStatement pstm = null;
    private Statement stm = null;
    private ResultSet rs;

    public MySQLPrioridadeStatusDAO(Connection con) {
        this.con = con;
    }
   
    
    @Override
    public void inserir(PrioridadeStatus o) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(PrioridadeStatus o) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(PrioridadeStatus o) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PrioridadeStatus pesquisar(Long id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PrioridadeStatus> listar() throws DAOException {
        List <PrioridadeStatus> prioridadesstatuss = new ArrayList<>();
        
        try{
           pstm = con.prepareStatement(GETALL);
           rs = pstm.executeQuery();
            
           while(rs.next()){
               prioridadesstatuss.add(converter(rs));
           }  
            
        } catch (SQLException ex) {
            throw new DAOException("Erro no SQL", ex);
        } finally {
            if(pstm!=null){
                try {
                    pstm.close();
                } catch (SQLException ex) {
                    throw new DAOException("Erro ao fechar conexão", ex);
                }
            } if(rs!=null){
                try {
                    rs.close();    
                } catch (SQLException ex) {
                    throw new DAOException("Erro ao fechar conexão", ex);
                }
            }
        }
        return prioridadesstatuss;
    }
    
    public PrioridadeStatus converter(ResultSet rs) throws SQLException {
       String status = rs.getString("stats");
        
       PrioridadeStatus pristatus = new PrioridadeStatus(status);
       return pristatus; 
    }
    
}
