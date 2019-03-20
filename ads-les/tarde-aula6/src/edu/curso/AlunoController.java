package edu.curso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/aluno")
public class AlunoController extends HttpServlet{
	private static final long serialVersionUID = 7573763948016204944L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		System.out.println("Servlet foi acionado");
		res.sendRedirect("./alunos.jsp");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		List<Aluno> alunos = (List<Aluno>) req.getServletContext().getAttribute("ALUNOS");
		if (alunos == null) {
			alunos = new ArrayList<>();
			req.getServletContext().setAttribute("ALUNOS", alunos);
		}
			
		System.out.println("Do Post foi acionado");
		String ra = req.getParameter("ra");
		String nome = req.getParameter("nome");
		String idade = req.getParameter("idade");
		
		System.out.println("Ra: " + ra);
		System.out.println("Nome: " + nome);
		System.out.println("Idade: " + idade);
	
		Aluno a = new Aluno();
		a.setRa(ra);
		a.setNome(nome);
		try {
			a.setIdade(Integer.parseInt(idade));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		alunos.add(a);
		System.out.println("Alunos na Lista:" + alunos.size());
		res.sendRedirect("./alunos.jsp");
	}	
}
