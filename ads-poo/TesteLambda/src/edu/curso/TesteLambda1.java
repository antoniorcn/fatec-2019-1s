package edu.curso;

public class TesteLambda1 {
	
	public int calculo(Matematica m) { 
		return m.calcula(10, 20);
	}
	
	public static void main(String ... args) {
		TesteLambda1 tl = new TesteLambda1();
		int r1 = tl.calculo((int x, int y)->x + y);
		System.out.println("R1: " + r1);
		int r2 = tl.calculo((int x, int y)-> {
			System.out.println("X: " + x);
			System.out.println("Y: " + y);
			return x * y;
		});
		System.out.println("R2: " + r2);
		
	}

}
