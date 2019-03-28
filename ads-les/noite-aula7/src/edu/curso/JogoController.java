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

@WebServlet("/jogo")
public class JogoController extends HttpServlet {
	private List<Jogo> lista;
	private static final long serialVersionUID = 5931706310984055050L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws IOException { 
		String id = req.getParameter("id");
		lista = (List<Jogo>)getServletContext().getAttribute("LISTA");
		if (id != null && !id.isEmpty() && lista != null) {
			long numId = Long.parseLong(id);
			for (Jogo j : lista) { 
				if (j.getId() == numId) { 
					HttpSession session = req.getSession();
					session.setAttribute("JOGO", j);
					break;
				}
			}
		}
		res.sendRedirect("./jogo.jsp");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException {
		
		lista = (List<Jogo>)getServletContext().getAttribute("LISTA");
		if (lista == null) { 
			lista = new ArrayList<>();
			getServletContext().setAttribute("LISTA", lista);
		}
		try {
			String id = req.getParameter("id");
			if (id == null || id.isEmpty()) { 
				id = "0";
			}
			String nome = req.getParameter("nome");
			String genero = req.getParameter("genero");
			String lancamento = req.getParameter("lancamento");
			float preco = 0;
			preco = Float.parseFloat(req.getParameter("preco"));
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
			
			Jogo j = new Jogo();
			j.setId(lista.size());
			j.setNome( nome );
			j.setGenero(genero);
			j.setPreco(preco);
			j.setLancamento(sdf.parse(lancamento));
			
			lista.add(j);			
			String texto = "Jogo cadastrado com sucesso";
			HttpSession session = req.getSession();
			System.out.println("Session ID: " + session.getId());
			session.setAttribute("MENSAGEM", texto);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		res.sendRedirect("./jogo.jsp");
	}
}
