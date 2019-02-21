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
			out.write("Bem vindo ao servidor\n\r".getBytes());
			out.flush();
			boolean sair = false;
			InputStream in = cliente.getInputStream();
			InputStreamReader inr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inr);
			
			InputStreamReader kbdInr = new InputStreamReader(System.in);
			BufferedReader kbdBr = new BufferedReader(kbdInr);
			String linha = "";
			while(!"sair".equalsIgnoreCase(linha)) {
				if (kbdBr.ready()) { 
					String linhaTeclado = kbdBr.readLine();
					out.write(linhaTeclado.getBytes());
					out.write("\n\r".getBytes());
					out.flush();
				}
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
