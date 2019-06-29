package paquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class ColoreoSinOrdenar {
	
	public int cantNodos;
	public int cantAristas;
	int [][]matrizAdyacencia;
	int[]coloresDeNodos;
	int cantColores;
	
	public ColoreoSinOrdenar(String path) throws FileNotFoundException{
		Scanner sc=new Scanner(new File(path+"coloreo.in"));
		sc.useLocale(Locale.ENGLISH);
		this.cantNodos=sc.nextInt();
		this.cantAristas=sc.nextInt();
		this.matrizAdyacencia=new int[this.cantNodos][this.cantNodos];
		this.coloresDeNodos=new int[this.cantNodos];
		for(int i=0;i<this.cantAristas;i++){
			///leo nodo inicial de la arista
			int nodoInicial=sc.nextInt();
			///leo nodo final de la arista
			int nodoFinal=sc.nextInt();
			///como es un grafo bidireccional pongo 1 en la matriz de adyacencia 
			///en ambos sentidos
			matrizAdyacencia[nodoInicial][nodoFinal]=1;
			matrizAdyacencia[nodoFinal][nodoInicial]=1;
		}
		sc.close();
	}
	
	public void mostrarMatriz(){
		for(int i=0;i<this.cantNodos;i++){
			for(int j=0;j<this.cantNodos;j++)
				System.out.print(this.matrizAdyacencia[i][j]);
			System.out.println();
		}
	}
	
	public boolean esColoreable(int nodo,int color){
		
		///pregunto si el nodo ya esta pintado
		if(this.coloresDeNodos[nodo]!=0)
			return false;
		for(int i=0;i<this.cantNodos;i++){
			///si un nodo adyacente tiene el mismo color no puede ser pintado
			if(esAdyacente(nodo,i)&&this.coloresDeNodos[i]==color)
				return false;
		}
		
		return true;
	}
		///no hace falta preguntar en las dos direcciones, ya que es bidireccional
	public boolean esAdyacente(int nodoInicial, int nodoFinal) {
		return this.matrizAdyacencia[nodoInicial][nodoFinal]==1;
	}
	
	public void colorearGrafo(){
		///empiezo pintando con el color 1
		int color=1;
		for(int i=0;i<this.cantNodos;i++){
			for(int j=0;j<this.cantNodos;j++){
				///si es coloreable, pinto el nodo
				if(esColoreable(j,color))
					this.coloresDeNodos[j]=color;
			}
			///como ya no hay nada mas que pintar con ese color, paso al siguiente
			color++;
		}
		this.colorMaximo();
	}
	
	///el numero de color mas alto, es tambien la cantidad de colores 
	///que se usaron para pintar el grafo
	public void colorMaximo(){
		int maximo=this.coloresDeNodos[0];
		for(int i=1;i<this.cantNodos;i++)
			if(this.coloresDeNodos[i]>maximo)
				maximo=this.coloresDeNodos[i];
		this.cantColores=maximo;
	}
	
	public void grabarArchivo(String path) throws FileNotFoundException{
		
		PrintWriter sal=new PrintWriter(new File(path+"coloreo.out"));
		sal.println(this.cantNodos+" "+this.cantColores);
		for(int i=0;i<this.cantNodos;i++)
			sal.println(i+" "+this.coloresDeNodos[i]);
		sal.close();
		
	}

}
