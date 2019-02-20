package edu.curso;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	private int porta = 3000;
	public Servidor() { 
		System.out.println("Servidor socket iniciado");
		try {
			ServerSocket srv = new ServerSocket(porta);
			System.out.printf("Porta %d reservada\n", porta);
			System.out.println("Aguardando conexão do cliente");
			Socket cliente = srv.accept();
			System.out.printf("Cliente %s conectado\n", 
					cliente.getInetAddress().getHostName());
			OutputStream out = cliente.getOutputStream();
			byte[] welcome = 
					"Ola bem vindo ao servidor de Socket Java\n\r".getBytes();
			out.write(welcome);
			InputStream in = cliente.getInputStream();
			//boolean sair = false;
			InputStream inKbd = System.in;
			InputStreamReader inr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inr);
			String linha = "";
			while (!"sair".equalsIgnoreCase(linha)) {
			// while(!sair) { 
				if (inKbd.available() > 0) { 
					int i = inKbd.read();
					out.write(i);
				}
				/*if (in.available() > 0) {
					int i = in.read();
					if (i == 27) { 
						sair = true;
					} else { 
						System.out.print((char)i);
					}
				}*/
				if (br.ready()) { 
					linha = br.readLine();
					System.out.println(linha);
				}
			}
			srv.close();
		} catch (IOException e) {
			System.out.println("Erro ao iniciar o servidor");
			e.printStackTrace();
		}
		System.out.println("Fim do programa Servidor");
	}
	public static void main(String args[]) { 
		new Servidor();
	}
}
