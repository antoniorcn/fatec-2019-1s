package edu.curso;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Publicador implements Autor {
	private String nome;
	public Publicador(String nome) {
		this.nome = nome;
	}
	List<Seguidor> lista = new ArrayList<>();
	public void adicionar(Seguidor s) {
		lista.add(s);
	}
	public void remover(Seguidor s) {
		lista.remove(s);
	}
	public void publicar(String msg, Date d) {
		for (Seguidor s : lista) { 
			s.receberNotificacao(nome + " informa " + msg, d);
		}
	}
}
