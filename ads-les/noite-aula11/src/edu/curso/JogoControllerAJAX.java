package edu.curso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.curso.dao.DAOException;
import edu.curso.dao.JogoDAO;
import edu.curso.dao.JogoDAOORM;

@WebServlet("/ajax")
public class JogoControllerAJAX extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException { 
		JogoDAO jogoDao = new JogoDAOORM();
		List<Jogo> jogos = new ArrayList<>();
		try {
			jogos = jogoDao.pesquisarTodos();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		String listaJson = gson.toJson(jogos);
		System.out.println(listaJson);
		res.getWriter().println(listaJson);
		
		
	}
	
}
