package edu.infnet.al.restaurante.facade;

import java.util.List;

import edu.infnet.al.restaurante.dao.PercentualComissaoDAO;
import edu.infnet.al.restaurante.exception.DAOException;
import edu.infnet.al.restaurante.model.PercentualComissao;

public class PercentualComissaoFacade {

	public void incluir(PercentualComissao percentualComissao)throws DAOException{
		PercentualComissaoDAO dao = new PercentualComissaoDAO();
		dao.incluir(percentualComissao);
			
	}
		
				
	public List<PercentualComissao> consultar()throws DAOException{
		PercentualComissaoDAO dao = new PercentualComissaoDAO();
		return dao.listar();
		
	}
		
	
}
