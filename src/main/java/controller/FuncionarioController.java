package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.JsonHelper;
import model.Funcionario;
import repository.FuncionarioRepositoryBanco;

@WebServlet(urlPatterns = "/funcionario")
public class FuncionarioController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	FuncionarioRepositoryBanco func = new FuncionarioRepositoryBanco();
	private JsonHelper jsonHelper = new JsonHelper();
	
	@Override
	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nome = req.getParameter("nome"); 
		String endereco =  req.getParameter("endereco");
		String cpf = req.getParameter("cpf");
		String rg = req.getParameter("rg");
		String telefone = req.getParameter("telefone");
		String cep = req.getParameter("cep");
		String email = req.getParameter("email");
		String contato = req.getParameter("contato");
		String info_add = req.getParameter("info_add");
		
		System.out.println("Nome: "+nome);
		System.out.println("Endereço: "+endereco);
		System.out.println("CPF: "+cpf);
		System.out.println("RG: "+rg);
		System.out.println("Fone: "+telefone);
		System.out.println("CEP: "+cep);
		System.out.println("Mail: "+email);
		System.out.println("Contato: "+contato);
		System.out.println("Informações: "+info_add);
		
		Funcionario f = new Funcionario(nome, endereco, cpf, rg, telefone, cep, email, contato, info_add);
		func.cadastrar(f);
		
		try {
			resp.getWriter().println(jsonHelper.gerarJson(f));
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
