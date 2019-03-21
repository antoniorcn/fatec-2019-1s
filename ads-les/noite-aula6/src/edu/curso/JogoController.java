package edu.curso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.ha.backend.Sender;

@WebServlet("/jogo")
public class JogoController extends HttpServlet {
	private List<Jogo> lista;
	private static final long serialVersionUID = 5931706310984055050L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws IOException { 
		System.out.println("JogoController - doGet Executado");
		
		res.sendRedirect("./jogo.jsp");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException {
		
		lista = (List<Jogo>)getServletContext().getAttribute("LISTA");
		if (lista == null) { 
			lista = new ArrayList<>();
			getServletContext().setAttribute("LISTA", lista);
		}
		String nome = req.getParameter("nome");
		String genero = req.getParameter("genero");
		float preco = 0;
		try {
			preco = Float.parseFloat(req.getParameter("preco"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		Jogo j = new Jogo();
		j.setNome( nome );
		j.setGenero(genero);
		j.setPreco(preco);
		
		lista.add(j);
		
		System.out.println("Nome: " + j.getNome());
		System.out.println("Genero: " + j.getGenero());
		System.out.println("Preco: " + j.getPreco());
		System.out.println("A lista tem " + lista.size());
		
		res.sendRedirect("./jogo.jsp");
		
	}

}
