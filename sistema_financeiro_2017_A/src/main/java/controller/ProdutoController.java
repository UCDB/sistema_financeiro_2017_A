package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.JsonHelper;
import model.Produto;
import model.Servico;
import repository.ServicoRepositoryList;
import repository.ServicoRepository;

@WebServlet(urlPatterns = "/servicocontroller")
public class ProdutoController<ServicoRepository> extends HttpServlet{

	private ServicoRepository servicoRepository = (ServicoRepository) new repository.ServicoRepositoryBanco();
	
	private JsonHelper jsonHelper = new JsonHelper();
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String descricao = req.getParameter("descricao");
		Integer codbarras = Integer.parseInt(req.getParameter("codbarras"));
		Integer id_fornercedor = Integer.parseInt(req.getParameter("id_fornercedor"));
		Double precocusto = Double.parseDouble(req.getParameter("precocusto"));
		Double precovenda = Double.parseDouble(req.getParameter("precovenda"));
		Double precominvenda = Double.parseDouble(req.getParameter("precominvenda"));
		Double precomaxvenda = Double.parseDouble(req.getParameter("precomaxvenda"));
		Double comissaovenda = Double.parseDouble(req.getParameter("comissaovenda"));
		
		Produto prod = new Produto(null, descricao, codbarras, id_fornercedor, precocusto, precovenda, precominvenda, precomaxvenda, comissaovenda, qtdestoque, qtdminestque, altura, peso, largura, profundidade, id_medidaproduto, id_tipopodruto, id_funcionario, validade)
		
		((repository.ServicoRepository)servicoRepository).cadastrar(prod);
		
		try {
			resp.getWriter().println(jsonHelper.gerarJson(prod));
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
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String opcao = req.getParameter("opcao");
		String json;
		
		if( opcao == "buscarId" ){
			try {
				int id = Integer.parseInt(req.getParameter("id"));
				json = jsonHelper.gerarJson(((ServicoRepositoryList) servicoRepository).buscarPorId(id));
				resp.getWriter().print(json);
			} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
