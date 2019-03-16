package edu.curso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = -151296923914786408L;
	protected void doGet(HttpServletRequest request, 
							HttpServletResponse response) 
									throws ServletException, IOException {
		System.out.println("Servlet acionado");
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) { 
			String chave = headerNames.nextElement();
			String valor = request.getHeader(chave);
			System.out.println(chave + ":" + valor);
		}
		PrintWriter out = response.getWriter();
		out.println("<html><h1>Ola navegador ....</h1></html>");
		out.flush();
	}
}
