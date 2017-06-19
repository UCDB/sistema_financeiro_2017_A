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
import model.Funcionario;
import repository.ClienteRepositoryBanco;
import repository.FuncionarioRepositoryBanco;

@WebServlet(urlPatterns = "/cliente")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteRepositoryBanco crb = new ClienteRepositoryBanco();

	private JsonHelper jsonHelper = new JsonHelper();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome 	= req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		String cpf 		= req.getParameter("cpf");
		String rg 		= req.getParameter("rg");
		String telefone = req.getParameter("telefone");
		String cep 		= req.getParameter("cep");
		String contato 	= req.getParameter("contato");
		String info_add	= req.getParameter("info_add");
		String email 	= req.getParameter("email");

		Cliente cl = new Cliente(nome, endereco, cpf, rg, telefone, cep, contato, info_add, email);
		crb.cadastrar(cl);

		try {
			resp.getWriter().println(jsonHelper.gerarJson(cl));
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

	/*@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// capturando valores para alterar
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

		/*Cliente cl = new Cliente();
	
		cl.setId(id);
		cl.setNome(nome);
		cl.setEndereco(endereco);
		cl.setCpf(cpf);
		cl.setRg(rg);
		cl.setCep(cep);
		cl.setContato(contato);
		cl.setTelefone(telefone);
		cl.setEmail(email);
		cl.setInfo(info);
		
		cli.alterar(cl);
		//verificando caso algum valor esteja null, evitando erros posteriormente
		if (id != null) {
			cl.setId(id);
		}
		if (nome != null) {
			cl.setNome(nome);
		}
		if (endereco != null) {
			cl.setEndereco(endereco);
		}
		if (cpf != null) {
			cl.setCpf(cpf);
		}
		if (rg != null) {
			cl.setRg(rg);
		}
		if (telefone != null) {
			cl.setTelefone(telefone);
		}
		if (cep != null) {
			cl.setCep(cep);
		}
		if (contato != null) {
			cl.setContato(contato);
		}
		if (info != null) {
			cl.setInfo(info);
		}
		if (email != null) {
			cl.setEmail(email);
		}
		
		cli.alterar(cl);
	}*/
	
	/*protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String json;
		String idb = req.getParameter("id");
		
		if(idb.equals("all")){
		    try {
				json = jsonHelper.gerarJsonLista(cli.buscarTodos());
				resp.getWriter().print(json);
			} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			idb = req.getParameter("id");
			int id = Integer.parseInt(idb);
			try {
				json = jsonHelper.gerarJson(cli.buscarPorId(id));
				resp.getWriter().print(json);
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
	}*/

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		crb.excluir(id);
	}
}