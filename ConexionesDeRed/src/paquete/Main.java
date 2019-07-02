package paquete;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		VerificacionConexion red=new VerificacionConexion("C:\\Users\\PC\\workspace\\ConexionesDeRed\\src\\paquete\\entrada.in",25);
		red.mostrarRespuestas();
	}

}
