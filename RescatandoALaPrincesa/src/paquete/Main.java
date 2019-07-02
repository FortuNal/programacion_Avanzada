package paquete;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		RescatandoPrincesa rescate=new RescatandoPrincesa("C:\\Users\\PC\\workspace\\RescatandoALaPrincesa\\src\\paquete\\entrada.in");
		//rescate.mostrarMatriz();
		rescate.dijkstra();
	}

}
