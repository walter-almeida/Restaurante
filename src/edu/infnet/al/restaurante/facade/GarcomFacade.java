package edu.infnet.al.restaurante.facade;

import java.util.List;

import edu.infnet.al.restaurante.dao.GarcomDAO;
import edu.infnet.al.restaurante.exception.DAOException;
import edu.infnet.al.restaurante.model.Funcionario;
import edu.infnet.al.restaurante.model.Garcom;

public class GarcomFacade {
	
		
	public void incluir(Garcom garcom) throws DAOException{
		GarcomDAO dao = new GarcomDAO();
		dao.incluir((Funcionario)garcom);
		
	}
	
	public void alterar(Garcom garcom) throws DAOException{
		GarcomDAO dao = new GarcomDAO();
		dao.alterar((Funcionario)garcom);
		
	}
	
	
	public void excluir(Garcom garcom) throws DAOException{
		GarcomDAO dao = new GarcomDAO();
		dao.excluir((Funcionario)garcom);
		
	}
	
	public List<Garcom> consultar() throws DAOException{
		GarcomDAO dao = new GarcomDAO();
		return dao.listarGarcons();
		
	}
	
	
	
	
	
}
