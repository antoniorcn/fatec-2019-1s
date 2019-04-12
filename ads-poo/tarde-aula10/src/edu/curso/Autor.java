package edu.curso;
import java.util.Date;
public interface Autor {
	void adicionar(Seguidor s);
	void remover(Seguidor s);
	void publicar(String msg, Date d);
}
