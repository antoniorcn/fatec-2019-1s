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
		String cmd = req.getParameter("cmd");
		HttpSession session = req.getSession();
		lista = (List<Jogo>)getServletContext().getAttribute("LISTA");
		if (id != null && !id.isEmpty() && lista != null) {
			long numId = Long.parseLong(id);
			if ("editar".equals(cmd)) { 
				for (Jogo j : lista) { 
					if (j.getId() == numId) { 
						session.setAttribute("JOGO", j);
						break;
					}
				}
			} else if ("remover".equals(cmd)) {
				for (Jogo j : lista) { 
					if (j.getId() == numId) {
						lista.remove(j);
						break;
					}
				}
				System.out.println("Removido ID : " + numId);
				session.setAttribute("ENCONTRADOS", lista);
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
				j.setId(lista.size() + 1);
				lista.add(j);	
				texto = "Jogo cadastrado com sucesso";
				encontrados.addAll(lista);
			} else if ("Salvar".equals(cmd)) {
				for (Jogo jogo : lista) { 
					if (jogo.getId() == j.getId()) {
						lista.remove(jogo);
						lista.add(j);
						break;
					}
				}
				texto = "Jogo atualizado com sucesso";
				encontrados.addAll(lista);
			} else if ("Pesquisar".equals(cmd)) {
				encontrados.clear();
				for (Jogo jogo : lista) { 
					if (jogo.getNome().contains(j.getNome())) {
						encontrados.add(jogo);
					}
				}
			}
			
			HttpSession session = req.getSession();
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
