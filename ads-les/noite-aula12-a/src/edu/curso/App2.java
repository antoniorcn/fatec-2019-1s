package edu.curso;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App2 {
	public static void main(String[] args) {
		System.out.println("Spring Beans");
		ApplicationContext app = 
				new FileSystemXmlApplicationContext("/src/beans.xml");
		// Pessoa p = (Pessoa)app.getBean("pessoa");
		Pessoa p = app.getBean("pessoa", Pessoa.class);
		p.falar();
	}
}
