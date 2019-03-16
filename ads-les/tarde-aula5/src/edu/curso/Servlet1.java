package edu.curso;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = -1133716042404416857L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) { 
		System.out.println("Header recebido do navegador:");
		Enumeration<String> names = req.getHeaderNames();
		while (names.hasMoreElements()) { 
			String chave = names.nextElement();
			String valor = req.getHeader(chave);
			System.out.printf("%s:%s\n", chave, valor);
		}
		try {
			PrintWriter out = res.getWriter();
			out.println("<html><h1>Ola navegador .... </h1></html>");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
