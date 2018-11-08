/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.victor.dao.entidadesdao;

import br.com.jdbc.dao.DAOException;
import br.com.jdbc.victor.controller.PrioridadeDetalheDAO;
import br.com.jdbc.victor.model.PrioridadeDetalhe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vickz
 */
public class MySQLPrioridadeDetalheDAO implements PrioridadeDetalheDAO {
    
    final String GETALL = "SELECT * FROM prioridadedetalhe";
    final String GETPRI = GETALL + " where prioridade = ? ";
    
    private Connection con;
    private PreparedStatement pstm = null;
    private Statement stm = null;
    private ResultSet rs;

    
    public MySQLPrioridadeDetalheDAO(Connection con) {
        this.con = con;
    }

    
    @Override
    public void inserir(PrioridadeDetalhe o) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(PrioridadeDetalhe o) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(PrioridadeDetalhe o) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PrioridadeDetalhe pesquisar(Long id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PrioridadeDetalhe> listar() throws DAOException {
        List <PrioridadeDetalhe> prioridadedetalhes = new ArrayList<>();
        
        try{
           pstm = con.prepareStatement(GETALL);
           rs = pstm.executeQuery();
            
           while(rs.next()){
               prioridadedetalhes.add(popularCombo(rs));
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
        return prioridadedetalhes;
    }   
    
    
    public PrioridadeDetalhe popularCombo(ResultSet rs) throws SQLException {
        String prioridade = rs.getString("prioridade");
        
        PrioridadeDetalhe prioridadedetalhe = new PrioridadeDetalhe(prioridade);
        prioridadedetalhe.setIdPrioridadeDetalhe(rs.getLong("idPrioridadeDetalhe"));    
        
        return prioridadedetalhe;
    }

    /*
    @Override
    public Long getCodPrioridade() throws DAOException{
        PrioridadeDetalhe pridetalhe = new PrioridadeDetalhe();
        long valor = 0;
        
        try {
            setPrioridadeToCombo(pridetalhe);
            while(rs.next()){
                pridetalhe.setIdPrioridadeDetalhe(rs.getLong("idPrioridadeDetalhe"));
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
        return valor;
    }
    
    
    @Override
    public PrioridadeDetalhe setPrioridadeToCombo (PrioridadeDetalhe pridetalhe) throws DAOException{ 
        PrioridadeDetalhe pd = null;
        
        try {
            pstm = con.prepareStatement(GETPRI);
            pstm.setString(1, pridetalhe.getPrioridade());
            rs = pstm.executeQuery();
            //while(rs.next()){
            //    pridetalhe.setIdPrioridadeDetalhe(rs.getLong("idPrioridadeDetalhe"));
            //}
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
      return pd;  
    }         */
        
    
}