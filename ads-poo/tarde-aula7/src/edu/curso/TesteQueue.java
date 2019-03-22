package edu.curso;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TesteQueue {

	public static void main(String[] args) {
		Queue<Aluno> fila = new PriorityQueue<>();
		fila.add( new Aluno("888", "Isaac", 21) );
		fila.add( new Aluno("777", "Matuzalem", 25) );
		
		// System.out.println(fila.poll());
		// System.out.println(fila.poll()); 
		
		List<Aluno> alunos = new ArrayList<>();
		alunos.addAll(fila);
		for(Aluno a : alunos) { 
			System.out.println(a);
		}
	}

}
