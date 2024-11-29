package br.com.fiap.banco.model;

public class Questionario {
	
	private int codigoQuestionario;
	private String questaoUm;
	private String questaoDois;
	private String questaoTres;
	private String questaoQuatro;
	
	public Questionario(int codigoQuestionario, String questaoUm, String questaoDois, String questaoTres,
			String questaoQuatro) {
	
		this.codigoQuestionario = codigoQuestionario;
		this.questaoUm = questaoUm;
		this.questaoDois = questaoDois;
		this.questaoTres = questaoTres;
		this.questaoQuatro = questaoQuatro;
	}
	
	public Questionario(int codigoQuestionario) {
		
		this.codigoQuestionario = codigoQuestionario;

	}
	
	public Questionario(String questaoUm) {
		
		this.questaoUm = questaoUm;

	}
	
	public Questionario(String questaoUm, String questaoDois, String questaoTres,
			String questaoQuatro) {
		super();
		this.questaoUm = questaoUm;
		this.questaoDois = questaoDois;
		this.questaoTres = questaoTres;
		this.questaoQuatro = questaoQuatro;
	}

	public Questionario() {

	}

	public int getCodigoQuestionario() {
		return codigoQuestionario;
	}

	public void setCodigoQuestionario(int codigoQuestionario) {
		this.codigoQuestionario = codigoQuestionario;
	}

	public String getQuestaoUm() {
		return questaoUm;
	}

	public void setQuestaoUm(String questaoUm) {
		this.questaoUm = questaoUm;
	}

	public String getQuestaoDois() {
		return questaoDois;
	}

	public void setQuestaoDois(String questaoDois) {
		this.questaoDois = questaoDois;
	}

	public String getQuestaoTres() {
		return questaoTres;
	}

	public void setQuestaoTres(String questaoTres) {
		this.questaoTres = questaoTres;
	}

	public String getQuestaoQuatro() {
		return questaoQuatro;
	}

	public void setQuestaoQuatro(String questaoQuatro) {
		this.questaoQuatro = questaoQuatro;
	}		
	
}
