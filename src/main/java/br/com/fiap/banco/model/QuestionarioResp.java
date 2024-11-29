package br.com.fiap.banco.model;

public class QuestionarioResp {
	
	private int codigoQuestionarioResp;
	private String questaoUmResp;
	private String questaoDoisResp;
	private String questaoTresResp;
	private String questaoQuatroResp;
	
	public QuestionarioResp(int codigoQuestionarioResp, String questaoUmResp, String questaoDoisResp, String questaoTresResp,
			String questaoQuatroResp) {
	
		this.codigoQuestionarioResp = codigoQuestionarioResp;
		this.questaoUmResp = questaoUmResp;
		this.questaoDoisResp = questaoDoisResp;
		this.questaoTresResp = questaoTresResp;
		this.questaoQuatroResp = questaoQuatroResp;
	}
	
	public QuestionarioResp(int codigoQuestionarioResp) {
		
		this.codigoQuestionarioResp = codigoQuestionarioResp;

	}
	
	public QuestionarioResp(String questaoUmResp) {
		
		this.questaoUmResp = questaoUmResp;

	}
	
	public QuestionarioResp(String questaoUmResp, String questaoDoisResp, String questaoTresResp,
			String questaoQuatroResp) {
		super();
		this.questaoUmResp = questaoUmResp;
		this.questaoDoisResp = questaoDoisResp;
		this.questaoTresResp = questaoTresResp;
		this.questaoQuatroResp = questaoQuatroResp;
	}

	public QuestionarioResp() {

	}

	public int getCodigoQuestionarioResp() {
		return codigoQuestionarioResp;
	}

	public void setCodigoQuestionarioResp(int codigoQuestionarioResp) {
		this.codigoQuestionarioResp = codigoQuestionarioResp;
	}

	public String getQuestaoUmResp() {
		return questaoUmResp;
	}

	public void setQuestaoUmResp(String questaoUmResp) {
		this.questaoUmResp = questaoUmResp;
	}

	public String getQuestaoDoisResp() {
		return questaoDoisResp;
	}

	public void setQuestaoDoisResp(String questaoDoisResp) {
		this.questaoDoisResp = questaoDoisResp;
	}

	public String getQuestaoTresResp() {
		return questaoTresResp;
	}

	public void setQuestaoTresResp(String questaoTresResp) {
		this.questaoTresResp = questaoTresResp;
	}

	public String getQuestaoQuatroResp() {
		return questaoQuatroResp;
	}

	public void setQuestaoQuatroResp(String questaoQuatroResp) {
		this.questaoQuatroResp = questaoQuatroResp;
	}			
}