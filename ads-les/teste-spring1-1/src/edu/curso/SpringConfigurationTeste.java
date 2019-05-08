package edu.curso;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfigurationTeste {
	@Bean
	public Pessoa pessoa() { 
		return new Pessoa();
	}
}
