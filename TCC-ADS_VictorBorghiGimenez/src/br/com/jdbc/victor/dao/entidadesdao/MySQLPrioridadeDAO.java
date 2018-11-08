/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.victor.dao.entidadesdao;

import br.com.jdbc.dao.DAOException;
import br.com.jdbc.victor.controller.PrioridadeDAO;
import br.com.jdbc.victor.model.Chamado;
import br.com.jdbc.victor.model.Prioridade;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor
 */
public class MySQLPrioridadeDAO implements PrioridadeDAO {
    
    final String INSERT = "INSERT INTO prioridades (idChamado, numPrioridade, codFuncionario, descProblema) VALUES (?,?,?,?)";
    final String GETALL = "SELECT * FROM prioridades";
    final String GETTWO = "SELECT * FROM prioridades WHERE idChamado = ? AND numPrioridade = ?";
    final String GETSTATUS = "SELECT * FROM prioridades WHERE status LIKE ? ORDER BY idChamado ";
    
    private Connection con;
    private PreparedStatement pstm;
    private Statement stm = null;
    private ResultSet rs = null;

    
    public MySQLPrioridadeDAO(Connection con) {
        this.con = con;
    }
    
    
    @Override
    public void inserir(Prioridade o) throws DAOException {
        
        try{
           stm = con.createStatement();
           pstm = con.prepareStatement(INSERT);    
           rs = stm.executeQuery("SELECT idChamado, numPrioridade, codFuncionario, descProblema FROM chamados");
           while(rs.next()){
              Long idChamado = rs.getLong("idChamado");
              int numPrioridade = rs.getInt("numPrioridade");
              int codFuncionario = rs.getInt("codFuncionario");
              String descProblema = rs.getString("descProblema");
              pstm.setLong(1, idChamado);
              pstm.setInt(2, numPrioridade);
              pstm.setInt(3, codFuncionario);
              pstm.setString(4, descProblema);
           }
   
           if(pstm.executeUpdate() == 0 ){
              throw new DAOException("As alterações podem não ter sido salvas");
           }  
        } catch (SQLException ex) {
            //throw new DAOException("Erro no SQL", ex);
            ex.printStackTrace();
        } finally {
           if(pstm != null){
               try {
                   pstm.close();
               } catch (SQLException ex) {
                   throw new DAOException("Erro ao fechar conexão", ex);
               }
           }
        }
    }

    @Override
    public void alterar(Prioridade o) throws DAOException {
        String update = null;
        try{
           update = "UPDATE prioridades SET status = '" + o.getStatus() + "', descricao = '" + o.getDescricao() + "' WHERE idChamado = " + o.getIdChamado() + " and numPrioridade = " + o.getNumPrioridade() + "";
           pstm = con.prepareStatement(update);
           pstm.executeUpdate();
           /*if(pstm.executeUpdate() != 0){
              throw new DAOException("As alterações podem não ter sido salvas");
           } */ 
        } catch (SQLException ex){
            //throw new DAOException("Erro no SQL", ex);
            ex.printStackTrace();
        } finally {
            if (pstm!=null){
                try {
                    pstm.close();
                } catch (SQLException ex) {
                    throw new DAOException("Erro ao fechar conexão", ex);
                }
            }   
        }
    }

    @Override
    public void excluir(Prioridade o) throws DAOException {
        String delete = null;
        try{
           delete = "DELETE FROM prioridades WHERE idChamado = " + o.getIdChamado() + " and numPrioridade = " + o.getNumPrioridade() + ""; 
           pstm = con.prepareStatement(delete);
           
           if(pstm.executeUpdate() == 0){
              throw new DAOException("As alterações podem não ter sido salvas");
           }
        } catch (SQLException ex){
            throw new DAOException("Erro no SQL", ex);
        } finally {
            if(pstm!=null){
                try {
                    pstm.close();
                } catch (SQLException ex) {
                    throw new DAOException("Erro ao fechar conexão", ex);
                }
            }
        }
    }

    @Override
    public Prioridade pesquisar(Long id) throws DAOException {
        Prioridade p = null;
        String getone = null;
        try{
          getone = "SELECT * FROM prioridades WHERE idPrioridade = ?";
          pstm = con.prepareStatement(getone);
          pstm.setLong(1, id);
          rs = pstm.executeQuery();
            
          if(rs.next()){
              p = converter(rs);
          } else {
              throw new DAOException("Não foi possível encontrar o registro citado");
          }  
        } catch (SQLException ex){
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
       return p;
    }
    
    @Override
    public List<Prioridade> listar() throws DAOException {
        List <Prioridade> prioridades = new ArrayList<>();
        try{
            pstm = con.prepareStatement(GETALL);
            rs = pstm.executeQuery();
            
            while(rs.next()){
               prioridades.add(converter(rs));
            } 
        } catch (SQLException ex){
            throw new DAOException("Erro no SQL", ex);
        } finally {
            if (pstm!=null){
                try {
                    pstm.close();
                } catch (SQLException ex) {
                    throw new DAOException("Erro ao fechar conexão", ex);
                }
            } 
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException("Erro ao fechar conexão", ex);
                }
            }
        }
       return prioridades; 
    }
    
    
    public Prioridade converter(ResultSet rs) throws SQLException {
        Long idChamado = rs.getLong("idChamado");
        int numPrioridade = rs.getInt("numPrioridade");
        int codFuncionario = rs.getInt("codFuncionario");
        String descProblema = rs.getString("descProblema");
        String status = rs.getString("status");
        String descricao = rs.getString("descricao");
              
        Prioridade prioridade = new Prioridade(idChamado, numPrioridade, codFuncionario, descProblema, status, descricao);
        prioridade.setIdChamado(rs.getLong("idChamado"));
        prioridade.setNumPrioridade(rs.getInt("numPrioridade"));
        
        return prioridade;
    }

    
    /*public static void main (String [] args) throws SQLException, DAOException{
        Connection con = null; 
        
        try{
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atendimentos","root","");
           PrioridadeDAO pdao = new MySQLPrioridadeDAO(con);
           Prioridade prioridade = new Prioridade();
           pdao.pesquisar(3L);
           System.out.println(prioridade);
        } finally {
           if(con!=null){
              con.close();
           }   
        }
     
    }*/

    @Override
    public Prioridade pesquisar(Long idChamado, int numPrioridade) throws DAOException {
        Prioridade p = new Prioridade();
        
        try{
          pstm = con.prepareStatement(GETTWO);
          pstm.setLong(1, idChamado);
          pstm.setInt(2, numPrioridade);
          rs = pstm.executeQuery();
            
          if(rs.next()){
              p = converter(rs);
          } else {
              throw new DAOException("Não foi possível encontrar o registro citado");
          }   
        
        } catch(SQLException ex){
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
        return p;
    }

    
    public List<Prioridade> listarPrioridade(String status) throws DAOException {
        List <Prioridade> prioridades = new ArrayList<>();
        try{
            pstm = con.prepareStatement(GETSTATUS);
            pstm.setString(1, status);
            // erro nessa linha logo abaixo
            rs = pstm.executeQuery();
            
            while(rs.next()){
               prioridades.add(converter(rs));
            } 
        } catch (SQLException ex){
            //throw new DAOException("Erro no SQL", ex);
            ex.printStackTrace();
        } finally {
            if (pstm!=null){
                try {
                    pstm.close();
                } catch (SQLException ex) {
                    throw new DAOException("Erro ao fechar conexão", ex);
                }
            } 
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException("Erro ao fechar conexão", ex);
                }
            }
        }
       return prioridades; 
    
    } 
    
    
}
