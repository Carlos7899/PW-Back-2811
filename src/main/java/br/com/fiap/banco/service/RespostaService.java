package br.com.fiap.banco.service;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.banco.exception.BadInfoException;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.factory.ConnectionFactory;
import br.com.fiap.banco.model.Resposta;
import br.com.fiap.banco.dao.PesquisadorDao;

public class RespostaService {/*
	/*
	
	private RespostaDao respostaDao;
	
	public RespostaService() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionFactory.getConnection();
		respostaDao = new RespostaDao(conn);

	}

	public void cadastrar(Resposta resposta) throws ClassNotFoundException, SQLException, BadInfoException {
		respostaDao.cadastrar(resposta);
	}
		
		/*try (Connection conn = ConnectionFactory.getConnection()) {
			RespostaDao respostaDao = new RespostaDao(conn);
			respostaDao.cadastrar(resposta);
		}
	}*/

	
	public List<Resposta> listar() throws ClassNotFoundException, SQLException{
		return respostaDao.listar();
	}
	
	/*
	public List<Resposta> listar() throws ClassNotFoundException, SQLException {
		try (Connection conn = ConnectionFactory.getConnection()) {
			RespostaDao respostaDao = new RespostaDao(conn);
			return respostaDao.listar();
		}
	}*/

	public void remover(int id) throws ClassNotFoundException, SQLException, IdNotFoundException {
		respostaDao.remover(id);
	}
	
	/*
	public void remover(int id) throws ClassNotFoundException, SQLException, IdNotFoundException {
		try (Connection conn = ConnectionFactory.getConnection()) {
			RespostaDao respostaDao = new RespostaDao(conn);
			respostaDao.remover(id);
		}
	}*/

	
	/*
	public void atualizar(Resposta resposta) throws ClassNotFoundException, SQLException, IdNotFoundException, BadInfoException {
		try (Connection conn = ConnectionFactory.getConnection()) {
			RespostaDao respostaDao = new RespostaDao(conn);
			respostaDao.atualizar(resposta);
		}
	}*/
	
	public void atualizar(Resposta resposta) throws ClassNotFoundException, SQLException, IdNotFoundException, BadInfoException {
		respostaDao.atualizar(resposta);
	}

	*/
}


/*
package br.com.fiap.banco.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import br.com.fiap.banco.dao.RespostaDao;
import br.com.fiap.banco.exception.BadInfoException;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.factory.ConnectionFactory;
import br.com.fiap.banco.model.Resposta;

public class RespostaService {

	private RespostaDao respostaDao;
	
	public RespostaService() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionFactory.getConnection();
		respostaDao = new RespostaDao(conn);

	}
	
	public void cadastrar(Resposta resposta) throws ClassNotFoundException, SQLException, BadInfoException {
		respostaDao.cadastrar(resposta);
	}
	
	
	public List<Resposta> listar() throws ClassNotFoundException, SQLException{
		return respostaDao.listar();
	}
	
	
	public void remover(int id) throws ClassNotFoundException, SQLException, IdNotFoundException {
		respostaDao.remover(id);
	}

	
	public void atualizar(Resposta resposta) throws ClassNotFoundException, SQLException, IdNotFoundException, BadInfoException {
		respostaDao.atualizar(resposta);
	}
}
*/