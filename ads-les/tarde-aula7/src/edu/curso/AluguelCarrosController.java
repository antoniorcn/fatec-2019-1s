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
@WebServlet("/aluguelCarros")
public class AluguelCarrosController extends HttpServlet{
	private static final long serialVersionUID = 5227031325710536347L;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String id = req.getParameter("id");
		List<AluguelCarro> alugueis = 
				(List<AluguelCarro>) 
				getServletContext().getAttribute("ALUGUEIS");
		if (id != null && !id.isEmpty() && alugueis != null) { 
			long lId = Long.parseLong(id);
			for (AluguelCarro ac : alugueis) { 
				if (ac.getId() == lId) { 
					HttpSession session = req.getSession();
					session.setAttribute("ALUGUEL", ac);
					break;
				}
			}
		}
		
		res.sendRedirect("./aluguelCarro.jsp");
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		List<AluguelCarro> alugueis = (List<AluguelCarro>) req.getServletContext().getAttribute("ALUGUEIS");
		if (alugueis == null) {
			alugueis = new ArrayList<>();
			req.getServletContext().setAttribute("ALUGUEIS", alugueis);
		}
		System.out.println("Do Post foi acionado");
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
		a.setId(alugueis.size());
		alugueis.add(a);
		String texto = "Aluguel cadastrado com sucesso";
		HttpSession session = req.getSession();
		session.setAttribute("MENSAGEM", texto);
		System.out.println("Alugueis na Lista:" + alugueis.size());
		res.sendRedirect("./aluguelCarro.jsp");
	}	
}
