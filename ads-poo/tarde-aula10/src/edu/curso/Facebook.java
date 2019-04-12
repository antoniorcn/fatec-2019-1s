package edu.curso;
import java.util.Date;
import java.util.Random;
public class Facebook {
	public static void main(String[] args) {
		Seguidor tiaMaria = new Replicador("Tia Maria");
		Seguidor tioJose = new Replicador("Tio Jose");
		Seguidor jogador1 = new Replicador("Fallen");
		Seguidor jogador2 = new Replicador("Coldzera");
		Publicador diana = new Publicador("Diana Zambro");
		Publicador esquerda = new Publicador("Leandro Karnal");
		Publicador direita = new Publicador("Stephen Kanitz");
		diana.adicionar(jogador1);
		diana.adicionar(jogador2);
		Random random = new Random();
		if (random.nextBoolean()) { 
			diana.adicionar(tiaMaria);
		}
		esquerda.adicionar(tioJose);
		direita.adicionar(tiaMaria);
		diana.publicar("Lançou novo game dos vingadores", new Date());
		esquerda.publicar("Caiu o ministro da educação", new Date());
		direita.publicar("Bolsonaro vai a Israel", new Date());
	}
}
