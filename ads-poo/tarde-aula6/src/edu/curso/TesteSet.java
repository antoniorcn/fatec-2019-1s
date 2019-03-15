package edu.curso;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
public class TesteSet {
	private abstract class Aluno {
		public String ra;
		public String nome;
		public Aluno(String v1, String nome) {
			this.ra = v1;
			this.nome = nome;
		}
		
		public abstract void estudar();
	}
	
	private class AlunoFatec extends Aluno {
		public AlunoFatec(String v1, String nome) { 
			super(v1, nome);
		}
		@Override
		public void estudar() {
			System.out.println("Aluno da Fatec Estudando");
		} 
	}
	public TesteSet() { 
		Set<Aluno> hash = new HashSet<>();
		Aluno a1 = new AlunoFatec("111", "Joao");
		Aluno a2 = new AlunoFatec("222", "Pedro");
		Aluno a3 = new AlunoFatec("333", "Maria");
		Aluno a4 = new AlunoFatec("444", "Antonio");
		hash.add(a1);
		hash.add(a2);
		hash.add(a3);
		System.out.println("Objetos adicionados no Hashset");
		if (hash.contains( a3 )) { 
			System.out.println("O hash contem o objeto " + a3.nome);
		} else { 
			System.out.println("O hash NÃO contem o objeto " + a3.nome);
		}
		Iterator<Aluno> it = hash.iterator();
		while (it.hasNext()) { 
			Aluno a = it.next();
			System.out.printf("RA: %s   Nome:%s \n", a.ra, a.nome);
			// System.out.println("RA: " + a.ra + "  Nome:" + a.nome);
		}
	}
	public static void main(String[] args) {	
		new TesteSet();
	}
}
