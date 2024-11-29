package br.com.fiap.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.model.QuestionarioResp;

public class QuestionarioRespDao {

	private Connection conn;

	public QuestionarioRespDao(Connection conn) {
		this.conn = conn;
	}

	public void cadastrar(QuestionarioResp questionarioResp) throws ClassNotFoundException, SQLException {
		//Resp
		// Criar o objeto com o comando SQL configuravel
		PreparedStatement stm = conn.prepareStatement("INSERT INTO QUESTIONARIORESP (QUESTAOUMRESP, QUESTAODOISRESP, QUESTAOTRESRESP, QUESTAOQUATRORESP) values (?, ?, ?, ?)");
		// Setar os valores no comando SQL
		stm.setString(1, questionarioResp.getQuestaoUmResp());
		stm.setString(2, questionarioResp.getQuestaoDoisResp());
		stm.setString(3, questionarioResp.getQuestaoTresResp());
		stm.setString(4, questionarioResp.getQuestaoQuatroResp());
		stm.executeUpdate();
	}

	public List<QuestionarioResp> listar() throws ClassNotFoundException, SQLException {

		PreparedStatement stm = conn.prepareStatement("select * from QUESTIONARIORESP");

		ResultSet result = stm.executeQuery();
		List<QuestionarioResp> lista = new ArrayList<QuestionarioResp>();

		while (result.next()) {
			QuestionarioResp questionarioResp = parse(result);
			lista.add(questionarioResp);
			
		}

		conn.close();
		return lista;
		
	}
	
	private QuestionarioResp parse(ResultSet result) throws SQLException {

		int codigoQuestionarioResp = result.getInt("codigoQuestionarioResp");
		String questaoUmResp = result.getString("questaoumResp");
		String questaoDoisResp = result.getString("questaodoisResp");
		String questaoTresResp = result.getString("questaotresResp");
		String questaoQuatroResp = result.getString("questaoquatroResp");
		
		QuestionarioResp questionarioResp = new QuestionarioResp(codigoQuestionarioResp, questaoUmResp, questaoDoisResp, questaoTresResp, questaoQuatroResp);

		return questionarioResp;
	}
	
	
	public void remover(int id) throws ClassNotFoundException, SQLException, IdNotFoundException {

		// PreparedStatement
		PreparedStatement stm = conn.prepareStatement("delete from QUESTIONARIORESP where codigoquestionarioresppesq = ?");
		// Setar os parametros na Query
		stm.setInt(1, id);
		// Executar a Query
		stm.executeUpdate();
		//int linha = stm.executeUpdate();
		//if (linha == 0) {
		//	throw new IdNotFoundException("Nome não encontrado para remoção");
		//}
		///////////////////////////////////////////////////////////////////////////////////////
		conn.close();
	}

	public void atualizar(QuestionarioResp questionarioResp) throws ClassNotFoundException, SQLException, IdNotFoundException {

		// PreparedStatement
		PreparedStatement stm = conn.prepareStatement("update QUESTIONARIORESP set QUESTAOUMRESP = ?, QUESTAODOISRESP = ?, QUESTAOTRESRESP = ?, QUESTAOQUATRORESP = ? where CODIGOQUESTIONARIORESP = ?");
		// Setar os parametros na Query
		stm.setString(1, questionarioResp.getQuestaoUmResp());
		stm.setString(2, questionarioResp.getQuestaoDoisResp());
		stm.setString(3, questionarioResp.getQuestaoTresResp());
		stm.setString(4, questionarioResp.getQuestaoQuatroResp());
		stm.setInt(5, questionarioResp.getCodigoQuestionarioResp());
		
		// Executar a Query
		int linha = stm.executeUpdate();
		if (linha == 0)
			throw new IdNotFoundException("Não encontrado para atualizar");
	}
}