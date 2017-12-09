package edu.infnet.al.restaurante.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.infnet.al.restaurante.conector.Conector;
import edu.infnet.al.restaurante.exception.DAOException;
import edu.infnet.al.restaurante.model.Item;

public class ItemDAO extends GenericoDAO<Item>{

	private Connection conn;
	
	public ItemDAO() throws DAOException {
		conn = Conector.getConnection();
	}
	
		
	public void incluir(Item entidade) throws DAOException {
		String sql = "INSERT INTO item (quantidade, idConta, preco, idProduto) VALUES (?,?,?,?)";
		PreparedStatement comando = null;
		
		try {
			comando = conn.prepareStatement(sql);
			preencheCampos(comando, entidade);
			comando.setInt(3, entidade.getProduto().getId());
			
			if (comando.executeUpdate() > 0){
	            ResultSet rs = comando.getGeneratedKeys();
	            rs.next(); 
	            entidade.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
				throw new DAOException("Erro ao criar um novo item",e);
		}finally {
			if(comando != null) {
				try {
					comando.close();
				} catch (SQLException e) {
					throw new DAOException("Erro ao fechar o PrepareStatement - ItemDAO", e);					
				}
			}
		
		}
		
	}

	@Override
	public void alterar(Item entidade) throws DAOException {
		String sql = "UPDATE item SET quantidade=?, idconta=?, preco=? WHERE id=?";
		PreparedStatement comando = null;
		
		try {
			comando = conn.prepareStatement(sql);
			
			preencheCampos(comando, entidade);
			comando.setInt(4, entidade.getId());
			comando.execute();
			
		} catch (SQLException e) {
				throw new DAOException("Erro ao criar um novo item",e);
		}finally {
			try {
				comando.close();
			} catch (SQLException e) {
				throw new DAOException("Erro ao fechar PreparedStatement em ItemDAO", e);
			}
		}
		
	}

	@Override
	public void excluir(Item entidade) throws DAOException {
		String sql = "DELETE FROM item WHERE id = ?";
		PreparedStatement comando = null;
		
		try {
			comando = conn.prepareStatement(sql);
			comando.setInt(1, entidade.getId());
			comando.execute();
		} catch (SQLException e) {
			throw new DAOException("Erro ao deletar o item", e);
		}
		
		
	}

	@Override
	public Item obter(int id) throws DAOException {
		String sql = "SELECT * FROM item WHERE id= ?";
		
		Item item = new Item();
		PreparedStatement comando = null;
		ResultSet rs = null;
		try {
			comando = conn.prepareStatement(sql);
			
			comando.setInt(1, id);
			
			rs = comando.executeQuery();
			
			if(rs.next()) {
				item = obterItem(rs);				
			}
			
		} catch (SQLException e) {
			throw new DAOException("Erro ao buscar um item", e);
		}
		
		return item;
	}
	

	private Item obterItem(ResultSet rs) throws SQLException, DAOException {
		Item item = new Item();
		item.setId(rs.getInt("id"));
		item.setQuantidade(rs.getInt("quantidade"));
		item.setIdConta(rs.getInt("idconta"));
		item.setPreco(rs.getDouble("preco"));
		item.setProduto(new ProdutoDAO().obterDoItem(item.getId()));

		return item;
	}


	@Override
	public List<Item> listar() throws DAOException {
		String sql = "SELECT * FROM item";
		
		ArrayList<Item> itens = new ArrayList<Item>();
		PreparedStatement comando = null;
		ResultSet rs = null;
		try {
			comando = conn.prepareStatement(sql);
			rs = comando.executeQuery();
			
			while(rs.next()) {
				itens.add(obterItem(rs));				
			}
			
		} catch (SQLException e) {
			throw new DAOException("Erro ao buscar uma lista de itens", e);
		}
		
		return itens;
	}


	public List<Item> listar(int idConta) throws DAOException {
		String sql = "SELECT * FROM item WHERE idconta=?";		
		ArrayList<Item> itens = new ArrayList<Item>();
		PreparedStatement comando = null;
		ResultSet rs = null;
		try {
			comando = conn.prepareStatement(sql);
			comando.setInt(1, idConta);
			rs = comando.executeQuery();
			
			while(rs.next()) {
				itens.add(obterItem(rs));	
			}
			
		} catch (SQLException e) {
			throw new DAOException("Erro ao buscar uma lista de itens da conta "+idConta, e);
		}
		
		return itens;
	}
	
	private void preencheCampos(PreparedStatement comando, Item entidade) throws SQLException{
		comando.setInt(1, entidade.getQuantidade());
		comando.setInt(2, entidade.getIdConta());	
		comando.setDouble(3, entidade.getPreco());	
	}

}
