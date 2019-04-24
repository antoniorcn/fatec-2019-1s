package edu.curso;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import edu.curso.dao.AluguelDAO;
import edu.curso.dao.AluguelDAOImpl;

@WebServlet("/rest")
public class restController extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException { 
		PrintWriter out = res.getWriter();
		
		AluguelDAO aDao = new AluguelDAOImpl();
		List<AluguelCarro> lista = aDao.pesquisarTodos();
		
		Gson gson = new Gson();
		JsonElement json = gson.toJsonTree(lista);
		res.setContentType("text/json");
		out.println(json.toString());
	}
}
