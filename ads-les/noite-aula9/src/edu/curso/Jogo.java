package edu.curso;

import java.io.Serializable;
import java.util.Date;

public class Jogo implements Serializable {
	private static final long serialVersionUID = 5342902659347926787L;
	private long id;
	private String nome = "";
	private String genero = "";
	private float preco;
	private Date lancamento = new Date();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public Date getLancamento() {
		return lancamento;
	}
	public void setLancamento(Date lancamento) {
		this.lancamento = lancamento;
	}
}
