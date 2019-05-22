package edu.curso;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Contato implements Serializable{
	private static final long serialVersionUID = -1L;
	private String nome;
	private String telefone;
	private String email;
	
	@Id
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() { 
		return getNome() + " - " + getTelefone();
	}
}
