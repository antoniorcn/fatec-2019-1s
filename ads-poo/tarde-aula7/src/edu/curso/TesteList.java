package edu.curso;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class TesteList {
	public static void main(String[] args) {
		Set<Aluno> vogais = new HashSet<>();
		vogais.add( new Aluno("111", "Joao", 17) );
		vogais.add( new Aluno("222", "Maria", 18) );
		vogais.add( new Aluno("333", "Jose", 16) );
		vogais.add( new Aluno("444", "Pedro", 19) );
		vogais.add( new Aluno("555", "Antonio", 20) );
		List<Aluno> lista = new Stack<>();
		lista.add( new Aluno("888", "Isaac", 21) );
		lista.add( new Aluno("777", "Matuzalem", 25) );
		lista.addAll(vogais);	
		Collections.sort(lista);
		for (Aluno item : lista) { 
			System.out.println(item);
		}
	}
}
