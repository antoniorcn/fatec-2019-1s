package ed.curso.teste;

import java.util.Date;

import ed.curso.entidade.Agenda;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class TesteProperty {

	public static void main(String[] args) {
		Agenda a = new Agenda();
		
		ChangeListener<Number> change = new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number antigo, Number novo) {
				System.out.println("Valor Antigo: " + antigo.longValue());
				System.out.println("Valor Novo: " + novo.longValue());
			} 
		};
		
		a.getNascimentoProperty().addListener(change);
		
		a.setNascimento(new Date());
		a.setNascimento(new Date());
		
		System.out.println(a.getNascimento());
	}

}
