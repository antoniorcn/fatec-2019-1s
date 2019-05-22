package edu.curso;

public class TesteLambda2 {

	public static void main(String[] args) {
		Runnable r1 = () -> { while(true) {
								System.out.println("Thread A");
							}};
		Runnable r2 = () -> { while(true) {
								System.out.println("Thread B");
							}};
		
		Thread t1 = new Thread(r1);
		t1.start();
		Thread t2 = new Thread(r2);
		t2.start();

	}

}
