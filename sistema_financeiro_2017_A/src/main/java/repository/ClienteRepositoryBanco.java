package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Cliente;

public class ClienteRepositoryBanco {

	private Connection conexao = ConexaoFactory.criarConexao();
	
	public void cadastrar(Cliente cl) {
		String sql = "insert into cliente (id,nome,endereco,cpf,rg,telefone,cep,contato,info,email) values (?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, cl.getId());
			ps.setString(2, cl.getNome());
			ps.setString(3, cl.getEndereco());
			ps.setString(4, cl.getCpf());
			ps.setString(5, cl.getRg());
			ps.setString(6, cl.getTelefone());
			ps.setString(7, cl.getCep());
			ps.setString(8, cl.getContato());
			ps.setString(9, cl.getInfo());
			ps.setString(10, cl.getEmail());
			
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void alterar(Cliente cl){
		String sql = "update cliente set nome=?,endereco=?,cpf=?,rg=?,telefone=?,cep=?,contato=?,info=?,email=? where id=?";

		try {
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, cl.getNome());
			ps.setString(2, cl.getEndereco());
			ps.setString(3, cl.getCpf());
			ps.setString(4, cl.getRg());
			ps.setString(5, cl.getTelefone());
			ps.setString(6, cl.getCep());
			ps.setString(7, cl.getContato());
			ps.setString(8, cl.getInfo());
			ps.setString(9, cl.getEmail());

			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void excluir(int id) {
		try {
			String sql = "delete from cliente where id=?";
			PreparedStatement prepareStatement = conexao.prepareStatement(sql);
			prepareStatement.setInt(1, id);
			prepareStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
