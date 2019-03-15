package edu.curso;

public class LimpaTudo implements Faxineira, Lavador {
	@Override
	public void varrer() {
		System.out.println("Limpa Tudo varrendo");
	}
	@Override
	public void passePano() {
		System.out.println("Limpa Tudo passando o pano");
	}
	@Override
	public void encerar() {
		System.out.println("Limpa Tudo encerando");
	}
	@Override
	public void enxaguar() {
		System.out.println("Limpa Tudo exaguando");
	}
	@Override
	public void passarEspuma() {
		System.out.println("Limpa Tudo passando espuma");
	}
	@Override
	public void aspirar() {
		System.out.println("Limpa Tudo aspirando");
	}
	@Override
	public void baterPonto() {
		System.out.println("Limpa Tudo bater ponto");
	}
}
