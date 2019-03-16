package edu.curso.pizza;

public abstract class PizzaCalabresa extends Pizza {
	@Override
	public void colocarIngredientes() {
		System.out.println("Colocar molho");
		System.out.println("Colocar calabresa");
		System.out.println("Colocar cebola");
	}
}
