package edu.curso;

public class MeuJob implements Runnable {
	private static int count = 0;
	private String nome;
	public MeuJob(String nome) {
		this.nome = nome;
	}
	public synchronized void countGrow() { 
		if (count < 3) { 
			count++;
		} else if (count >= 0){ 
			count--;
		}
	}
	@Override
	public void run() { 
		int i = 0;
		while (true) { 
			countGrow();
			System.out.println(nome + " - " + count);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
	public static void main(String[] args) {
		MeuJob j1 = new MeuJob("Job 1");
		Thread t1 = new Thread(j1);
		t1.start();
		MeuJob j2 = new MeuJob("Job 2");
		Thread t2 = new Thread(j2);
		t2.start();
		MeuJob j3 = new MeuJob("Job 3");
		Thread t3 = new Thread(j3);
		t3.start();
	}
}
