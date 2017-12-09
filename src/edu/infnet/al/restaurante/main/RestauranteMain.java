package edu.infnet.al.restaurante.main;

import java.util.Date;
import java.util.List;

import edu.infnet.al.restaurante.dao.ContaDAO;
import edu.infnet.al.restaurante.exception.DAOException;
import edu.infnet.al.restaurante.facade.ContaFacade;
import edu.infnet.al.restaurante.facade.GarcomFacade;
import edu.infnet.al.restaurante.model.Conta;
import edu.infnet.al.restaurante.model.Garcom;

public class RestauranteMain {

	public static void main(String[] args) {
		//ContaFacade
		abrirNovaConta();
		
		//ProdutoFacade
		
		TesteProduto testeProduto = new TesteProduto();
		testeProduto.testeIncluirProduto();
		testeProduto.testeAlterarProduto();
		testeProduto.testeExcluirProduto();
		testeProduto.testeConsultarProduto();
		
		//GarcomFacade
		
		TesteGarcom tg = new TesteGarcom();
		tg.testeIncluirGarcom();
		tg.testeAlterarGarcom();
		tg.testeExcluirGarcom();
		tg.testeConsultarGarcom();
		
		//PercentualComissaoFacade
		
		TestePercencentualComissao tpc = new TestePercencentualComissao();
		tpc.testeIncluirPercentualComissao();
		tpc.testeConsultarPercentualComissao();
	

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
			
		} catch (Exception e) {
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
			if(!facade.abrirConta(conta)){
				System.out.println("Indique o garçom que está realizando o atendimento.");
			}
			List<Conta> contas = new ContaDAO().listar();
			for(Conta c : contas){
				System.out.println(c.toString());
			}
		} catch (DAOException e) {
			System.out.println("Não foi possível abrir a conta. \n"+e);
		}
	}

	

}
