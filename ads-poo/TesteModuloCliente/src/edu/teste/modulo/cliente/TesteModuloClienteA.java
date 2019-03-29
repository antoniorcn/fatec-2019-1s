package edu.teste.modulo.cliente;
import edu.teste.modulo.TesteA;
import edu.teste.modulo2.TesteB;
public class TesteModuloClienteA {
	public static void main(String[] args) {
		TesteA a = new TesteA();
		a.fazAlgo();
		TesteB b = new TesteB();
		b.fazAlgo();
	}
}
