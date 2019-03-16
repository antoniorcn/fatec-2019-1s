package edu.curso;

public class DonaMaria implements Faxineira{
	@Override
	public void varrer() {
		System.out.println("Dona Maria varrendo");	
	}
	@Override
	public void passePano() {
		System.out.println("Dona Maria passando o pano");
	}
	@Override
	public void encerar() {
		System.out.println("Dona Maria encerando");
	}
	@Override
	public void baterPonto() {
		System.out.println("Dona Maria batendo o ponto");
		
	}
}
