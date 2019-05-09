package edu.curso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ConfigTeste {
	@Bean
	public Pessoa geraPessoa() { 
		return new Pessoa();
	}
}
