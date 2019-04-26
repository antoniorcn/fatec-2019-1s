package edu.curso.entidade;

import java.util.Date;

public class Personagem {
	private long id;
	private String nome;
	private float altura;
	private float forca;
	private String habilidade;
	private boolean doMal;
	private Date nascimento;
	
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
	
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	public float getForca() {
		return forca;
	}
	public void setForca(float forca) {
		this.forca = forca;
	}
	
	public String getHabilidade() {
		return habilidade;
	}
	public void setHabilidade(String habilidade) {
		this.habilidade = habilidade;
	}
	
	public boolean isDoMal() {
		return doMal;
	}
	public void setDoMal(boolean doMal) {
		this.doMal = doMal;
	}
	
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	
	@Override
	public String toString() { 
		return this.nome + " - " +
				(this.doMal ? "Vilão" : "Herói") + " - " + this.forca; 
	}
}
