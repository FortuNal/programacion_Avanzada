package paquete;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		ColoreoSinOrdenar grafo1=new ColoreoSinOrdenar("C:\\Users\\PC\\workspace\\Algoritmos\\src\\paquete\\");
		grafo1.colorearGrafo();
		grafo1.grabarArchivo("C:\\Users\\PC\\workspace\\Algoritmos\\src\\paquete\\");
	}

}
