package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.JsonHelper;
import model.Cliente;
import repository.ClienteRepositoryBanco;

@WebServlet(urlPatterns = "/clcontroller")
public class ClienteController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private JsonHelper jsonHelper = new JsonHelper();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer id = Integer.parseInt(req.getParameter("id"));
		String nome = req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		String cpf = req.getParameter("cpf");
		String rg = req.getParameter("rg");
		String telefone = req.getParameter("telefone");
		String cep = req.getParameter("cep");
		String contato = req.getParameter("contato");
		String info = req.getParameter("info");
		String email = req.getParameter("email");
		
		Cliente cl = new Cliente(id, nome, endereco, cpf, rg, telefone, cep, contato, info, email);
	
		
	}
	
}
