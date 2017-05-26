package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Funcionario;

public class FuncionarioRepositoryBanco {
private Connection conexao = ConexaoFactory.criarConexao();
	
	public void cadastrar(Funcionario func) {
		String sql = "insert into funcionario (nome,endereco,cpf,rg,telefone,cep,email) values (?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setString(1, func.getNome());
			ps.setString(2, func.getEndereco());
			ps.setString(3, func.getCpf());
			ps.setString(4, func.getRg());
			ps.setString(5, func.getTelefone());
			ps.setString(6, func.getCep());
			ps.setString(7, func.getEmail());
			
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void alterar(Funcionario func) {
		String sql = "update funcionario set nome=?,endereco=?,cpf=?,rg=?,telefone=?,cep=?,email=? where id=?";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, func.getNome());
			ps.setString(2, func.getEndereco());
			ps.setString(3, func.getCpf());
			ps.setString(4, func.getRg());
			ps.setString(5, func.getTelefone());
			ps.setString(6, func.getCep());
			ps.setString(7, func.getEmail());

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void excluir(int id) {
		try {
			String sql = "delete from funcionario where id=?";
			PreparedStatement prepareStatement = conexao.prepareStatement(sql);
			prepareStatement.setInt(1, id);
			prepareStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
