package edu.curso;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {
//	public static void main(String ... args) {
//		Pessoa p = new Pessoa();
//		p.falar();
//	}
//}

public static void main(String[] args) {
	ApplicationContext app = 
		new FileSystemXmlApplicationContext("beans.xml");
	Pessoa p = (Pessoa)app.getBean("pessoa");
	p.falar();
}
}