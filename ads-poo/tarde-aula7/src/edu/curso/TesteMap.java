package edu.curso;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TesteMap {

	public static void main(String[] args) {
		Map<String, Aluno> alunos = new HashMap<>();
		Aluno b = new Aluno("888", "Isaac", 21);
		alunos.put( "888", b );
		alunos.put( "777", new Aluno("777", "Matuzalem", 25) );
		alunos.put( "666", new Aluno("666", "Lucifer", 10000) );
		alunos.put( "555", b );
		
		Aluno a = alunos.get("666");
		System.out.println(a);
		
		Set<String> chaves = alunos.keySet();
		System.out.println("Chaves no Hashmap de alunos");
		for (String chave : chaves) { 
			System.out.println(chave);
		}
		
		Collection<Aluno> valores = alunos.values();
		System.out.println("Valores do Hashmap de alunos");
		for (Aluno aluno : valores) { 
			System.out.println(aluno);
		}
		
		System.out.println("Aluno na chave  888");
		System.out.println(alunos.get("888"));
	}

}
