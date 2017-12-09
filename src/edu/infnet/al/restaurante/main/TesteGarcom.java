package edu.infnet.al.restaurante.main;

import java.util.List;

import edu.infnet.al.restaurante.exception.DAOException;
import edu.infnet.al.restaurante.facade.GarcomFacade;
import edu.infnet.al.restaurante.model.Garcom;

public class TesteGarcom {
	public void testeIncluirGarcom(){
		Garcom garcom = new Garcom();
		
		garcom.setEndereco("Rua D");
		garcom.setIdentidade(32233);
		garcom.setMatricula(5565);
		garcom.setNome("Garcomito");
		garcom.setTelefone(213344388);
		
		GarcomFacade facade = new GarcomFacade();
		try {
			facade.incluir(garcom);
			List<Garcom> garcoms = facade.consultar();
			for(Garcom p: garcoms){
				System.out.println(p.toString());
			}
		} catch (DAOException e) {
			System.out.println("Não foi possível adicionar "+e);
		}
		
		System.out.println("testeIncluirGarcom() executado com sucesso! ");
	}

		
	public void testeAlterarGarcom(){
		GarcomFacade facade = new GarcomFacade();
		
		try {
			List<Garcom> garcoms = facade.consultar(); 
			Garcom garcom = garcoms.get(garcoms.size()-1);
			garcom.setEndereco("Rua Z");
			facade.alterar(garcom);
			garcoms = facade.consultar();
			for(Garcom p: garcoms){
				System.out.println(p.toString());
			}
		} catch (DAOException e) {
			System.out.println("Não foi possível alterar \n"+e);
		}
		
		System.out.println("testeAlterarGarcom() executado com sucesso! ");
	}
	
	public void testeExcluirGarcom(){
		GarcomFacade facade = new GarcomFacade();
		
		try {
			List<Garcom> garcoms = facade.consultar();
			Garcom garcom = garcoms.get(garcoms.size()-1);
			facade.excluir(garcom);
			garcoms = facade.consultar();
			for(Garcom p: garcoms){
				System.out.println(p.toString());
			}
		} catch (DAOException e) {
			System.out.println("Não foi possível excluir \n"+e);
		}
		System.out.println("testeExcluirGarcom() executado com sucesso! ");
	}
	
	public void testeConsultarGarcom(){
		GarcomFacade facade = new GarcomFacade();
		List<Garcom> garcoms;
		try {
			garcoms = facade.consultar();
			for(Garcom p: garcoms){
				System.out.println(p.toString());
			}
		} catch (DAOException e) {
			System.out.println("Não foi possível consultar \n"+e);
		}
		System.out.println("testeConsultarGarcom() executado com sucesso! ");
	}

}
