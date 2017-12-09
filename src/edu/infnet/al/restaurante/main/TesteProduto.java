package edu.infnet.al.restaurante.main;

import java.util.List;

import edu.infnet.al.restaurante.exception.DAOException;
import edu.infnet.al.restaurante.facade.ProdutoFacade;
import edu.infnet.al.restaurante.model.Produto;

public class TesteProduto {
	public void testeIncluirProduto(){
		Produto produto = new Produto();
		produto.setCategoria("Bebidas");
		produto.setCodigo(15);
		produto.setPreco(4.90);
		
		ProdutoFacade facade = new ProdutoFacade();
		try {
			facade.incluir(produto);
			List<Produto> produtos = facade.consultar();
			for(Produto p: produtos){
				System.out.println(p.toString());
			}
		} catch (DAOException e) {
			System.out.println("Não foi possível adicionar ");
		}
		
		System.out.println("testeIncluirProduto() executado com sucesso! ");
	}

		
	public void testeAlterarProduto(){
		ProdutoFacade facade = new ProdutoFacade();
		
		try {
			List<Produto> produtos = facade.consultar(); 
			Produto produto = produtos.get(produtos.size()-1);
			produto.setPreco(100);
			facade.alterar(produto);
			produtos = facade.consultar();
			for(Produto p: produtos){
				System.out.println(p.toString());
			}
		} catch (DAOException e) {
			System.out.println("Não foi possível alterar \n"+e);
		}
		System.out.println("testeAlterarProduto() executado com sucesso! ");
	}
	
	public void testeExcluirProduto(){
		ProdutoFacade facade = new ProdutoFacade();
		
		try {
			List<Produto> produtos = facade.consultar();
			Produto produto = produtos.get(produtos.size()-1);
			facade.excluir(produto);
			produtos = facade.consultar();
			for(Produto p: produtos){
				System.out.println(p.toString());
			}
		} catch (DAOException e) {
			System.out.println("Não foi possível excluir \n"+e);
		}
		
		System.out.println("testeExcluirProduto() executado com sucesso! ");
	}
	
	public void testeConsultarProduto(){
		ProdutoFacade facade = new ProdutoFacade();
		List<Produto> produtos;
		try {
			produtos = facade.consultar();
			for(Produto p: produtos){
				System.out.println(p.toString());
			}
		} catch (DAOException e) {
			System.out.println("Não foi possível consultar \n"+e);
		}
		
		System.out.println("testeConsultarProduto() executado com sucesso! ");
	}
}
