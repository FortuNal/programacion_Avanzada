package paquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class mensajeSecreto {

	public static void main(String[] args) throws IOException {
		
	////LECTURA DE ARCHIVO///
			String miPath = "C:\\Users\\PC\\workspace\\MensajesSecretos\\src";
			Scanner sc = new Scanner(new File(miPath+"\\Mensajes.in"));
			sc.useLocale(Locale.ENGLISH);
			char [] letras = new char[sc.nextInt()]; 
			
			for (int i = 0; i < letras.length ; i++) {
				letras[i] =sc.next().charAt(0) ;
				System.out.print(" "+letras[i]);
			}
			System.out.println("");
			char [] sub = new char[3]; 
			for (int i = 0; i < 3 ; i++) {
				
				sub[i] =sc.next().charAt(0) ;
				System.out.print(" "+sub[i]);
			}
			sc.close();
			

			String miPath2 = "C:\\Users\\PC\\workspace\\MensajesSecretos\\src";
			
			PrintWriter salida = new PrintWriter(new FileWriter(miPath2+"\\Mensajes.out"));  //  preparo el arch de salida
			String s = null;
		    if(busqIzq(letras,sub)==1)
		    {
		    	s= "SI";
		    	salida.print(s);      
		    	salida.println(" "+'I'); 
		    }
		    	 
		    else
		    	if(busqDer(letras,sub)==1)
		    {
		    		s= "SI";
			    	salida.print(s);      
			    	salida.println(" "+'D'); 
		    }
		    else
		    	{
		    		s="NO";
				salida.print(s); 
				salida.close(); 
		    	}
			
	}
	
	
	public static int busqIzq(char[]letras,char[]sub){
		int coincidencias=0;
		int coincide=1;
		for(int i=0;i<letras.length;i++){
			while(coincidencias<sub.length&&coincide==1)
			{
				if(letras[i]!=sub[coincidencias])
					coincide=0;
				
				else
				{
					i++;
					coincidencias++;
				}
					
			}
			coincide=1;
			if(coincidencias==sub.length)
				return 1;
			coincidencias=0;
		}
		return 0;
	}
	
	public static int busqDer(char[]letras,char[]sub){
		int coincidencias=0;
		int coincide=1;
		for(int i=letras.length-1;i>=0;i--){
			while(coincidencias<sub.length&&coincide==1)
			{
				if(letras[i]!=sub[coincidencias])
					coincide=0;
				
				else
				{
					i--;
					coincidencias++;
				}
					
			}
			coincide=1;
			if(coincidencias==sub.length)
				return 1;
			coincidencias=0;
		}
		return 0;
	}

}
