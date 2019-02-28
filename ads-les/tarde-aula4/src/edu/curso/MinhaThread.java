package edu.curso;
public class MinhaThread extends Thread {
	private String nome;
	public MinhaThread(String nome) {
		this.nome = nome; 
	}
	@Override
	public void run() { 
		int i = 0;
		while (true) { 
			System.out.println(nome + " - " + i);
			i = i + 1;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		MinhaThread t1 = new MinhaThread("Thread A");
		t1.setPriority(MIN_PRIORITY);
		t1.start();	
		MinhaThread t2 = new MinhaThread("Thread B");
		t2.setPriority(MAX_PRIORITY);
		t2.start();
		MinhaThread t3 = new MinhaThread("Thread C");
		t3.setPriority(NORM_PRIORITY);
		t3.start();
	}
}
