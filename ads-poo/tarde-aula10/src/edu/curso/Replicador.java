package edu.curso;
import java.util.Date;
public class Replicador implements Seguidor {
	private String nome;
	public Replicador(String nome) {
		this.nome = nome;
	}
	@Override
	public void receberNotificacao(String msg, Date date) {
		System.out.printf(
			"Eu %s recebi este post no dia %tB %<te, de %<tY as %<tT:%<Tp e "
			+ "estou divulgando para todos a mensagem %s\n", nome, date, msg);
	}
}
