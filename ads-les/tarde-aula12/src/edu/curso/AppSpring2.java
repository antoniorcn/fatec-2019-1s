package edu.curso;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class AppSpring2 {
	public static void main(String[] args) {
		System.out.println("Spring App sem XML");
		ApplicationContext app = new 
				AnnotationConfigApplicationContext(SpringConfig.class);
		Pessoa p = app.getBean("novaPessoa", Pessoa.class);
		p.falar();
	}
}
