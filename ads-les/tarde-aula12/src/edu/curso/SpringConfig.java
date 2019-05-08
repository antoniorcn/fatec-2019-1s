package edu.curso;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration 
public class SpringConfig {
	@Bean
	public Pessoa novaPessoa() { 
		return new Pessoa();
	}
}
