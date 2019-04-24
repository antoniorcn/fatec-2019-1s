package edu.curso;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.curso.dao.AluguelDAO;
import edu.curso.dao.AluguelDAOImpl;
@WebServlet("/aluguelCarros")
public class AluguelCarrosController extends HttpServlet{
	private static final long serialVersionUID = 5227031325710536347L;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private AluguelDAO aluguelDao = new AluguelDAOImpl();
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String id = req.getParameter("id");
		String cmd = req.getParameter("cmd");
		HttpSession session = req.getSession();
		
		if (id != null && !id.isEmpty()) {
			long lId = Long.parseLong(id);
			if ("editar".equals(cmd)) {
				AluguelCarro ac = aluguelDao.pesquisarPorId(lId);
				session.setAttribute("ALUGUEL", ac);			
			} else if ("remover".equals(cmd)) {
				aluguelDao.remover(lId);
				session.setAttribute("ALUGUEL", new AluguelCarro());
			}
		}
		res.sendRedirect("./aluguelCarro.jsp");
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		System.out.println("Do Post foi acionado");
		String cmd = req.getParameter("cmd");
		String id = req.getParameter("id");
		String modelo = req.getParameter("modeloCarro");
		String data = req.getParameter("dataAluguel");
		String dias = req.getParameter("diasAluguel");
		AluguelCarro a = new AluguelCarro();
		try {
			if (id == null || id.isEmpty()) { 
				id = "0";
			}
			a.setId(Integer.parseInt(id));
			a.setModeloCarro(modelo);	
			a.setDataInicio(sdf.parse(data));
			a.setDias(Integer.parseInt(dias));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if ("adicionar".equals(cmd)) {
			aluguelDao.adicionar(a);
			String texto = "Aluguel cadastrado com sucesso";
			session.setAttribute("MENSAGEM", texto);
			session.setAttribute("ENCONTRADOS", aluguelDao.pesquisarTodos());
		} else if ("salvar".equals(cmd)) { 
			aluguelDao.atualizar(a.getId(), a);
			session.setAttribute("ALUGUEL", new AluguelCarro());
			String texto = "Aluguel atualizado com sucesso";
			session.setAttribute("MENSAGEM", texto);
			session.setAttribute("ENCONTRADOS", aluguelDao.pesquisarTodos());
		} else if ("pesquisarTodos".equals(cmd)) {			
			session.setAttribute("ENCONTRADOS", aluguelDao.pesquisarTodos());
			session.setAttribute("ALUGUEL", new AluguelCarro());
		} else if ("pesquisar".equals(cmd)) {
			List<AluguelCarro> encontrados = new ArrayList<>();
			encontrados = aluguelDao.pesquisar(a.getDataInicio());
			session.setAttribute("ENCONTRADOS", encontrados);
		}
		res.sendRedirect("./aluguelCarro.jsp");
	}	
}
