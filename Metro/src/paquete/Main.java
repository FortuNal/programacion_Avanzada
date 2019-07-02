package paquete;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		metro m=new metro("C:\\Users\\PC\\workspace\\Metro\\src\\paquete\\metro.in");
		m.construirMetro();
	}

}
