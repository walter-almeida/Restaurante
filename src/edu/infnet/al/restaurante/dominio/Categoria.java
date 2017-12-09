package edu.infnet.al.restaurante.dominio;

public enum Categoria {
	BEBIDAS("Bebidas"),
	AVES("Aves"),
	MASSA("Massa"),
	PETISCOS("Petiscos"),
	CARNES("Carnes"),
	SOBREMESA("Sobremesa");
	
	public String categoria;
	
	Categoria(String c){
		categoria = c;
	}
	
	public String getCategoria(){
		return categoria;
	}
}
