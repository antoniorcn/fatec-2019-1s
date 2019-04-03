package edu.curso;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
		HttpSession session = req.getSession();
		System.out.println("Do Post foi acionado");
		String cmd = req.getParameter("cmd");
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
		if ("adicionar".equals(cmd)) { 
			a.setId(alugueis.size() + 1);
			alugueis.add(a);
			String texto = "Aluguel cadastrado com sucesso";
			session.setAttribute("MENSAGEM", texto);
			// System.out.println("Alugueis na Lista:" + alugueis.size());
			session.setAttribute("ENCONTRADOS", alugueis);
		} else if ("salvar".equals(cmd)) { 
			for (AluguelCarro al :alugueis) {
				if (al.getId() == a.getId()) { 
					alugueis.remove(al);
					alugueis.add(a);
					break;
				}
			}
			session.setAttribute("ALUGUEL", new AluguelCarro());
			String texto = "Aluguel atualizado com sucesso";
			session.setAttribute("MENSAGEM", texto);
			System.out.println("Salvo com sucesso, alugueis na Lista:" + alugueis.size());
			session.setAttribute("ENCONTRADOS", alugueis);
		} else if ("pesquisarTodos".equals(cmd)) {			
			session.setAttribute("ENCONTRADOS", alugueis);
			session.setAttribute("ALUGUEL", new AluguelCarro());
		} else if ("pesquisar".equals(cmd)) {
			List<AluguelCarro> encontrados = new ArrayList<>();
			Calendar calPesquisa = Calendar.getInstance();
			calPesquisa.setTime(a.getDataInicio());
			for (AluguelCarro al :alugueis) {
				Calendar calAluguel = Calendar.getInstance();
				calAluguel.setTime(al.getDataInicio());
				if (calAluguel.get(Calendar.YEAR) == calPesquisa.get(Calendar.YEAR) &&
					calAluguel.get(Calendar.MONTH) == calPesquisa.get(Calendar.MONTH)	&& 
					calAluguel.get(Calendar.DAY_OF_MONTH) == calPesquisa.get(Calendar.DAY_OF_MONTH)) { 
					encontrados.add(al);
				}
			}
			session.setAttribute("ENCONTRADOS", encontrados);
		}
		res.sendRedirect("./aluguelCarro.jsp");
	}	
}
