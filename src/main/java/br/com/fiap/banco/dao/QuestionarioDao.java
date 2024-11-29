package br.com.fiap.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.model.Questionario;

public class QuestionarioDao {

	private Connection conn;

	public QuestionarioDao(Connection conn) {
		this.conn = conn;
	}

	public void cadastrar(Questionario questionario) throws ClassNotFoundException, SQLException {

		// Criar o objeto com o comando SQL configuravel
		PreparedStatement stm = conn.prepareStatement("INSERT INTO QUESTIONARIO (QUESTAOUM, QUESTAODOIS, QUESTAOTRES, QUESTAOQUATRO) values (?, ?, ?, ?)");
		// Setar os valores no comando SQL
		stm.setString(1, questionario.getQuestaoUm());
		stm.setString(2, questionario.getQuestaoDois());
		stm.setString(3, questionario.getQuestaoTres());
		stm.setString(4, questionario.getQuestaoQuatro());
		stm.executeUpdate();
	}

	public List<Questionario> listar() throws ClassNotFoundException, SQLException {

		PreparedStatement stm = conn.prepareStatement("select * from QUESTIONARIO");

		ResultSet result = stm.executeQuery();
		List<Questionario> lista = new ArrayList<Questionario>();

		while (result.next()) {
			Questionario questionario = parse(result);
			lista.add(questionario);
			
		}

		conn.close();
		return lista;
		
	}
	
	private Questionario parse(ResultSet result) throws SQLException {

		int codigoQuestionario = result.getInt("codigoQuestionario");
		String questaoUm = result.getString("questaoum");
		String questaoDois = result.getString("questaodois");
		String questaoTres = result.getString("questaotres");
		String questaoQuatro = result.getString("questaoquatro");
		
		Questionario questionario = new Questionario(codigoQuestionario, questaoUm, questaoDois, questaoTres, questaoQuatro);

		return questionario;
	}
	
	
	public void remover(int id) throws ClassNotFoundException, SQLException, IdNotFoundException {

		// PreparedStatement
		PreparedStatement stm = conn.prepareStatement("delete from QUESTIONARIO where codigoquestionario = ?");
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

	public void atualizar(Questionario questionario) throws ClassNotFoundException, SQLException, IdNotFoundException {

		// PreparedStatement
		PreparedStatement stm = conn.prepareStatement("update QUESTIONARIO set QUESTAOUM = ?, QUESTAODOIS = ?, QUESTAOTRES = ?, QUESTAOQUATRO = ? where CODIGOQUESTIONARIO = ?");
		// Setar os parametros na Query
		stm.setString(1, questionario.getQuestaoUm());
		stm.setString(2, questionario.getQuestaoDois());
		stm.setString(3, questionario.getQuestaoTres());
		stm.setString(4, questionario.getQuestaoQuatro());
		stm.setInt(5, questionario.getCodigoQuestionario());
		
		// Executar a Query
		int linha = stm.executeUpdate();
		if (linha == 0)
			throw new IdNotFoundException("Não encontrado para atualizar");
	}
	
}