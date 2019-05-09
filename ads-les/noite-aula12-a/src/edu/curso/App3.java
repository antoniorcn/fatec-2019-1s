package edu.curso;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App3 {
	public static void main(String[] args) {
		ApplicationContext app = 
			new AnnotationConfigApplicationContext(ConfigTeste.class);
		Pessoa p = app.getBean("geraPessoa", Pessoa.class);
		p.falar();
	}
}
