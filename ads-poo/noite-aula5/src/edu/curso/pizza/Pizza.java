package edu.curso.pizza;

public abstract class Pizza {
	
	public void preparaMassa() { 
		System.out.println("Preparando a massa da mesma forma");
	}
	
	public abstract void colocarIngredientes();
	
	public abstract void assarPizza();

}
