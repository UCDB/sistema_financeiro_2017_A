package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Produto;
import model.Servico;
import model.TipoProduto;

public class TipoProdutoRepositoryBanco {

	private Connection conexao = ConexaoFactory.criarConexao();
	
	public void cadastrar(TipoProduto tprod) {
		String sql = "insert into tipo_produto (descricao) values (?)";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, tprod.getDescricao());
			
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void alterar(Produto prod) {
		String sql = "update tipo_produto set descricao=? where id_tipoproduto=?";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, prod.getDescricao());

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void excluir(int id) {
		try {
			String sql = "delete from tipo_produto where id_tipoproduto=?";
			PreparedStatement prepareStatement = conexao.prepareStatement(sql);
			prepareStatement.setInt(1, id);
			prepareStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
