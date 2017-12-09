package edu.infnet.al.restaurante.facade;

import java.util.List;

import edu.infnet.al.restaurante.dao.ProdutoDAO;
import edu.infnet.al.restaurante.dominio.Categoria;
import edu.infnet.al.restaurante.exception.DAOException;
import edu.infnet.al.restaurante.model.Produto;

public class ProdutoFacade {
	
	public boolean incluir(Produto produto) throws DAOException{
		ProdutoDAO dao = new ProdutoDAO();
		if(validarCategoria(produto.getCategoria())){
			dao.incluir(produto);
			return true;
		}	
		
		return false;
	}
	
	
 
	private boolean validarCategoria(String categoria) {
		switch (categoria) {
		case "Bebidas": case "Aves": case "Massa": case "Petiscos": case "Sobremesa": case "Carnes" :
			return true;
		default:
			return false;
		}
		
	}


	public void alterar(Produto produto) throws DAOException{
		ProdutoDAO dao = new ProdutoDAO();
		dao.alterar(produto);		
	}
	
	
	public void excluir(Produto produto) throws DAOException{
		ProdutoDAO dao = new ProdutoDAO();
		dao.excluir(produto);
		
	}
	
	public List<Produto> consultar() throws DAOException{
		ProdutoDAO dao = new ProdutoDAO();
		return dao.listar();
		
	}
	
}
