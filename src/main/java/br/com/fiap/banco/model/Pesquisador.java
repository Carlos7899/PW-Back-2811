package br.com.fiap.banco.model;

public class Pesquisador extends Pessoa{
	
	private double nivel;

	public Pesquisador() {
	}
	
	public Pesquisador(String nome, double nivel) {
		super(nome);
		this.nivel = nivel;
	}
	
	public Pesquisador(int codigo, String nome, double nivel) {
		super(codigo, nome);
		this.nivel = nivel;
	}
	
	
	public Pesquisador(double nivel) {
		this.nivel = nivel;
	}
	
	public Pesquisador(String nome) {
		super(nome);
	}
	
	
	public double getNivel() {
		return nivel;
	}

	public void setNivel(double nivel) {
		this.nivel = nivel;
	}	
}