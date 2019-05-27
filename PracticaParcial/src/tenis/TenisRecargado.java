package tenis;


import java.io.IOException;

import tenis.Compotera;

public class TenisRecargado {

	public static void main(String[] args) throws IOException {

		String entrada = "C:\\Users\\PC\\workspace\\PracticaParcial\\src\\prehistorico.in";
		Compotera c1 = new Compotera(entrada);
		String salida = "C:\\Users\\PC\\workspace\\PracticaParcial\\src\\";
		c1.iniciarSet();
		c1.resolverJuego(c1);
		c1.escribirArchivo(salida);
	}
}
