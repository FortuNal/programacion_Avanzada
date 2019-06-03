package paquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class averiguarCebador {
	
	
	public int cantOias;
	public int[]pasajes;
	ArrayList<Integer>oias;
	int[] noCeban;

	public averiguarCebador(String path) throws FileNotFoundException{
		leerArchivo(path);
		oias=new ArrayList<Integer>();
		for (int i = 1; i <= this.cantOias; i++) {
			this.oias.add(i);
		}
		noCeban = new int[this.cantOias-1];
	}

	public void leerArchivo(String path) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File(path));
		sc.useLocale(Locale.ENGLISH);
		
		this.cantOias = sc.nextInt();
	    this.pasajes = new int[this.cantOias-1];
	    
		for (int i = 0; i < this.cantOias-1; i++){
			
			this.pasajes[i] = sc.nextInt();
			
		}
		sc.close();
		
	}
	
	public void escribirArchivo(Integer cebador) throws IOException {
		
		String path = "C:\\Users\\PC\\workspace\\AventurerosMateros\\src\\paquete\\solucion.out";
		PrintWriter s = new PrintWriter(new FileWriter(path));
		
		for (int i = 0; i < this.cantOias - 1; i++) {
			
			s.print(this.noCeban[i] + " ");
			
		}
		s.println(" ");
		s.println(cebador);
		s.close();
		
	}

	public void quienCeba() throws IOException{
		int posEliminar = 0;
		int indice=0;
		
		while(this.oias.size()!=1){
			
			posEliminar = (int) ((posEliminar + this.pasajes[indice]) % this.cantOias);
			this.noCeban[indice] = oias.get(posEliminar);
			oias.remove(posEliminar);
			indice++;
			
		}
		
		escribirArchivo(oias.get(0));
	}

}


