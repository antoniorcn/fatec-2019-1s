package edu.curso;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Planeta implements Serializable {
	private static final long serialVersionUID = -7532333605533814019L;
	private long id;
	private String nome;
	private float distanciaSol;
	private double tamanho;
	private int qtdLuas;
	private Date descoberto;
	
	@Id
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
	
	public float getDistanciaSol() {
		return distanciaSol;
	}
	public void setDistanciaSol(float distanciaSol) {
		this.distanciaSol = distanciaSol;
	}
	
	public double getTamanho() {
		return tamanho;
	}
	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}
	
	public int getQtdLuas() {
		return qtdLuas;
	}
	public void setQtdLuas(int qtdLuas) {
		this.qtdLuas = qtdLuas;
	}
	
	public Date getDescoberto() {
		return descoberto;
	}
	public void setDescoberto(Date descoberto) {
		this.descoberto = descoberto;
	}
}
