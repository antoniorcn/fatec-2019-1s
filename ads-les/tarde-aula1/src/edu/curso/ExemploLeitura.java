package edu.curso;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class ExemploLeitura {
	public static void main(String[] args) {
		File f = new File("C:/temp/texto.txt");
		System.out.printf("Abrindo o arquivo %s para leitura \n", 
					f.getName());
		System.out.printf("Existe o arquivo: %b \n", f.exists());
		
		System.out.printf("Arquivo: %b \n", f.isFile());
		System.out.printf("Diretorio: %b \n", f.isDirectory());
		System.out.println("Conteudo:");
		try {
			FileReader fr = new FileReader(f);
			int n = 0;
			while ((n = fr.read()) != -1) {
				System.out.print( (char)n );
			}		
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
