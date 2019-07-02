package paquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class VerificacionConexion {
	
	public int cantComputadoras;
	public int[][] matrizAdyacencia;
	public char consulta;
	public int nodoInicial;
	public int nodoFinal;
	public char[] respuestas;
	public int cantRespuestas;
	
	public VerificacionConexion(String path,int cantNodos) throws FileNotFoundException{
		Scanner sc=new Scanner(new File(path));
		sc.useLocale(Locale.ENGLISH);
		this.cantComputadoras=cantNodos;
		this.matrizAdyacencia=new int[this.cantComputadoras][this.cantComputadoras];
		this.respuestas=new char[this.cantComputadoras];
		this.consulta=sc.next().charAt(0);
		this.cantRespuestas=0;
		while(consulta!='F'){
			this.nodoInicial=sc.nextInt()-1;
			this.nodoFinal=sc.nextInt()-1;
			if(consulta=='C'){
				this.matrizAdyacencia[nodoInicial][nodoFinal]=1;
				this.matrizAdyacencia[nodoFinal][nodoInicial]=1;
			}
			if(consulta=='P'){
				this.warshall();
				if(this.matrizAdyacencia[nodoInicial][nodoFinal]==1)
					this.respuestas[this.cantRespuestas]='S';
				else
					this.respuestas[this.cantRespuestas]='N';
				
				this.cantRespuestas++;
			}
			this.consulta=sc.next().charAt(0);
		}
		sc.close();
	}

	public void warshall() {
		for(int t=0;t<this.cantComputadoras;t++)
			for(int i=0;i<this.cantComputadoras;i++)
				for(int j=0;j<this.cantComputadoras;j++){
					if(this.matrizAdyacencia[i][j]==0 && i!=j)
						if(this.matrizAdyacencia[i][t]==1 && this.matrizAdyacencia[t][j]==1)
							this.matrizAdyacencia[i][j]=1;
				}
			
	}
	
	public void mostrarRespuestas(){
		for(int i=0;i<this.cantRespuestas;i++){
			System.out.println(this.respuestas[i]);
		}
	}

}
