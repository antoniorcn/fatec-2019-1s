package edu.curso;
import java.net.URL;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
public class AppSpring {
	public static void main(String[] args) {
		System.out.println("Teste Spring");
		URL r = AppSpring.class.getResource("./beans.xml");
		System.out.println("Path: " + r.getPath());
		ApplicationContext app 
			= new FileSystemXmlApplicationContext(r.getPath());
		Pessoa p = app.getBean("pessoa", Pessoa.class);
		p.falar();
	}
}
