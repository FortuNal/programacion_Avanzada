package paquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class metro {
	
	public int cantIslas;
	public int cantTuneles;
	public int cantPuentes;
	public boolean[][] matResultado;
	public boolean[][] matPuentes;

	public metro(String path) throws FileNotFoundException{
		Scanner sc=new Scanner(new File(path));
		sc.useLocale(Locale.ENGLISH);
		this.cantIslas=sc.nextInt();
		this.cantTuneles=sc.nextInt();
		this.cantPuentes=sc.nextInt();
		this.matResultado=new boolean[this.cantIslas][this.cantIslas];
		this.matPuentes=new boolean[this.cantIslas][this.cantIslas];
		for(int i=0;i<this.cantTuneles;i++){
			int fila=sc.nextInt()-1;
			int columna=sc.nextInt()-1;
			this.matResultado[fila][columna]=true;
			this.matResultado[columna][fila]=true;
		}
		for(int i=0;i<this.cantPuentes;i++){
			int fila=sc.nextInt()-1;
			int columna=sc.nextInt()-1;
			this.matPuentes[fila][columna]=true;
			this.matPuentes[columna][fila]=true;
		}
		sc.close();
	}
	
	public void construirMetro(){
		
		this.warshall();
		
		boolean repetir=true;
		int puentes=0;
		
		while(repetir){
			
			repetir=false;
			
			for(int i=0;i<this.cantIslas;i++){
				for(int j=0;j<this.cantIslas;j++){
					if(i!=j && !this.matResultado[i][j] && this.matPuentes[i][j]){
						this.matResultado[i][j]=true;
						this.matResultado[j][i]=true;
						repetir=true;
					}
				}
			}
			
			if(repetir==true)
				puentes++;
			
			this.warshall();
		}
		System.out.println(puentes+1);
	}
	
	public void warshall() {
		for(int t=0;t<this.cantIslas;t++)
			for(int i=0;i<this.cantIslas;i++)
				for(int j=0;j<this.cantIslas;j++){
					if(this.matResultado[i][j]==false && i!=j)
						if(this.matResultado[i][t]==true && this.matResultado[t][j]==true)
							this.matResultado[i][j]=true;
				}
			
	}
	
}
