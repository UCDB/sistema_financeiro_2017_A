package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Caixa;


public class CaixaRepositoryBanco {

	private Connection conexao = ConexaoFactory.criarConexao();

	public void cadastrar(Caixa caixa) {
		String sql = "insert into caixa (data, descricao, valor, status, formapagamento, id_tipodespesa, id_cliente) values (?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, caixa.getData());
			ps.setString(2, caixa.getDescricao());
			ps.setDouble(3, caixa.getValor());
			ps.setBoolean(4, caixa.isStatus());
			ps.setInt(5, caixa.getFormapagamento());
			ps.setInt(6, caixa.getId_tipodespesa());
			ps.setInt(7, caixa.getId_cliente());

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void alterar(Caixa caixa) {
		String sql = "update caixa set data=?,descricao=?, valor=?, status=?, formapagamento=?, id_tipodespesa=?, id_cliente=?, where id_caixa=?";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, caixa.getData());
			ps.setString(2, caixa.getDescricao());
			ps.setDouble(3, caixa.getValor());
			ps.setBoolean(4, caixa.isStatus());
			ps.setInt(5, caixa.getFormapagamento());
			ps.setInt(6, caixa.getId_tipodespesa());
			ps.setInt(7, caixa.getId_cliente());

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		try {
			String sql = "delete from caixa where id_caixa=?";
			PreparedStatement prepareStatement = conexao.prepareStatement(sql);
			prepareStatement.setInt(1, id);
			prepareStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
