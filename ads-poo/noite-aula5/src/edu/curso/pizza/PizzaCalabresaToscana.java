package edu.curso.pizza;

public class PizzaCalabresaToscana extends PizzaCalabresa {
	@Override
	public void colocarIngredientes() {
		super.colocarIngredientes();
		System.out.println("Colocar queijo");
	}

	@Override
	public void assarPizza() {
		System.out.println("Colocar no forno 15 minutos");
	}
}
