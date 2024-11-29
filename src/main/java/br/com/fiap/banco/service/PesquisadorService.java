package br.com.fiap.banco.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.banco.dao.PesquisadorDao;

import br.com.fiap.banco.exception.BadInfoException;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.factory.ConnectionFactory;
import br.com.fiap.banco.model.Pesquisador;



public class PesquisadorService {

	private PesquisadorDao pesquisadorDao;
	
	public PesquisadorService() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionFactory.getConnection();
		pesquisadorDao = new PesquisadorDao(conn);

	}
	
	
	public void cadastrar(Pesquisador pesquisador) throws ClassNotFoundException, SQLException, BadInfoException {
		pesquisadorDao.cadastrar(pesquisador);
	}
	
	
	public List<Pesquisador> listar() throws ClassNotFoundException, SQLException{
		return pesquisadorDao.listar();
	}
	
	public void remover(int id) throws ClassNotFoundException, SQLException, IdNotFoundException {
		pesquisadorDao.remover(id);
	}

	
	public void atualizar(Pesquisador pesquisador) throws ClassNotFoundException, SQLException, IdNotFoundException, BadInfoException {
		pesquisadorDao.atualizar(pesquisador);
	}
}