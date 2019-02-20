package edu.curso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Servidor {
	public Servidor() { 
		try {
			System.out.println("Servidor Socket Iniciado");
			ServerSocket srv = new ServerSocket(4000);
			System.out.println("Porta 4000 reservada");
			System.out.println("Aguardando conexão do cliente");
			Socket cliente = srv.accept();
			System.out.println("Cliente foi conectado com sucecsso");
			OutputStream out = cliente.getOutputStream();
			out.write("Bem vindo ao servidor\n".getBytes());
			out.flush();
			boolean sair = false;
			InputStream in = cliente.getInputStream();
			InputStreamReader inr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inr);
			String linha = "";
			while(!"sair".equalsIgnoreCase(linha)) {
				//if(in.available() > 0) { 
				//	int i = in.read();
				//	System.out.print((char)i);
				//}
				if (br.ready()) { 
					linha = br.readLine();
					System.out.println(linha);
				}
			}
			cliente.close();
			srv.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Fim do programa");
	}
	public static void main(String[] args) {
		new Servidor();
	}
}
