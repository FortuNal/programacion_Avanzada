package paquete;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class palabrasRepetidas {

	public static void main(String[] args) throws IOException {
		
        String s2;
        
		ArrayList<String> palabrasUnicas = new ArrayList<String>();
		ArrayList<Integer> ocurrencias = new ArrayList<Integer>();
		Scanner sc = new Scanner(new File("C:\\Users\\PC\\workspace\\PalabrasRepetidas\\src\\paquete\\Archivo"));
		sc.useLocale(Locale.ENGLISH);
		int tam=0;
		while(sc.hasNext()) {
			s2=sc.next();
			tam++;
			if(!palabrasUnicas.contains(s2))
			{
				palabrasUnicas.add(s2);
				ocurrencias.add(0);
			}
			else
			{
				int pos=palabrasUnicas.indexOf(s2);
				ocurrencias.set(pos, ocurrencias.get(pos)+1);
			}
            	
		}
		
					
		for(int i=0;i<palabrasUnicas.size();i++)
		{
			System.out.println("Palabra "+(i+1)+" es: "+palabrasUnicas.get(i)+" se repite "+ocurrencias.get(i));
			if(ocurrencias.get(i)==0)
				System.out.println(" Frecuencia: "+"0");
			else
				System.out.println(" Frecuencia: "+ocurrencias.get(i)+"/"+tam);
		}
			
		
}
}
