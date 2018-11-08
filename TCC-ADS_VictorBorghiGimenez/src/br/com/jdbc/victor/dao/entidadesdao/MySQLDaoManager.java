/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jdbc.victor.dao.entidadesdao;

import br.com.jdbc.dao.DAOException;
import br.com.jdbc.dao.DAOManager;
import br.com.jdbc.victor.controller.ChamadoDAO;
import br.com.jdbc.victor.controller.PrioridadeDAO;
import br.com.jdbc.victor.controller.PrioridadeDetalheDAO;
import br.com.jdbc.victor.controller.PrioridadeStatusDAO;
import br.com.jdbc.victor.model.Chamado;
import br.com.jdbc.victor.model.Prioridade;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author Victor
 */
public class MySQLDaoManager implements DAOManager {
    //criação de um objeto do tipo connection
    private Connection conn;
    
    //inicialização igual a null dos objetos PrioridadeDAO e ChamadoDAO
    private PrioridadeDAO prioridades = null;
    private ChamadoDAO chamados = null;
    private PrioridadeDetalheDAO prioridadedetalhes = null;
    private PrioridadeStatusDAO prioridadestatus = null;

    //construtor que inicializa as variáveis correspondentes do objeto Conexão
    public MySQLDaoManager(String user, String pass, String host, String database, int port) throws SQLException{
        conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, pass);
    }

    //se o atributo chamados for nulo, então é instanciado um objeto do tipo MySQLChamadoDAO e retornado o mesmo
    @Override
    public ChamadoDAO getChamadoDAO() {
        if(chamados == null){
           chamados = new MySQLChamadoDAO(conn) {};
        }
       return chamados; 
    }

    //se o atributo prioridades for nulo, então é instanciado um objeto do tipo MySQLPrioridadeDAO e retornado o mesmo
    @Override
    public PrioridadeDAO getPrioridadeDAO() {
        if(prioridades == null){
           prioridades = new MySQLPrioridadeDAO(conn) {};
        }
       return prioridades; 
    }

    public PrioridadeDetalheDAO getPrioridadeDetalheDAO() {
        if(prioridadedetalhes == null){
            prioridadedetalhes = new MySQLPrioridadeDetalheDAO(conn);
        }
        return prioridadedetalhes;        
    }
    
    public PrioridadeStatusDAO getPrioridadeStatusDAO() {
        if(prioridadestatus == null){
            prioridadestatus = new MySQLPrioridadeStatusDAO(conn);
        }
        return prioridadestatus;        
    }
    
    /*public static void main (String [] args) throws SQLException, DAOException{
        MySQLDaoManager man = new MySQLDaoManager("root", "", "localhost", "atendimentos", 3306);
        //List<Prioridade>prioridades = man.getPrioridadeDAO().listar();
        //Prioridade prioridade = new Prioridade(1111111, 11111, 1111, "concluido");
        Chamado output = man.getChamadoDAO().getCodPrioridade();
        System.out.println(output);
    }*/

    
}
