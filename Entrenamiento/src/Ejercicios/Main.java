package paquete;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Locale;



public class Main {
	
	

	public static void main(String[] args) throws FileNotFoundException {
		int N;
		int []CantidadesPorRegla;
		////LECTURA DE ARCHIVO///
		String miPath = "C:\\Users\\PC\\workspace\\Pluralizador\\src";
		Scanner sc = new Scanner(new File(miPath+"\\pluralizar.in"));
		sc.useLocale(Locale.ENGLISH);
		N=sc.nextInt();
		String [] palabra = new String[N]; 
		String saltoDeLinea = sc.nextLine();
		for (int i = 0; i < N ; i++) {
			palabra[i] =sc.nextLine() ;
			System.out.println( palabra[i]);
		}
		sc.close();
		////CREACION VECTOR DE REGLAS, Y LO LLENO DE CEROS///
		CantidadesPorRegla= new int[N];
		for(int i=0;i<N;i++)
			CantidadesPorRegla[i]=0;
		pluralizar(N,palabra,CantidadesPorRegla);
	}

	public static void pluralizar(int n, String[] palabra, int[] cantidadesPorRegla) throws IndexOutOfBoundsException {
		
		System.out.println("");
		System.out.println("**Funcion Pluralizar**");
		System.out.println("");
		for(int i=0;i<n;i++){
			
			char ultimaLetra=palabra[i].charAt(palabra[i].length()-1);	
			if(ultimaLetra=='a'||ultimaLetra=='e'||ultimaLetra=='i'
					||ultimaLetra=='o'||ultimaLetra=='u')
			{	
				StringBuilder sb=new StringBuilder(palabra[i]);
				sb.insert(sb.length(), "s");
				palabra[i]=sb.toString();
				cantidadesPorRegla[0]++;
			}
			else
			if(ultimaLetra=='z')
			{	
				StringBuilder sb=new StringBuilder(palabra[i]);
				sb.insert(sb.length()-1, "ces");
				sb.setLength(sb.length() - 1);
				palabra[i]=sb.toString();
				cantidadesPorRegla[2]++;
			}
			else
				if(ultimaLetra!='s')
			{	
				StringBuilder sb=new StringBuilder(palabra[i]);
				sb.insert(sb.length(), "es");
				palabra[i]=sb.toString();
				cantidadesPorRegla[3]++;
			}
				else
					cantidadesPorRegla[1]++;
				
			
		System.out.println(palabra[i]);	
		}
		
		for(int i=0;i<n;i++)
			System.out.println("Regla "+ (i+1)+": " + cantidadesPorRegla[i]);	
		
	}

}
