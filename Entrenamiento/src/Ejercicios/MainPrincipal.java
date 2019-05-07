package guiaTelefonica;

import java.io.IOException;
import java.util.ArrayList;

public class MainPrincipal {

	public static void main(String[] args) throws IOException {
		ArrayList<GuiaTelefonica> guia = new ArrayList<>();
		String codigoIngresado = "46639*4*";
		GuiaTelefonica codigoTraducido = null;
		int contador = 0;
		
		GuiaTelefonica contacto1 = new GuiaTelefonica ("GOMEZ, JUAN",1130782810);
		GuiaTelefonica contacto2 = new GuiaTelefonica ("GOMEZ, JAVIER",1130782810);
		GuiaTelefonica contacto3 = new GuiaTelefonica ("GOMEZ, IGNACIO",1130782810);
		
		guia.add(contacto1);
		guia.add(contacto2);
		guia.add(contacto3);
		
		for(int x=0;x<guia.size();x++) {
				codigoTraducido = new  GuiaTelefonica(guia.get(x).coincideContacto());
				
				if(codigoTraducido.getNombreYapellido().equals(codigoIngresado))
					contador++;
		}
	
		if (contador == 0)
			System.out.println("Contacto no encontrado en la guia");
		else if (contador == 1) {
			System.out.println("El numero es: " + codigoTraducido.getNumeroTelefono());
		}else{
			System.out.println("El codigo tiene mas de un contacto posible...");
		}	
	}
}	
