package tenis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Compotera {

	public int n, s, j, d;
	public int setsA,setsB;
	public char[] lineaDeJuego;

	public Compotera(String path) throws FileNotFoundException {
		leerArchivo(path);

	}

	public void leerArchivo(String path) throws FileNotFoundException {

		Scanner sc = new Scanner(new File(path));
		sc.useLocale(Locale.ENGLISH);
		this.n = sc.nextInt();
		this.s = sc.nextInt();
		this.j = sc.nextInt();
		this.d = sc.nextInt();

		this.lineaDeJuego = sc.next().toCharArray();
	}
	
	public void iniciarSet(){
		this.setsA=0;
		this.setsB=0;
	}
	
	public void escribirArchivo(String path) throws IOException {

		PrintWriter salida = new PrintWriter(new FileWriter(path+"resultado.out"));
		salida.print(this.setsA+" "+this.setsB);
		salida.close();
	}


	public void resolverJuego(Compotera c1) {
		int jA = 0, jB = 0;
		for (int i = 0; i < c1.n; i++) {

			if (c1.lineaDeJuego[i] == 'A')
				jA++;
			if (c1.lineaDeJuego[i] == 'B')
				jB++;

			if ((jA >= c1.j) && ((jA - jB) >= c1.d)) {
				this.setsA++;
				jA = 0;
				jB = 0;
			}//if((jA == c1.j) && ((jA - jB) == c1.d))

			if ((jB >= c1.j) && ((jB - jA) >= c1.d)) {
				this.setsB++;
				jB = 0;
				jA = 0;

			}// if((jB == c1.j) && ((jA - jB) == c1.d)) 

			
		}//	for (int i = 0; i < c1.n; i++) 

	}//public void resolverJuego(Compotera c1)

}//public class Compotera {
