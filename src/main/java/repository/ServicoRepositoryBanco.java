package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import model.Servico;

public class ServicoRepositoryBanco {

	private Connection conexao = ConexaoFactory.criarConexao();
	
	public void cadastrar(Servico serv) {
		String sql = "insert into servico (id_funcionario,referencia,descricao,tipo,valorServico,valorMax,valorMin) values (?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, serv.getId_funcionario());
			ps.setString(2, serv.getReferencia());
			ps.setString(3, serv.getDescricao());
			ps.setString(4, serv.getTipo());
			ps.setDouble(5, serv.getValorServico());
			ps.setDouble(6, serv.getValorMax());
			ps.setDouble(7, serv.getValorMin());
			
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void alterar(Servico serv) {
		String sql = "update servico set referencia=?,descricao=?,tipo=?,valorServico=?,valorMax=?,valorMin=? where id=?";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, serv.getReferencia());
			ps.setString(2, serv.getDescricao());
			ps.setString(3, serv.getTipo());
			ps.setDouble(4, serv.getValorServico());
			ps.setDouble(5, serv.getValorMax());
			ps.setDouble(6, serv.getValorMin());

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void excluir(int id) {
		try {
			String sql = "delete from servico where id=?";
			PreparedStatement prepareStatement = conexao.prepareStatement(sql);
			prepareStatement.setInt(1, id);
			prepareStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
