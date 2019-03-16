package edu.curso.pizza;

import java.util.Scanner;

public class Pizzaria {

	public static void main(String[] args) {
		
		System.out.println("Pizza");
		System.out.println("Qual pizza vc deseja ? (C)alabresa Normal (T)oscana");
		Scanner scan = new Scanner(System.in);
		String strPizza = scan.nextLine();
		
		Pizza p1 = null;
		
		if (strPizza.charAt(0) == 'C') {
			p1 = new PizzaCalabresaNormal();	
		} else if (strPizza.charAt(0) == 'T') {
			p1 = new PizzaCalabresaToscana();
		}
		
		p1.preparaMassa();
		p1.colocarIngredientes();
		p1.assarPizza();
		
		scan.close();
		
	}

}
