package edu.curso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class TesteList {
	public static void main(String[] args) {
		List<Carro> lista = new ArrayList<>();
		lista.add(new Carro(2008, "Civic"));
		lista.add(new Carro(2010, "Toyota Corolla"));
		lista.add(new Carro(2005, "Uno"));
		lista.add(new Carro(2012, "Celta"));
		lista.add(new Carro(2018, "Porsche"));
		lista.add(new Carro(2019, "Virtus"));
		Collections.sort(lista);
		for (Carro o : lista) { 
			System.out.println(o);
		}
	}
}
