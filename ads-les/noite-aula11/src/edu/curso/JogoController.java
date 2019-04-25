package edu.curso;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.curso.dao.DAOException;
import edu.curso.dao.JogoDAO;
import edu.curso.dao.JogoDAOImpl;
import edu.curso.dao.JogoDAOORM;

@WebServlet("/jogo")
public class JogoController extends HttpServlet {
	// private List<Jogo> lista;
	private static final long serialVersionUID = 5931706310984055050L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws IOException { 
		JogoDAO jogoDao = new JogoDAOORM();
		String id = req.getParameter("id");
		String cmd = req.getParameter("cmd");
		HttpSession session = req.getSession();
		// lista = (List<Jogo>)getServletContext().getAttribute("LISTA");
		if (id != null && !id.isEmpty()) {
			long numId = Long.parseLong(id);
			if ("editar".equals(cmd)) {			
				Jogo j = null;
				try {	
					j = jogoDao.pesquisarPorId(numId);
				} catch (DAOException e) {
					e.printStackTrace();
				}
				session.setAttribute("JOGO", j);
			} else if ("remover".equals(cmd)) {
				try {
					jogoDao.remover(numId);
					session.setAttribute("ENCONTRADOS", 
							jogoDao.pesquisarTodos());
				} catch (DAOException e) {
					e.printStackTrace();
				}
			}
		}
		res.sendRedirect("./jogo.jsp");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException {
		JogoDAO jogoDao = new JogoDAOORM();
		HttpSession session = req.getSession();
		// lista = (List<Jogo>)getServletContext().getAttribute("LISTA");
		// if (lista == null) { 
		//	lista = new ArrayList<>();
		//	getServletContext().setAttribute("LISTA", lista);
		//}
		try {
			String id = req.getParameter("id");
			if (id == null || id.isEmpty()) { 
				id = "0";
			}
			String cmd = req.getParameter("cmd");
			String nome = req.getParameter("nome");
			String genero = req.getParameter("genero");
			String lancamento = req.getParameter("lancamento");
			float preco = 0;
			int intId = Integer.parseInt(id);
			preco = Float.parseFloat(req.getParameter("preco"));

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	

			Jogo j = new Jogo();
			j.setId(intId);
			j.setNome( nome );
			j.setGenero(genero);
			j.setPreco(preco);
			j.setLancamento(sdf.parse(lancamento));

			String texto = "";
			List<Jogo> encontrados = new ArrayList<>();
			if ("Adicionar".equals(cmd)) { 
				// j.setId(lista.size() + 1);
				// lista.add(j);
				try {
					jogoDao.adicionar(j);
					texto = "Jogo cadastrado com sucesso";
					session.setAttribute("JOGO", null);
					encontrados.addAll(jogoDao.pesquisarTodos());
				} catch (DAOException e) {
					e.printStackTrace();
				}
			} else if ("Salvar".equals(cmd)) {
				try {
					jogoDao.atualizar(j.getId(), j);
					texto = "Jogo atualizado com sucesso";
					encontrados.addAll(jogoDao.pesquisarTodos());
					session.setAttribute("JOGO", null);
				} catch (DAOException e) {
					e.printStackTrace();
				}
			} else if ("Pesquisar".equals(cmd)) {
				encontrados.clear();
				//				for (Jogo jogo : lista) { 
				//					if (jogo.getNome().contains(j.getNome())) {
				//						encontrados.add(jogo);
				//					}
				//				}
				try {
					encontrados.addAll(
							jogoDao.pesquisarPorNome(j.getNome()));
				} catch (DAOException e) {
					e.printStackTrace();
				}
				session.setAttribute("JOGO", null);
			}
			session.setAttribute("MENSAGEM", texto);
			session.setAttribute("ENCONTRADOS", encontrados);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		res.sendRedirect("./jogo.jsp");
	}
}
