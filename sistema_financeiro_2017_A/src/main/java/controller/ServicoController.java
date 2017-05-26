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
import model.Servico;
import repository.ServicoRepositoryList;
import repository.ServicoRepository;

@WebServlet(urlPatterns = "/servicocontroller")
public class ServicoController<ServicoRepository> extends HttpServlet{

	private ServicoRepository servicoRepository = (ServicoRepository) new repository.ServicoRepositoryBanco();
	
	private JsonHelper jsonHelper = new JsonHelper();
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String referencia = req.getParameter("referencia");
		String descricao = req.getParameter("descricao");
		String tipo = req.getParameter("tipo");
		Double valorServico = Double.parseDouble(req.getParameter("valorServico"));
		Double valorMax = Double.parseDouble(req.getParameter("valorMax"));
		Double valorMin = Double.parseDouble(req.getParameter("valorMin"));
		
		
		Servico serv = new Servico(null, referencia, descricao, tipo, valorServico, valorMax, valorMin);
		
		((repository.ServicoRepository)servicoRepository).cadastrar(serv);
		
		try {
			resp.getWriter().println(jsonHelper.gerarJson(serv));
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
