package edu.curso;

public class Pessoa implements Assinante {
	private String nome;
	public Pessoa(String nome) {
		this.nome = nome; 
	}
	@Override
	public void receberNoticia(String assunto) {
		System.out.printf("Eu %s li o texto %s \n", nome, assunto);
	}
}
