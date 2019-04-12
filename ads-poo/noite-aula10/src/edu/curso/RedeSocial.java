package edu.curso;

import java.util.Random;

public class RedeSocial {
	public static void main(String[] args) {
		Pensador ponde = new Pensador("Ponde");
		Pensador karnal = new Pensador("Leandro Karnal");
		Pensador fabio = new Pensador("Fabio Assunção");
		Pessoa maria = new Pessoa("Dona Maria");
		Pessoa joao = new Pessoa("João Pires");
		Pessoa jailson = new Pessoa("Jailson Mendes");
		Pessoa clovis = new Pessoa("Clóvis Basílio");
		Random rnd = new Random();
		ponde.adicionar(maria);
		ponde.adicionar(joao);
		karnal.adicionar(jailson);
		karnal.adicionar(maria);
		fabio.adicionar(clovis);
		if (rnd.nextBoolean()) { 
			fabio.adicionar(maria);
		}
		fabio.adicionar(joao);
		karnal.publicar("Previdência para todos");
		ponde.publicar("Reforma da previdência já");
		fabio.publicar("Ja é hora de beber?");
	}

}
