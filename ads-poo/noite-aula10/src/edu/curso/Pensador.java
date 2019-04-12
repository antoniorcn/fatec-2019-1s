package edu.curso;
import java.util.ArrayList;
import java.util.List;
public class Pensador implements Autor {
	private String nome;
	public Pensador(String nome) {
		this.nome = nome;
	}
	List<Assinante> lista = new ArrayList<>();
	public void adicionar(Assinante a) {
		lista.add(a);
	}
	public void remover(Assinante a) {
		lista.remove(a);
	}
	public void publicar(String assunto) {
		for(Assinante a : lista) {
			String texto = 
				String.format("%s elaborado por %s",	assunto, nome);
			a.receberNoticia(texto);
		}
	}
}
