package edu.curso;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
public class Cliente {
	private int porta = 3000;
	private String urlServidor = "127.0.0.1";
	public Cliente() { 
		try {
			System.out.println("Cliente iniciado");
			Socket soc = new Socket(urlServidor, porta);
			System.out.println("Cliente conectado no servidor");
			InputStream in = soc.getInputStream();
			InputStreamReader inr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inr);
			String linha = "";
			while (!"sair".equals(linha)) { 
				if (br.ready()) { 
					linha = br.readLine();
					System.out.println(linha);
				}
			}
			soc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Cliente();
	}
}
