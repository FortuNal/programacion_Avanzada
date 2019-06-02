package paquete;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeMap;

public class Kmaspequeño {

	public static void main(String[] args) throws IOException {
		
		///DEFINICION DE VARIABLES
		int cantNumeros=0;
		int valoresBuscados=0;
		TreeMap<Integer,Integer> numeros=new TreeMap<Integer,Integer>();

		/// ARCHIVOS DE ENTRADA Y SALIDA
		String path = "C:\\Users\\PC\\workspace\\Kmaspequeños\\src\\paquete\\numeros.in";
		PrintWriter solucion = new PrintWriter(
				new FileWriter("C:\\Users\\PC\\workspace\\Kmaspequeños\\src\\paquete\\numeros.out"));
		Scanner sc = new Scanner(new File(path));
				
		/// LECTURA DE ENTRADA
		cantNumeros = sc.nextInt();
		valoresBuscados = sc.nextInt();

		for (int i = 0; i < cantNumeros; i++) {
			Integer linea = sc.nextInt();
			numeros.put(linea, i);
		}
		sc.close();
		
		/// ESCRIBO LOS MENORES EN EL ARCHIVO DE SALIDA
		solucion.println(valoresBuscados);
		for (int j = 0; j < valoresBuscados; j++) {
			java.util.Map.Entry<Integer, Integer> ordenado=numeros.pollFirstEntry();
			solucion.println(ordenado.getKey());

		}

		solucion.close();
		
	}

}
