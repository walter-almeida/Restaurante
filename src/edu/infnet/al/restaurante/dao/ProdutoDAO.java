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
import edu.infnet.al.restaurante.model.Produto;

public class ProdutoDAO extends GenericoDAO<Produto>{

	private Connection conn;
	
	public ProdutoDAO() throws DAOException {
		conn = Conector.getConnection();
	}
	
	@Override
	public void incluir(Produto entidade) throws DAOException {
		String sql = "INSERT INTO produto (categoria, preco, codigo) VALUES (?,?,?)";
		PreparedStatement comando = null;
		try {
			comando = conn.prepareStatement(sql);
			preencheCampos(comando, entidade);
			comando.execute();
		} catch (SQLException e) {
				throw new DAOException("Erro ao criar um novo produto",e);
		}finally {
			if(comando != null) {
				try {
					comando.close();
				} catch (SQLException e) {
					throw new DAOException("Erro ao fechar o PrepareStatement - ProdutoDAO", e);					
				}
			}
		
		}
		
	}

	private void preencheCampos(PreparedStatement comando, Produto entidade) throws SQLException {
		comando.setString(1, entidade.getCategoria());
		comando.setDouble(2, entidade.getPreco());		
		comando.setInt(3, entidade.getCodigo());
	}

	@Override
	public void alterar(Produto entidade) throws DAOException {
		String sql = "UPDATE produto SET categoria=?, preco=?, codigo=? WHERE id=?";
		PreparedStatement comando = null;
		
		try {
			comando = conn.prepareStatement(sql);
			
			preencheCampos(comando, entidade);
			comando.setInt(4, entidade.getId());
			comando.execute();
			
		} catch (SQLException e) {
				throw new DAOException("Erro ao alterar o produto",e);
		}finally {
			try {
				comando.close();
			} catch (SQLException e) {
				throw new DAOException("Erro ao fechar PreparedStatement em ProdutoDAO", e);
			}
		}
		
	}

	@Override
	public void excluir(Produto entidade) throws DAOException {
		String sql = "DELETE FROM produto WHERE id = ?";
		PreparedStatement comando = null;
		
		try {
			comando = conn.prepareStatement(sql);
			comando.setInt(1, entidade.getId());
			comando.execute();
		} catch (SQLException e) {
			throw new DAOException("Erro ao deletar o produto", e);
		}
		
	}

	@Override
	public Produto obter(int id) throws DAOException {
		String sql = "SELECT * FROM produto WHERE id= ?";
		
		Produto produto = new Produto();
		PreparedStatement comando = null;
		ResultSet rs = null;
		try {
			comando = conn.prepareStatement(sql);
			
			comando.setInt(1, id);
			
			rs = comando.executeQuery();
			
			if(rs.next()) {
				produto = obterProduto(rs);				
			}
			
		} catch (SQLException e) {
			throw new DAOException("Erro ao buscar um produto", e);
		}
		
		return produto;
		
	}

	private Produto obterProduto(ResultSet rs) throws SQLException {
		Produto produto = new Produto();
		produto.setId(rs.getInt("id"));
		produto.setCategoria(rs.getString("categoria"));
		produto.setPreco(rs.getDouble("preco"));
		produto.setCodigo(rs.getInt("codigo"));

		return produto;		
	}

	@Override
	public List<Produto> listar() throws DAOException {
		String sql = "SELECT * FROM produto";
		
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		PreparedStatement comando = null;
		ResultSet rs = null;
		try {
			comando = conn.prepareStatement(sql);
			rs = comando.executeQuery();
			
			while(rs.next()) {
				produtos.add(obterProduto(rs));				
			}
			
		} catch (SQLException e) {
			throw new DAOException("Erro ao buscar uma lista de produtos", e);
		}
		
		return produtos;
	}

	public Produto obterDoItem(int idItem) throws DAOException {
		String sql = "SELECT * FROM produto WHERE iditem=?";		
		Produto produto = null;
		PreparedStatement comando = null;
		ResultSet rs = null;
		try {
			comando = conn.prepareStatement(sql);
			comando.setInt(1, idItem);
			rs = comando.executeQuery();
			
			
			if(rs.next()) {
				produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setCategoria(rs.getString("categoria"));
				produto.setCodigo(rs.getInt("codigo"));
				produto.setPreco(rs.getDouble("preco"));
				
			}
			
		} catch (SQLException e) {
			throw new DAOException("Erro ao buscar o produto do item "+idItem, e);
		}finally {
			try {
				comando.close();
			} catch (SQLException e) {
				throw new DAOException("Erro ao fechar o comando sql em Produto.obterDoItem", e);
			}
		}
		
		return produto;
	}

	
	
}
