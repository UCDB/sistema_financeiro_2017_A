package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import model.TipoDespesa;

public class TipoDespesaRepositoryBanco {
	private Connection conexao = ConexaoFactory.criarConexao();

	public void cadastrar(TipoDespesa tipodespesa) {
		String sql = "insert into tipo_despesa (descricao) values (?)";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);			
			ps.setString(1, tipodespesa.getDescricao());
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void alterar(TipoDespesa tipodespesa) {
		String sql = "update tipo_despesa set descricao=? where id_tipodespesa=?";
		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, tipodespesa.getDescricao());
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void excluir(int id) {
		try {
			String sql = "delete from tipo_despesa where id_tipodespesa=?";
			PreparedStatement prepareStatement = conexao.prepareStatement(sql);
			prepareStatement.setInt(1, id);
			prepareStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
