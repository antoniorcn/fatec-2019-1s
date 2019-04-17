package edu.curso;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Aluno implements Serializable {
	private static final long serialVersionUID = 6255529542545480189L;
	private long id;
	private String ra;
	private String nome;
	private Date nascimento;
	
	@Id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	
	@Override
	public String toString() {
		return String.format("ID:%d  Nome: %s  RA: %s", id, nome, ra);
	}
}
