package edu.curso;

import java.util.Comparator;

public class Carro implements Comparable<Carro>{
	public int ano;
	public String modelo;
	public Carro(int ano, String modelo) {
		this.ano = ano;
		this.modelo = modelo; 
		
	}
	

	@Override
	public String toString() { 
		return this.ano + " - " + this.modelo;
	}

	@Override
	public int compareTo(Carro c) {
		return this.ano - c.ano;
	}
}
