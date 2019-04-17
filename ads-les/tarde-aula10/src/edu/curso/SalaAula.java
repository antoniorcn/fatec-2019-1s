package edu.curso;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class SalaAula implements Serializable {
	private static final long serialVersionUID = 2538846510679226307L;
	private long id;
	private String numero;
	private int capacidade;
	private String disciplina;
	private List<Aluno> alunos;
	
	@Id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
	@OneToMany(targetEntity = Aluno.class, fetch=FetchType.LAZY)
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(String.format("ID:%d  Disciplina: %s", id, disciplina));
		for (Aluno a : alunos) { 
			sb.append(a.toString());
		}
		return sb.toString();
	}
}
