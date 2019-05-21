package paq;

import java.util.Scanner;

public class cerradura {
	
    static int combinacion;
    boolean estado=true;
	
	public static void CerraduraConCombinacion(int combi){
		combinacion=combi;
	}
	
	public void cambiarCombinacion(){
		Scanner reader = new Scanner(System.in);
		System.out.println("Ingrese la Combinacion vieja");
		int numero = 0;
		numero = reader.nextInt();
		if(combinacion==numero)
		{
			System.out.println("Ingrese nueva combinacion");
			numero = reader.nextInt();
			combinacion=numero;
		}
		reader.close();
	}
	
	public void cerrarCerradura(){
		estado=false;
	}
}
