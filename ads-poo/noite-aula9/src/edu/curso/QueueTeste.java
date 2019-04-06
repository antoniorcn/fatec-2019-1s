package edu.curso;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTeste {
	public static void main(String[] args) {
		Queue<Carro> fila = new PriorityQueue<Carro>();
		Carro c1 = new Carro(1998, "Monza");
		Carro c2 = new Carro(1982, "Opala 4 Caneco 4.1");
		Carro c3 = new Carro(2013, "Celta");
		
		fila.add(c1);
		fila.add(c2);
		fila.add(c3);
		
		System.out.println("1o Carro a ser vendido: " + fila.poll());
		System.out.println("2o Carro a ser vendido: " + fila.poll());
		System.out.println("3o Carro a ser vendido: " + fila.poll());
		
	}
}
