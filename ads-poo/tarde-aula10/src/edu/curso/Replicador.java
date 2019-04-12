package edu.curso;
import java.util.Date;
public class Replicador implements Seguidor {
	@Override
	public void receberNotificacao(String msg, Date date) {
		System.out.printf(
			"Recebi este post no dia %tB %<te,  %<tY  %<tT %<Tp e "
			+ "estou divulgando para todos a mensagem %s", date, msg);
	}
}
