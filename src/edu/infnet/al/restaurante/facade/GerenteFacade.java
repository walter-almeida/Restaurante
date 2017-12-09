package edu.infnet.al.restaurante.facade;

import java.util.List;

import edu.infnet.al.restaurante.dao.GerenteDAO;
import edu.infnet.al.restaurante.exception.DAOException;
import edu.infnet.al.restaurante.model.Funcionario;
import edu.infnet.al.restaurante.model.Gerente;

public class GerenteFacade {
	public void incluir(Gerente Gerente)throws DAOException{
		GerenteDAO dao = new GerenteDAO();
		dao.incluir((Funcionario)Gerente);
		
	}
	
	public void alterar(Gerente Gerente)throws DAOException{
		GerenteDAO dao = new GerenteDAO();
		dao.alterar((Funcionario)Gerente);

	}
	
	
	public void excluir(Gerente Gerente)throws DAOException{
		GerenteDAO dao = new GerenteDAO();
		dao.excluir((Funcionario)Gerente);
		
	}
	
	public List<Gerente> consultar()throws DAOException{
		GerenteDAO dao = new GerenteDAO();
		return dao.listarGerentes();
		
	}
}
