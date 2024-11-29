package br.com.fiap.banco.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import br.com.fiap.banco.dao.QuestionarioRespPesqDao;
import br.com.fiap.banco.exception.BadInfoException;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.factory.ConnectionFactory;
import br.com.fiap.banco.model.QuestionarioRespPesq;

public class QuestionarioServiceRespPesq {

	private QuestionarioRespPesqDao questionarioRespPesqDao;
	
	public QuestionarioServiceRespPesq() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionFactory.getConnection();
		questionarioRespPesqDao = new QuestionarioRespPesqDao(conn);

	}
	
	public void cadastrar(QuestionarioRespPesq questionarioRespPesq) throws ClassNotFoundException, SQLException, BadInfoException {
		questionarioRespPesqDao.cadastrar(questionarioRespPesq);
	}
	
	
	public List<QuestionarioRespPesq> listar() throws ClassNotFoundException, SQLException{
		return questionarioRespPesqDao.listar();
	}
	
	public void remover(int id) throws ClassNotFoundException, SQLException, IdNotFoundException {
		questionarioRespPesqDao.remover(id);
	}

	
	public void atualizar(QuestionarioRespPesq questionarioRespPesq) throws ClassNotFoundException, SQLException, IdNotFoundException, BadInfoException {
		questionarioRespPesqDao.atualizar(questionarioRespPesq);
	}
}