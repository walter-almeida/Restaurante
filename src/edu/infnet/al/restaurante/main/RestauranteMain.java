package edu.infnet.al.restaurante.main;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import edu.infnet.al.restaurante.dao.ContaDAO;
import edu.infnet.al.restaurante.exception.DAOException;
import edu.infnet.al.restaurante.facade.ContaFacade;
import edu.infnet.al.restaurante.facade.GarcomFacade;
import edu.infnet.al.restaurante.facade.ProdutoFacade;
import edu.infnet.al.restaurante.model.Conta;
import edu.infnet.al.restaurante.model.Garcom;
import edu.infnet.al.restaurante.model.Produto;

public class RestauranteMain {

	public static void main(String[] args) {
		//ContaFacade e GarcomFacade
		abrirNovaConta();
		
		//ProdutoFacade
		//cadastrarNovoProduto();

	}

	private static void cadastrarNovoProduto() {
		Produto produto = new Produto();
		produto.setCategoria("Bebida");
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
	}

	private static Garcom selecionarGarcom(String nome) {
		Garcom garcom = null;
		try {
			List<Garcom> garcons = new GarcomFacade().consultar();
			
			for(Garcom g : garcons){
				if(g.getNome().equals("Paulo")){
					garcom = g;
				}
			}
			
		} catch (DAOException e) {
			System.out.println("Não foi possível selecionar garçom. \n"+e);
			e.printStackTrace();
		} finally{
			return garcom;
		}
	}

	private static void abrirNovaConta() {
		Conta conta = new Conta();	
		conta.setDataHoraAbertura(new Date());
		conta.setGarcom(selecionarGarcom("Paulo"));
		ContaFacade facade = new ContaFacade();
		try {
			facade.abrirConta(conta);
			List<Conta> contas = new ContaDAO().listar();
			for(Conta c : contas){
				System.out.println(c.toString());
			}
		} catch (DAOException e) {
			System.out.println("Não foi possível abrir a conta. \n"+e);
		}
	}

	

}
