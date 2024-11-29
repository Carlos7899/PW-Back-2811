package br.com.fiap.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.model.Pesquisador;

public class PesquisadorDao {

	private Connection conn;

	public PesquisadorDao(Connection conn) {
		this.conn = conn;
	}

	public void cadastrar(Pesquisador pesquisador) throws ClassNotFoundException, SQLException {

		// Criar o objeto com o comando SQL configuravel
		PreparedStatement stm = conn.prepareStatement("INSERT INTO PESQUISADOR (nome, nivel) values (?, ?)");

		// Setar os valores no comando SQL
		//stm.setInt(1, 3);
		stm.setString(1, pesquisador.getNome());
		stm.setDouble(2, pesquisador.getNivel());

		// Executar o comando SQL
		stm.executeUpdate();
	}

	public List<Pesquisador> listar() throws ClassNotFoundException, SQLException {

		PreparedStatement stm = conn.prepareStatement("select * from pesquisador");

		ResultSet result = stm.executeQuery();
		List<Pesquisador> lista = new ArrayList<Pesquisador>();

		while (result.next()) {
			Pesquisador pesquisador = parse(result);
			lista.add(pesquisador);
			
		}
		///////////////////////////////////////////////////////////////////////////////////////
		conn.close();
		return lista;
		
	}
	
	private Pesquisador parse(ResultSet result) throws SQLException {

		int codigo = result.getInt("codigo");
		String nome = result.getString("nome");
		double nivel = result.getDouble("nivel");

		Pesquisador pesquisador = new Pesquisador(codigo, nome, nivel);

		return pesquisador;
		
	}
	
	
	public void remover(int id) throws ClassNotFoundException, SQLException, IdNotFoundException {

		// PreparedStatement
		PreparedStatement stm = conn.prepareStatement("delete from pesquisador where codigo = ?");
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

	public void atualizar(Pesquisador pesquisador) throws ClassNotFoundException, SQLException, IdNotFoundException {

		// PreparedStatement
		PreparedStatement stm = conn.prepareStatement("update pesquisador set nome = ?, nivel = ? where codigo = ?");
		// Setar os parametros na Query
		stm.setString(1, pesquisador.getNome());
		stm.setDouble(2, pesquisador.getNivel());
		stm.setInt(3, pesquisador.getCodigo());
		
		// Executar a Query
		int linha = stm.executeUpdate();
		if (linha == 0)
			throw new IdNotFoundException("Não encontrado para atualizar");
	}
}