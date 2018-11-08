/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.victor.dao.entidadesdao;

import br.com.jdbc.dao.DAOException;
import br.com.jdbc.victor.controller.ChamadoDAO;
import br.com.jdbc.victor.model.Chamado;
import br.com.jdbc.victor.model.PrioridadeDetalhe;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor
 */
public abstract class MySQLChamadoDAO implements ChamadoDAO {
   
    final String INSERT = "INSERT INTO chamados (prioridade, numPrioridade, codFuncionario, descProblema, dataInicial, horarioInicial, horarioFinal) VALUES (?,?,?,?,?,?,?)";
    final String GETALL = "SELECT * FROM chamados";
    final String GETID  = "SELECT idChamado FROM chamados ORDER BY idChamado DESC LIMIT 1";
    final String ORDER = GETALL + " ORDER BY numPrioridade, dataInicial, horarioInicial";
   
    
    //SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
    //SimpleDateFormat formatarHora = new SimpleDateFormat("HH:mm");
    private Connection con;
    private PreparedStatement pstm;
    private Statement stm = null;
    private ResultSet rs = null;
    
    
    public MySQLChamadoDAO(Connection con) {
        this.con = con;
    }
    
    @Override
    public void inserir(Chamado o) throws DAOException {
        
        try{
           pstm = con.prepareStatement(INSERT);
           pstm.setString(1, o.getPrioridade());
           pstm.setInt(2, o.getCodPrioridade());
           pstm.setInt(3, o.getCodFuncionario());
           pstm.setString(4, o.getDescProblema());
           pstm.setDate(5, new Date(o.getDataInicial().getTime()));
           pstm.setTime(6, new Time(o.getHorarioInicial().getTime()));
           pstm.setTime(7, new Time(o.getHorarioFinal().getTime())); 
            
           if(pstm.executeUpdate() == 0 ){
              throw new DAOException("As alterações podem não ter sido salvas");
           }  
        } catch (SQLException ex) {
            //throw new DAOException("Erro no SQL");
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
    public void alterar(Chamado o) throws DAOException {
         String update = null;
         try{
             update = "UPDATE chamados SET prioridade = '" + o.getPrioridade() + 
                     "', codFuncionario = '" + o.getCodFuncionario() +
                     "', descProblema = '" + o.getDescProblema() +
                     "', dataInicial = '" + o.getDataInicial() +
                     "', horarioInicial = '" + o.getHorarioInicial() + 
                     "', horarioFinal = '" + o.getHorarioFinal() + 
                     "' WHERE idChamado = " + o.getIdChamado() + "";
             pstm = con.prepareStatement(update);
    
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
    public void excluir(Chamado o) throws DAOException {
        String delete = null;
        try{
            delete = "DELETE FROM chamados WHERE idChamado = " + o.getIdChamado() + "";
            pstm = con.prepareStatement(delete);

            if(pstm.executeUpdate()==0){
               throw new DAOException("As alterações podem não ter sido salvas"); 
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
            }
        }
    }

    @Override
    public Chamado pesquisar(Long id) throws DAOException {
        Chamado c = null;
        String getone = null;
        try{
          getone = "SELECT * FROM chamados WHERE idChamado = ?";  
          pstm = con.prepareStatement(getone);
          pstm.setLong(1, id);
          rs = pstm.executeQuery();
            
          if(rs.next()){
              //erro logo abaixo \/
              c = converter(rs);
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
        return c;
    }

    
    @Override
    public List<Chamado> listar() throws DAOException {
        List <Chamado> chamados = new ArrayList<>();
        try{
           pstm = con.prepareStatement(GETALL);
           rs = pstm.executeQuery();
            
           while(rs.next()){
               chamados.add(converter(rs));
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
        return chamados;
    }
    

    public Chamado converter(ResultSet rs) throws SQLException {
        String prioridade = rs.getString("prioridade");
        int codPrioridade = rs.getInt("numPrioridade");
        int codFuncionario = rs.getInt("codFuncionario");
        String descProblema = rs.getString("descProblema");
        Date dataInicial = rs.getDate("dataInicial");
        Time horarioInicial = rs.getTime("horarioInicial");
        Time horarioFinal = rs.getTime("horarioFinal");
              
        Chamado chamado = new Chamado(prioridade, codPrioridade, codFuncionario, descProblema, dataInicial, horarioInicial, horarioFinal);
        chamado.setIdChamado(rs.getLong("idChamado"));    
        
        return chamado;
    }
   
    
    @Override
    public Long gerarProximaId() throws DAOException{
        long next = 0;
        try {
            pstm = con.prepareStatement(GETID);
            rs = pstm.executeQuery();
            if(rs.next()){
               next = rs.getLong("idChamado")+1; 
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
       return next;  
    }
          
    
    /*
    @Override
    public Long getCodPrioridade() throws DAOException{
        Chamado chamado = null;
        String getcod = null;
        long valor = 0;
        
        try {
            getcod = "SELECT * from prioridadedetalhe where prioridade = '?' " ;
            pstm = con.prepareStatement(getcod);
            pstm.setString(1, chamado.getPrioridade());
            rs = pstm.executeQuery();
            while(rs.next()){
                chamado = new Chamado();
                chamado.setIdPrioridadeDetalhe(rs.getLong("idPrioridadeDetalhe"));
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
    }*/
    
    @Override
    public List<Chamado> listarPorPrioridade() throws DAOException {
        List <Chamado> chamados = new ArrayList<>();
        try{
           pstm = con.prepareStatement(ORDER);
           rs = pstm.executeQuery();
            
           while(rs.next()){
               chamados.add(converter2(rs));
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
        return chamados;
    }
  
    public Chamado converter2(ResultSet rs) throws SQLException {
        Long idChamado = rs.getLong("idChamado");
        int codPrioridade = rs.getInt("numPrioridade");
        String descProblema = rs.getString("descProblema");
        Date dataInicial = rs.getDate("dataInicial");
        Time horarioInicial = rs.getTime("horarioInicial");
              
        Chamado chamado = new Chamado(codPrioridade, idChamado, descProblema, dataInicial, horarioInicial);
        chamado.setIdChamado(rs.getLong("idChamado"));    
        
        return chamado;
    }
    
    
    
    /*public static void main (String [] args) throws SQLException, DAOException{
        Connection con = null;
        
        try{
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atendimentos","root",""); 
           ChamadoDAO cdao = new MySQLChamadoDAO(con) {};
           //Chamado chamado = new Chamado("alta", 1, 3324, "Alterar login e senha", new Date(2016, 11, 2), new Time(23, 37, 0), new Time(03, 50, 00));
           Chamado chamado = new Chamado();
           //cdao.gerarProximaId();
           System.out.println("ID Chamado: " + cdao.gerarProximaId() + "");
           //cdao.inserir(chamado);
        } finally {
           if(con!=null){
               con.close();
           }   
        }
    }*/
    
    
    
}
