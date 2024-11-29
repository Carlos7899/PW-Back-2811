package br.com.fiap.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.model.QuestionarioRespPesq;

public class QuestionarioRespPesqDao {

	private Connection conn;

	public QuestionarioRespPesqDao(Connection conn) {
		this.conn = conn;
	}

	public void cadastrar(QuestionarioRespPesq questionarioRespPesq) throws ClassNotFoundException, SQLException {
		//RespPesq
		// Criar o objeto com o comando SQL configuravel
		PreparedStatement stm = conn.prepareStatement("INSERT INTO QUESTIONARIORESPPESQ (QUESTAOUMRESPPESQ, QUESTAODOISRESPPESQ, QUESTAOTRESRESPPESQ, QUESTAOQUATRORESPPESQ) values (?, ?, ?, ?)");
		// Setar os valores no comando SQL
		stm.setString(1, questionarioRespPesq.getQuestaoUmRespPesq());
		stm.setString(2, questionarioRespPesq.getQuestaoDoisRespPesq());
		stm.setString(3, questionarioRespPesq.getQuestaoTresRespPesq());
		stm.setString(4, questionarioRespPesq.getQuestaoQuatroRespPesq());
		stm.executeUpdate();
	}

	public List<QuestionarioRespPesq> listar() throws ClassNotFoundException, SQLException {

		PreparedStatement stm = conn.prepareStatement("select * from QUESTIONARIORESPPESQ");

		ResultSet result = stm.executeQuery();
		List<QuestionarioRespPesq> lista = new ArrayList<QuestionarioRespPesq>();

		while (result.next()) {
			QuestionarioRespPesq questionarioRespPesq = parse(result);
			lista.add(questionarioRespPesq);
			
		}

		conn.close();
		return lista;
		
	}
	
	private QuestionarioRespPesq parse(ResultSet result) throws SQLException {

		int codigoQuestionarioRespPesq = result.getInt("codigoQuestionarioRespPesq");
		String questaoUmRespPesq = result.getString("questaoumRespPesq");
		String questaoDoisRespPesq = result.getString("questaodoisRespPesq");
		String questaoTresRespPesq = result.getString("questaotresRespPesq");
		String questaoQuatroRespPesq = result.getString("questaoquatroRespPesq");
		
		QuestionarioRespPesq questionarioRespPesq = new QuestionarioRespPesq(codigoQuestionarioRespPesq, questaoUmRespPesq, questaoDoisRespPesq, questaoTresRespPesq, questaoQuatroRespPesq);

		return questionarioRespPesq;
	}
	
	
	public void remover(int id) throws ClassNotFoundException, SQLException, IdNotFoundException {

		// PreparedStatement
		PreparedStatement stm = conn.prepareStatement("delete from QUESTIONARIORESPPESQ where codigoquestionarioresppesq = ?");
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

	public void atualizar(QuestionarioRespPesq questionarioRespPesq) throws ClassNotFoundException, SQLException, IdNotFoundException {

		// PreparedStatement
		PreparedStatement stm = conn.prepareStatement("update QUESTIONARIORESPPESQ set QUESTAOUMRESPPESQ = ?, QUESTAODOISRESPPESQ = ?, QUESTAOTRESRESPPESQ = ?, QUESTAOQUATRORESPPESQ = ? where CODIGOQUESTIONARIORESPPESQ = ?");
		// Setar os parametros na Query
		stm.setString(1, questionarioRespPesq.getQuestaoUmRespPesq());
		stm.setString(2, questionarioRespPesq.getQuestaoDoisRespPesq());
		stm.setString(3, questionarioRespPesq.getQuestaoTresRespPesq());
		stm.setString(4, questionarioRespPesq.getQuestaoQuatroRespPesq());
		stm.setInt(5, questionarioRespPesq.getCodigoQuestionarioRespPesq());
		
		// Executar a Query
		int linha = stm.executeUpdate();
		if (linha == 0)
			throw new IdNotFoundException("Não encontrado para atualizar");
	}
}