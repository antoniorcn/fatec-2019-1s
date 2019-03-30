package edu.curso;

import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;

public class TesteJSON {
	class Layer { 
		int[] data;
		String name;
	}
	
	class Tiles { 
		String orientation;
		int tileheight;
		int tilewidth;
		int version;
		int width;
		int height;
		Layer[] layers;
	}
	
	public TesteJSON() { 
		InputStream is = getClass().getResourceAsStream("/teste.json");
		InputStreamReader re = new InputStreamReader(is);
		Gson gson = new Gson();
		Tiles t = gson.fromJson(re, Tiles.class);
		System.out.println(t.orientation);
		for (int i : t.layers[0].data) {
			System.out.print( i + ", " );
		}
	}
	public static void main(String[] args) {
		new TesteJSON();
	}
}
