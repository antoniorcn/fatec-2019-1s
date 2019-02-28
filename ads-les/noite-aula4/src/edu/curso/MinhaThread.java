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
			System.out.println(nome + "-" + i++);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		MinhaThread t1 = new MinhaThread("A");
		t1.start();
		MinhaThread t2 = new MinhaThread("B");
		t2.start();		
	}
}
