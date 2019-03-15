package edu.curso;

public class MaridoAluguel implements QuebraGalho {
	@Override
	public void enxaguar() {
		System.out.println("Marido de Aluguel enxaguando");
	}
	@Override
	public void passarEspuma() {
		System.out.println("Marido de Aluguel passando espuma");
	}
	@Override
	public void aspirar() {
		System.out.println("Marido de Aluguel aspirando");
	}

	@Override
	public void baterPonto() {
		System.out.println("Marido de Aluguel batendo o ponto");		
	}

	@Override
	public void varrer() {
		System.out.println("Marido de Aluguel varrendo");		
	}

	@Override
	public void passePano() {
		System.out.println("Marido de Aluguel passando o pano");
	}

	@Override
	public void encerar() {
		System.out.println("Marido de Aluguel encerar");	
	}
}
