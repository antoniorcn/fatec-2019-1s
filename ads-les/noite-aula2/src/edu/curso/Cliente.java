package edu.curso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente {
	private int porta = 4000;
	private String servidorUrl = "localhost";
	public Cliente() { 
		try {
			Socket srv = new Socket(servidorUrl, porta);
			InputStream in = srv.getInputStream();
			OutputStream out = srv.getOutputStream();
			
			InputStream kbdIn = System.in;
			InputStreamReader kbdInr = new InputStreamReader(kbdIn);
			BufferedReader kbdBr = new BufferedReader(kbdInr);
			boolean sair = false;
			while (!sair) { 
				if (kbdBr.ready()) { 
					String linhaKbd = kbdBr.readLine();
					out.write(linhaKbd.getBytes());
					out.write("\n".getBytes());
					out.flush();
				}
				if (in.available() > 0) { 
					int i = in.read();
					System.out.print((char)i);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	public static void main(String[] args) {
		new Cliente();
	}
}
