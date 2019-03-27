package edu.curso.consumo;
import java.util.Iterator;
import java.util.ServiceLoader;
import edu.curso.ServicoA;
public class UserServicoA {
	public static void main(String[] args) {
		ServiceLoader<ServicoA> a = ServiceLoader.load(ServicoA.class);
		Iterator<ServicoA> it = a.iterator();
		while (it.hasNext()) { 
			ServicoA srva = it.next();
			srva.fazAlgo("Teste de Texto");
		}
	}
}
