package pack;


public class Recursividad {
	
	public static void main(String[] args) {
		String cadena="cadena";
		
		System.out.print(alReves(cadena));
		
		}
	
	
	public static String alReves(String cadena) {
		 if (cadena.length() == 1)
		   return cadena;
		 else 
		   return alReves(cadena.substring(1))+ cadena.charAt(0);
		}

}
