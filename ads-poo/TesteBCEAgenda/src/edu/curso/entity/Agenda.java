package edu.curso.entity;

import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;

public class Agenda {
	private String nome;
	private String telefone;
	private LongProperty nascimento = new SimpleLongProperty(0);
	
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
	
	public Date getNascimento() {
		return new Date(nascimento.get());
	}
	public void setNascimento(Date nascimento) {
		this.nascimento.set(nascimento.getTime());
	}
	public LongProperty getNascimentoProperty() { 
		return this.nascimento;
	}
	
}
