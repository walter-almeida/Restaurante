package edu.infnet.al.restaurante.main;

import java.util.Date;
import java.util.List;

import edu.infnet.al.restaurante.exception.DAOException;
import edu.infnet.al.restaurante.facade.PercentualComissaoFacade;
import edu.infnet.al.restaurante.model.PercentualComissao;

public class TestePercencentualComissao {
	public void testeIncluirPercentualComissao(){
		PercentualComissao percentualComissao = new PercentualComissao();
		percentualComissao.setDataHora(new Date());
		percentualComissao.setIdGarcom(1);
		percentualComissao.setValor(0.1);
		
		PercentualComissaoFacade facade = new PercentualComissaoFacade();
		try {
			facade.incluir(percentualComissao);
			List<PercentualComissao> percentualComissaos = facade.consultar();
			for(PercentualComissao p: percentualComissaos){
				System.out.println(p.toString());
			}
		} catch (DAOException e) {
			System.out.println("Não foi possível incluir \n"+e);
		}
		
		System.out.println("testeIncluirPercentualComissao() executado com sucesso! ");
	}

		
	
	public void testeConsultarPercentualComissao(){
		PercentualComissaoFacade facade = new PercentualComissaoFacade();
		List<PercentualComissao> percentualComissaos;
		try {
			percentualComissaos = facade.consultar();
			for(PercentualComissao p: percentualComissaos){
				System.out.println(p.toString());
			}
		} catch (DAOException e) {
			System.out.println("Não foi possível consultar \n"+e);
		}
		System.out.println("testeConsultarPercentualComissao() executado com sucesso! ");
	}

}
