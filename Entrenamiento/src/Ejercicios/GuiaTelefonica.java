package guiaTelefonica;

public class GuiaTelefonica {

	private String nombreYapellido;
	private int numeroTelefono;
	
	public GuiaTelefonica(String nombreYapellido, int numeroTelefono) {
		super();
		this.nombreYapellido = nombreYapellido;
		this.numeroTelefono = numeroTelefono;
	}
	
	public GuiaTelefonica(GuiaTelefonica gui) {
		super();
		this.nombreYapellido = gui.nombreYapellido;
		this.numeroTelefono = gui.numeroTelefono;
	}
	
	public void mostrarContenido ()
	{
		System.out.println("El nombre es " + this.nombreYapellido + " , el numero de telefono es:" + this.numeroTelefono);
	}
	
	public GuiaTelefonica coincideContacto()
	{
		GuiaTelefonica gui;
		String[] parts = this.nombreYapellido.split(", ");
		String apellido = parts[0];  
		String nombre= parts[1]; 
		
		StringBuffer txt = new StringBuffer();
		
		for (int n = 0; n < apellido.length(); n ++) { 
			
			char c = nombreYapellido.charAt (n); 
			txt.append(pasarAnumero(c));
		}
		txt.append('*');
		
		for (int n = 0; n < 1; n ++) { 
			
			char c = nombre.charAt (n); 
			
			txt.append(pasarAnumero(c));
		}
		txt.append('*');
		gui = new GuiaTelefonica(txt.toString(),this.numeroTelefono);
		return gui;
	}
	
	public char pasarAnumero(char c)
	{
		if (c == 'A' || c == 'B' || c == 'C')
			return '2';
		
		if (c == 'D' || c == 'E' || c == 'F')
			return '3';
		
		if (c == 'G' || c == 'H' || c == 'I')
			return '4';

		if (c == 'J' || c == 'K' || c == 'L')
			return '5';

		if (c == 'M' || c == 'N' || c == 'Ñ' || c == 'O')
			return '6';

		if (c == 'P' || c == 'Q' || c == 'R' || c == 'S')
			return '7';

		if (c == 'T' || c == 'U' || c == 'V')
			return '8';

		if (c == 'W' || c == 'X' || c == 'Y'|| c == 'Z')
			return '9';
		
		return '0';
	}

	public String getNombreYapellido() {
		return nombreYapellido;
	}

	public void setNombreYapellido(String nombreYapellido) {
		this.nombreYapellido = nombreYapellido;
	}

	public int getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(int numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

}
