package controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.RottaUtils;

import helper.JsonHelper;
import model.Produto;
import repository.ProdutoRepositoryBanco;

@WebServlet(urlPatterns = "/produtocontroller")
public class ProdutoController<ProdutoRepository> extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProdutoRepositoryBanco produtoRepository = new ProdutoRepositoryBanco();
	private JsonHelper jsonHelper = new JsonHelper();

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		

		Produto prod = (Produto) RottaUtils.populaReq(new Produto(), req.getParameterMap());		

		produtoRepository.cadastrar(prod);
		
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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String json;

		try {
			
			json = jsonHelper.gerarJsonLista(produtoRepository.buscarTodos());
			resp.getWriter().print(json);
		} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		Produto prod = (Produto) RottaUtils.populaReq(new Produto(), req.getParameterMap());		
		produtoRepository.alterar(prod);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		produtoRepository.excluir(id);
	}
}
