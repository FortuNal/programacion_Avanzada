package paquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Scanner;

public class Reserva {
	
	public int miradores;
	public int tramos;
	public int[] estado;
	public int[][] matrizAdyacencia;
	public Queue<Integer> cola;
	public int[] caminosPosibles;
	
	public Reserva(String path) throws FileNotFoundException{
		Scanner sc=new Scanner(new File(path));
		sc.useLocale(Locale.ENGLISH);
		this.miradores=sc.nextInt();
		this.tramos=sc.nextInt();
		this.matrizAdyacencia=new int[this.miradores][this.miradores];
		for(int i=0;i<this.tramos;i++){
			int miradorInicial=sc.nextInt()-1;
			int miradorFinal=sc.nextInt()-1;
			this.matrizAdyacencia[miradorInicial][miradorFinal]=1;
		}
		this.estado=new int[this.miradores];
		this.caminosPosibles=new int[this.miradores];
		this.cola = new LinkedList<>();
		sc.close();
	}
	
	
	public void bfs() throws FileNotFoundException{
		int miradorInicial=0;
		this.estado[miradorInicial]=1;
		this.caminosPosibles[miradorInicial]=1;
		this.cola.offer(miradorInicial);
		while(!this.cola.isEmpty()){
			int nodoU=this.cola.poll();
			for(int i=0;i<this.miradores;i++){
				if(this.matrizAdyacencia[nodoU][i]==1){
					if(this.estado[i]==0){
					this.estado[i]=1;
					this.cola.offer(i);
					}
					this.caminosPosibles[i]+=this.caminosPosibles[nodoU];
				}
				
			}
		}
		PrintWriter sal=new PrintWriter(new File("C:\\Users\\PC\\workspace\\InspeccionandoLaReserva\\src\\paquete\\salida.in"));
		sal.println(this.caminosPosibles[this.miradores-1]);
		sal.close();
	}

}
