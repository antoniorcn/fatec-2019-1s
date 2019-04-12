package ed.curso.entidade;

import java.util.Date;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;

public class Agenda {
	private LongProperty nascimento = new SimpleLongProperty(0);
	
		
	public Date getNascimento() {
		return new Date(nascimento.get());
	}
	public void setNascimento(Date nascimento) {
		this.nascimento.set(nascimento.getTime());
	}
	public LongProperty getNascimentoProperty() { 
		return this.nascimento;
	}
	
}
