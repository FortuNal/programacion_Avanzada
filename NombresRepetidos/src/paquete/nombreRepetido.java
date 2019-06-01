package paquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.KeyStore.Entry;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class nombreRepetido {

	public static void main(String[] args) throws IOException {
		
		///DEFINICION DE VARIABLES
		int cantExploradores=0;
		int cantRepetidos=0;
		TreeMap<String, Integer> exploradores = new TreeMap<String, Integer>();
		TreeMap<Integer, String> mapSalida = new TreeMap<Integer, String>();
		
		///ARCHIVOS DE ENTRADA Y SALIDA
		String path="C:\\Users\\PC\\workspace\\NombresRepetidos\\src\\paquete\\nombres.in";
		PrintWriter solucion = new PrintWriter(new FileWriter("C:\\Users\\PC\\workspace\\NombresRepetidos\\src\\paquete\\resultados.out")); 
		Scanner sc = new Scanner(new File(path));
		
		///LECTURA DE ENTRADA
		cantExploradores=sc.nextInt();
		cantRepetidos=sc.nextInt();
		
		for(int i=0 ; i<cantExploradores ; i++) {
			String linea = sc.next();
			if(exploradores.containsKey(linea)){
				Integer rep = exploradores.get(linea);
				exploradores.put(linea, rep+1);	
			}				
			else
				exploradores.put(linea, 1);	
		}
		sc.close();
		
		///EL TREEMAP EXPLORADORES ESTA ORDENADO POR NOMBRE, ASI QUE LO INVIERTO
		for(Map.Entry<String,Integer> entry : exploradores.entrySet()) {
			  mapSalida.put(entry.getValue(), entry.getKey());
			}
		
		///ESCRIBO LOS MAS REPETIDOS EN EL ARCHIVO DE SALIDA
		for(int j=0; j<cantRepetidos;j++){
			java.util.Map.Entry<Integer, String> ordenado=mapSalida.pollLastEntry();
			solucion.println(ordenado.getValue()+" "+ordenado.getKey());

		}

		solucion.close();

	}

}
