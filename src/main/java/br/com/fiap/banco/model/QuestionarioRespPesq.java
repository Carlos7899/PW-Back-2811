package br.com.fiap.banco.model;

public class QuestionarioRespPesq {
	
	private int codigoQuestionarioRespPesq;
	private String questaoUmRespPesq;
	private String questaoDoisRespPesq;
	private String questaoTresRespPesq;
	private String questaoQuatroRespPesq;
	
	public QuestionarioRespPesq(int codigoQuestionarioRespPesq, String questaoUmRespPesq, String questaoDoisRespPesq, String questaoTresRespPesq,
			String questaoQuatroRespPesq) {
	
		this.codigoQuestionarioRespPesq = codigoQuestionarioRespPesq;
		this.questaoUmRespPesq = questaoUmRespPesq;
		this.questaoDoisRespPesq = questaoDoisRespPesq;
		this.questaoTresRespPesq = questaoTresRespPesq;
		this.questaoQuatroRespPesq = questaoQuatroRespPesq;
	}
	
	public QuestionarioRespPesq(int codigoQuestionarioRespPesq) {
		
		this.codigoQuestionarioRespPesq = codigoQuestionarioRespPesq;

	}
	
	public QuestionarioRespPesq(String questaoUmRespPesq) {
		
		this.questaoUmRespPesq = questaoUmRespPesq;

	}
	
	public QuestionarioRespPesq(String questaoUmRespPesq, String questaoDoisRespPesq, String questaoTresRespPesq,
			String questaoQuatroRespPesq) {
		super();
		this.questaoUmRespPesq = questaoUmRespPesq;
		this.questaoDoisRespPesq = questaoDoisRespPesq;
		this.questaoTresRespPesq = questaoTresRespPesq;
		this.questaoQuatroRespPesq = questaoQuatroRespPesq;
	}

	public QuestionarioRespPesq() {

	}

	public int getCodigoQuestionarioRespPesq() {
		return codigoQuestionarioRespPesq;
	}

	public void setCodigoQuestionarioRespPesq(int codigoQuestionarioRespPesq) {
		this.codigoQuestionarioRespPesq = codigoQuestionarioRespPesq;
	}

	public String getQuestaoUmRespPesq() {
		return questaoUmRespPesq;
	}

	public void setQuestaoUmRespPesq(String questaoUmRespPesq) {
		this.questaoUmRespPesq = questaoUmRespPesq;
	}

	public String getQuestaoDoisRespPesq() {
		return questaoDoisRespPesq;
	}

	public void setQuestaoDoisRespPesq(String questaoDoisRespPesq) {
		this.questaoDoisRespPesq = questaoDoisRespPesq;
	}

	public String getQuestaoTresRespPesq() {
		return questaoTresRespPesq;
	}

	public void setQuestaoTresRespPesq(String questaoTresRespPesq) {
		this.questaoTresRespPesq = questaoTresRespPesq;
	}

	public String getQuestaoQuatroRespPesq() {
		return questaoQuatroRespPesq;
	}

	public void setQuestaoQuatroRespPesq(String questaoQuatroRespPesq) {
		this.questaoQuatroRespPesq = questaoQuatroRespPesq;
	}			
}