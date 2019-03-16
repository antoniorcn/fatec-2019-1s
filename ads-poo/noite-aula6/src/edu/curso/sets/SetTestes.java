package edu.curso.sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTestes {

	public static void main(String[] args) {
		Set<Carro> hashSet = new HashSet<>();
		
		Carro c1 = new Carro(2017, "Civic");
		Carro c2 = new Carro(2018, "Corolla");
		Carro c3 = new Carro(2005, "Fiesta");
		
		hashSet.add(c1);
		hashSet.add(c2);
		hashSet.add(c3);
		
		//hashSet.add("Antonio");
		//hashSet.add(6);
		//hashSet.add(new Date());
		//hashSet.add(args);
		//if (hashSet.contains(6)) { 
		//	System.out.println("Contem o numero 6");
		//} else { 
		//	System.out.println("Não Contem o numero 6");
		//}
		Iterator<Carro> it = hashSet.iterator();
		while (it.hasNext()) { 
			Carro o = it.next();
			System.out.println( o.ano + " - " + o.modelo);
		}
	}
}
