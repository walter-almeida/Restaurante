package edu.infnet.al.restaurante.model;



public class Garcom extends Funcionario{
	private int idGarcom;
	private int identidade;
	private int matricula;
	
	private double comissao;
	
	
	public int getIdentidade() {
		return identidade;
	}
	public void setIdentidade(int identidade) {
		this.identidade = identidade;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public int getIdGarcom() {
		return idGarcom;
	}
	public void setIdGarcom(int idGarcom) {
		this.idGarcom = idGarcom;
	}
	
	@Override
	public String toString() {
		return "Garcom [idGarcom=" + idGarcom + ", identidade=" + identidade + ", matricula=" + matricula + "]";
	}
	public double getComissao() {
		return comissao;
	}
	public void setComissao(double comissao) {
		this.comissao = comissao;
	}
	
	
	
	
}
