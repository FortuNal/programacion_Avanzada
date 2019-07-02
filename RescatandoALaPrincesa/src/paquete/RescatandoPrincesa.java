package paquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class RescatandoPrincesa {
	
	public int cantClaros;
	public int cantSenderos;
	public int cantDragones;
	public int posPrincipe;
	public int posPrincesa;
	public int[] posDragones;
	public int[] precedencia;
	public int[] camino;
	public int[] costos;
	public boolean[] visitados;
	public int[][] matrizAdyacencia;
	public int INFINITO=10000;
	
	public RescatandoPrincesa(String path) throws FileNotFoundException{
		Scanner sc=new Scanner(new File(path));
		sc.useLocale(Locale.ENGLISH);
		this.cantClaros=sc.nextInt();
		this.cantSenderos=sc.nextInt();
		this.cantDragones=sc.nextInt();
		this.posPrincesa=sc.nextInt();
		this.posPrincipe=sc.nextInt();
		this.posDragones=new int[this.cantDragones];
		for(int i=0;i<this.cantDragones;i++)
			this.posDragones[i]=sc.nextInt();
		this.matrizAdyacencia=new int[this.cantClaros][this.cantClaros];
		inicializarMatriz();
		for(int i=0;i<this.cantSenderos;i++){
			int fila=sc.nextInt()-1;
			int columna=sc.nextInt()-1;
			int valor=sc.nextInt();
			this.matrizAdyacencia[fila][columna]=valor;
			this.matrizAdyacencia[columna][fila]=valor;
		}
		this.camino=new int[this.cantClaros];
		this.precedencia=new int[this.cantClaros];
		this.visitados=new boolean[this.cantClaros];
		this.costos=new int[this.cantClaros];
		inicializarVectores();

		sc.close();
	}

	private void inicializarVectores() {
		for(int i=0;i<this.cantClaros;i++){
			this.visitados[i]=false;
			this.precedencia[i]=this.posPrincipe-1;
			this.costos[i]=this.matrizAdyacencia[this.posPrincipe-1][i];
		}
		this.visitados[this.posPrincipe]=true;
	}

	private void inicializarMatriz() {
		for(int i=0;i<this.cantClaros;i++)
			for(int j=0;j<this.cantClaros;j++)
				this.matrizAdyacencia[i][j]=this.INFINITO;
	}
	
	public void mostrarMatriz(){
		for(int i=0;i<this.cantClaros;i++){
			for(int j=0;j<this.cantClaros;j++)
				System.out.print(this.matrizAdyacencia[i][j]+" ");
			System.out.println();
		}
	}
	
	
	
	
	public void dijkstra(){
		
		int w=0;
		boolean existeW=true;
		while(existeW){
			existeW=false;
			int menorCosto=this.INFINITO;
			for(int i=0;i<this.visitados.length;i++){
				if(!this.visitados[i] && this.costos[i] < menorCosto){
					existeW=true;
					menorCosto = this.costos[i];
					w=i;
				}
					
			}	
			this.visitados[w]=true;
			
			for(int i=0;i<this.cantClaros;i++)
				if(!this.visitados[i] && this.matrizAdyacencia[w][i]!=this.INFINITO){
					if(this.costos[i]>this.costos[w]+this.matrizAdyacencia[w][i])
						menorCosto=this.costos[w]+this.matrizAdyacencia[w][i];
					else
						menorCosto=this.costos[i];
					if (menorCosto < this.costos[i]) {
						this.costos[i] = menorCosto;
						this.precedencia[i] = w;
					}
				}
		
		}
		this.reconstruirCamino(this.posPrincipe);
		
	}
	
	
	public void reconstruirCamino(int posInicial){
		int posFinal=this.posPrincesa-1;

		int i=0,j=0;
		while(posInicial<posFinal){
			this.camino[i]=posFinal;
			posFinal=this.precedencia[posFinal];
			i++;
		}
		while(j<=i){
			System.out.print(this.camino[i]+1+" ");
			i--;
		}
			
	}

}
