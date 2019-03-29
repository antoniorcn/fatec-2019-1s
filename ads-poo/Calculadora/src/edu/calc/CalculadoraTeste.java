package edu.calc;

import edu.fisica.MRU;
import edu.math.Aritmetica;

public class CalculadoraTeste {
	public static void main(String[] args) {
		System.out.println("Teste");
 		Aritmetica a = new Aritmetica();
		a.multiplicar(10,  30);
		MRU m = new MRU();
		System.out.println(m.calcMRU(10, 20, 3));
	}
}
