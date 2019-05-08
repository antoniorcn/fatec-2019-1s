package edu.curso;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext app = 
			new AnnotationConfigApplicationContext (SpringConfigurationTeste.class);
		Pessoa p = app.getBean("pessoa", Pessoa.class);
		p.falar();
	}
}