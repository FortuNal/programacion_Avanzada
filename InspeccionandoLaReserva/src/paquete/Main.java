package paquete;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Reserva inspeccion=new Reserva("C:\\Users\\PC\\workspace\\InspeccionandoLaReserva\\src\\paquete\\entrada.in");
		inspeccion.bfs();
	}

}
