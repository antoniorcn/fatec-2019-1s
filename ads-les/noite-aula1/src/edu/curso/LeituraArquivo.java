package edu.curso;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeituraArquivo {

	public static void main(String[] args) {
		File f = new File("C:/Curso/nome.txt");
		System.out.printf("Abrindo arquivo %s para grava��o\n", f.getName());
		System.out.printf("Arquivo Existe: %b\n", f.exists());
		System.out.printf("Pode ler: %b\n", f.canRead());
		System.out.printf("Arquivo: %b\n", f.isFile());
		System.out.printf("Diretorio: %b\n", f.isDirectory());
		System.out.printf("Conteudo:\n");
		try {
			FileReader fr = new FileReader( f );
			int numero = 0;
			while ((numero = fr.read()) != -1) {
				System.out.print((char)numero);
			}
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
