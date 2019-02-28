package edu.curso;

public class Job implements Runnable {
	private String nome;
	public Job(String nome) { 
		this.nome = nome;
	}
	@Override
	public void run() {
		int i = 0;
		while(true) {
			System.out.println(nome + "-" + i++);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Job j1 = new Job("A");
		Thread t1 = new Thread(j1);
		t1.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		
		Job j2 = new Job("B");
		Thread t2 = new Thread(j2);
		t2.setPriority(Thread.NORM_PRIORITY);
		t2.start();
		
		Job j3 = new Job("C");
		Thread t3 = new Thread(j3);
		t3.setPriority(Thread.MAX_PRIORITY);
		t3.start();
	}
}
