package paquetito;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class modificarArchivo {
	
	public static void main(String[] args) throws IOException {
		
		String Origen="C:\\Users\\PC\\workspace\\ModificarArchivo\\src\\paquetito\\Archivo";
		String Destino="C:\\Users\\PC\\workspace\\ModificarArchivo\\src\\paquetito\\Salida.txt";
		String Palabra="kit";
		String PalabraAReemplazar="set";
		reemplazar(Origen,Destino,Palabra,PalabraAReemplazar);
	
	}
	
	public static void reemplazar(String archivoOrigen, String archivoDestino, String palabraAReemplazar, String nuevaPalabra) throws IOException{
	
		boolean resultado;
		String texto;
		
		Scanner sc = new Scanner(new File(archivoOrigen));
		FileWriter writer = new FileWriter(archivoDestino);
		sc.useLocale(Locale.ENGLISH);
		while(sc.hasNextLine()) {
			texto=texto=sc.nextLine();
            resultado=texto.contains(palabraAReemplazar);
            if(resultado)
            	texto.replaceAll(palabraAReemplazar, nuevaPalabra);
            writer.write(texto);
            writer.close();
        }
        sc.close();
	}


}
