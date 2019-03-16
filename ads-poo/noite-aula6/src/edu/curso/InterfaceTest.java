package edu.curso;

public class InterfaceTest {
	public static void main(String[] args) {
		Fatec f = new Fatec();
		
		MaridoAluguel ricardo = new MaridoAluguel();
		DonaMaria maria1 = new DonaMaria();
		LimpaTudo limpa1 = new LimpaTudo();
		
		f.limparSalas(ricardo);
		f.limparSalas(maria1);
	}

}
