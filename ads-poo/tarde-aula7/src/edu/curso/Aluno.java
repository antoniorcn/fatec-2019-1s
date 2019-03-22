package edu.curso;

public class Aluno implements Comparable<Aluno>{
	private String ra;
	private String nome;
	private int idade;
	
	public Aluno(String ra, String nome, int idade) {
		this.ra = ra;
		this.nome = nome;
		this.idade = idade;
	}
	
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	@Override
	public int compareTo(Aluno a) {
		if (this.idade > a.getIdade()) { 
			return -1;
		} else if (this.idade < a.getIdade()) {
			return 1;
		} else {
			return 0;
		}
		//return this.getNome().compareTo(a.getNome());
	}
	
	@Override
	public String toString() { 
		return this.ra + " - " + this.nome + " - " + this.idade;
	}

}
