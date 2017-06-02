package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Produto;

public class ProdutoRepositoryBanco {

	private Connection conexao = ConexaoFactory.criarConexao();
	
	public void cadastrar(Produto prod) {
		String sql = "insert into produto (descricao,"
				+ "codbarras,"
				+ "id_fornecedor,"
				+ "precocusto,"
				+ "precovenda,"
				+ "precominvenda,"
				+ "precomaxvenda,"
				+ "comissaovenda,"
				+ "qtdestoque,"
				+ "qtdminestoque,"
				+ "altura,"
				+ "peso,"
				+ "largura,"
				+ "profundidade,"
				+ "id_medidaproduto,"
				+ "id_tipoproduto,"
				+ "id_funcionario,"
				+ "validade) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, prod.getDescricao());
			ps.setInt(2, prod.getCodbarras());
			ps.setInt(3, prod.getIdfornercedor());
			ps.setDouble(4, prod.getPrecocusto());
			ps.setDouble(5, prod.getPrecovenda());
			ps.setDouble(6, prod.getPrecominvenda());
			ps.setDouble(7, prod.getPrecomaxvenda());
			ps.setDouble(8, prod.getComissaovenda());
			ps.setDouble(9, prod.getQtdestoque());
			ps.setDouble(10, prod.getQtdminestoque());
			ps.setDouble(11, prod.getAltura());
			ps.setDouble(12, prod.getPeso());
			ps.setDouble(13, prod.getLargura());
			ps.setDouble(14, prod.getProfundidade());
			ps.setInt(15, prod.getIdmedidaproduto());
			ps.setInt(16, prod.getIdtipoproduto());
			ps.setInt(17, prod.getId_funcionario());
			ps.setString(18, prod.getValidade());
			
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void alterar(Produto prod) {
		String sql = "update produto set descricao=?,"
				+ "codbarras=?,"
				+ "id_fornecedor=?,"
				+ "precocusto=?,"
				+ "precovenda=?,"
				+ "precominvenda=?,"
				+ "precomaxvenda=?,"
				+ "comissaovenda=?,"
				+ "qtdestoque=?,"
				+ "qtdminestoque=?,"
				+ "altura=?,"
				+ "peso=?,"
				+ "largura=?,"
				+ "profundidade=?,"
				+ "id_medidaproduto=?,"
				+ "id_tipoproduto=?,"
				+ "id_funcionario=?,"
				+ "validade=? where id_produto=?";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, prod.getDescricao());
			ps.setInt(2, prod.getCodbarras());
			ps.setInt(3, prod.getIdfornercedor());
			ps.setDouble(4, prod.getPrecocusto());
			ps.setDouble(5, prod.getPrecovenda());
			ps.setDouble(6, prod.getPrecominvenda());
			ps.setDouble(7, prod.getPrecomaxvenda());
			ps.setDouble(8, prod.getComissaovenda());
			ps.setDouble(9, prod.getQtdestoque());
			ps.setDouble(10, prod.getQtdminestoque());
			ps.setDouble(11, prod.getAltura());
			ps.setDouble(12, prod.getPeso());
			ps.setDouble(13, prod.getLargura());
			ps.setDouble(14, prod.getProfundidade());
			ps.setInt(15, prod.getIdmedidaproduto());
			ps.setInt(16, prod.getIdtipoproduto());
			ps.setInt(17, prod.getId_funcionario());
			ps.setString(18, prod.getValidade());
			
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void excluir(int id) {
		try {
			String sql = "delete from produto where id=?";
			PreparedStatement prepareStatement = conexao.prepareStatement(sql);
			prepareStatement.setInt(1, id);
			prepareStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
