package br.com.fiap.banco.teste;

import java.util.List;

import br.com.fiap.banco.model.Pesquisador;
import br.com.fiap.banco.service.PesquisadorService;

public class TesteSelecionarFuncionario {

	//Testar a pesquisa por nome
	public static void main(String[] args) {
		try {
			PesquisadorService service = new PesquisadorService();
			
			//Pesquisar os produtos por nome
			List<Pesquisador> lista = service.listar();
			
			//Exibir todos os nomes dos produtos retornados
			for (Pesquisador item : lista)
				System.out.println(item.getNome());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}