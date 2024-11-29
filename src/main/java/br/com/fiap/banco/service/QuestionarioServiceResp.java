package br.com.fiap.banco.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import br.com.fiap.banco.dao.QuestionarioRespDao;
import br.com.fiap.banco.exception.BadInfoException;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.factory.ConnectionFactory;
import br.com.fiap.banco.model.QuestionarioResp;

public class QuestionarioServiceResp {

	private QuestionarioRespDao questionarioRespDao;
	
	public QuestionarioServiceResp() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionFactory.getConnection();
		questionarioRespDao = new QuestionarioRespDao(conn);

	}
	
	public void cadastrar(QuestionarioResp questionarioResp) throws ClassNotFoundException, SQLException, BadInfoException {
		questionarioRespDao.cadastrar(questionarioResp);
	}
	
	
	public List<QuestionarioResp> listar() throws ClassNotFoundException, SQLException{
		return questionarioRespDao.listar();
	}
	
	public void remover(int id) throws ClassNotFoundException, SQLException, IdNotFoundException {
		questionarioRespDao.remover(id);
	}

	
	public void atualizar(QuestionarioResp questionarioResp) throws ClassNotFoundException, SQLException, IdNotFoundException, BadInfoException {
		questionarioRespDao.atualizar(questionarioResp);
	}
}