package edu.curso;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TesteMap {
	public static void main(String[] args) {
		Map<Integer, Carro> mapa = new HashMap<>();
		Carro c1 = new Carro(1998, "Monza");
		Carro c2 = new Carro(1982, "Opala 4 Caneco 4.1");
		Carro c3 = new Carro(2013, "Celta");
		
		mapa.put(1, c1);
		mapa.put(2, c2);
		mapa.put(3, c3);
		
//		Carro c = mapa.get(2);
//		System.out.println(c);
		
		System.out.println(mapa.containsKey(4));
		
		Set<Integer> chaves = mapa.keySet();
		
		for (Integer i : chaves) { 
			System.out.println(i);
		}
		
		Collection<Carro> values = mapa.values();
		for (Carro c : values) { 
			System.out.println(c);
		}
		
	}
}
