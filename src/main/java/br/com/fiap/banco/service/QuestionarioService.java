package br.com.fiap.banco.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import br.com.fiap.banco.dao.QuestionarioDao;
import br.com.fiap.banco.exception.BadInfoException;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.factory.ConnectionFactory;
import br.com.fiap.banco.model.Questionario;

public class QuestionarioService {

	private QuestionarioDao questionarioDao;
	
	public QuestionarioService() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionFactory.getConnection();
		questionarioDao = new QuestionarioDao(conn);

	}
	
	public void cadastrar(Questionario questionario) throws ClassNotFoundException, SQLException, BadInfoException {
		questionarioDao.cadastrar(questionario);
	}
	
	
	public List<Questionario> listar() throws ClassNotFoundException, SQLException{
		return questionarioDao.listar();
	}
	
	public void remover(int id) throws ClassNotFoundException, SQLException, IdNotFoundException {
		questionarioDao.remover(id);
	}

	
	public void atualizar(Questionario questionario) throws ClassNotFoundException, SQLException, IdNotFoundException, BadInfoException {
		questionarioDao.atualizar(questionario);
	}
}