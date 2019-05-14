package paquete;

import java.util.ArrayList;

public class dictado {

	public static void main(String[] args) {
		
		ArrayList<String> palabra = new ArrayList<String>();
		palabra.add("h");
		palabra.add("o");
		palabra.add("l");
		palabra.add("a");
		int indice=palabra.size()-2;
		int i=palabra.size();
		while(esPalindromo(palabra)==0){
			String caracter=palabra.get(indice);
			indice--;
			palabra.add(caracter);
			i++;
		}
		System.out.print(palabra);
	}

	private static int esPalindromo(ArrayList<String> palabra) {
		int inicio=0;
		int fin=palabra.size()-1;
		boolean berror=false;
		while((inicio<fin)&&(berror==false)){
			if(palabra.get(inicio)==palabra.get(fin)){
				inicio++;
				fin--;
			}
			else
				berror=true;
		}
		if(berror==false)
			return 1;
		return 0;
	}

}
