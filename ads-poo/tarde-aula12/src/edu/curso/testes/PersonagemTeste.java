package edu.curso.testes;

import java.util.Calendar;
import java.util.Date;

import edu.curso.entidade.Personagem;

public class PersonagemTeste {

	public static void main(String[] args) {
		Personagem thanos = new Personagem();
		thanos.setId(1l);
		thanos.setNome("Thanos");
		thanos.setAltura(4.2f);
		thanos.setForca(89.0f);
		thanos.setDoMal(true);
		thanos.setHabilidade("Todas");
		Calendar cal = Calendar.getInstance();
		cal.set(1900, 8, 15);
		thanos.setNascimento(cal.getTime());
		Date d = new Date();
		
		System.out.println( thanos );

	}

}
