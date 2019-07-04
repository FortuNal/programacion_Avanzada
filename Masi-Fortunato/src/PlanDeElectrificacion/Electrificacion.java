package PlanDeElectrificacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Electrificacion { 
	public int[] ciudadesElectrificadas;
	public int cantidadCiudadesElectrificadas;
	public int[][] matrizAdyacencia;
	public boolean[] visitados;
	public int costoMinimo;
	public int numeroCiudades;
	public ArrayList<Integer> conjuntoV;
	public ArrayList<Integer> conjuntoW;
	public ArrayList<Nodo> arbolDeCostoMinimo;
	private static int INFINITO = 100000;


	public Electrificacion(String path) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(path+".in"));
		
		this.numeroCiudades = sc.nextInt();
		this.cantidadCiudadesElectrificadas = sc.nextInt();
		if(this.numeroCiudades<=0 || this.cantidadCiudadesElectrificadas<=0){
		sc.close();
		grabarTendido(path);
		return;
		}
		ciudadesElectrificadas = new int[cantidadCiudadesElectrificadas];

		for (int i = 0; i < cantidadCiudadesElectrificadas; i++) {
			ciudadesElectrificadas[i] = sc.nextInt();
		}

		visitados = new boolean [numeroCiudades];
		
		
		for (int i = 0; i < cantidadCiudadesElectrificadas; i++)
				visitados[ciudadesElectrificadas[i] -1]= true;
				
		matrizAdyacencia = new int[numeroCiudades][numeroCiudades];
		

		for (int i = 0; i < numeroCiudades; i++) {
			for (int j = 0; j < numeroCiudades; j++)
				matrizAdyacencia[i][j] = sc.nextInt();
		}

		
		sc.close();
		grabarTendido(path);
		
	}
	
	public void sacarCentrales(int nodo){
		for(int i=0;i<this.cantidadCiudadesElectrificadas;i++){
			if(nodo!=(this.ciudadesElectrificadas[i]-1))
				this.conjuntoW.remove(obtenerPosicionDelNodo(this.ciudadesElectrificadas[i]-1));
		}
	}
	
	
	public int buscarNodoInicial(){
		int menorCosto=this.INFINITO;
		int nodo,nodoInicial = 0,inicio=0;
		for(int i=0;i<this.cantidadCiudadesElectrificadas;i++){
			this.generarConjuntoW();
			nodoInicial=this.ciudadesElectrificadas[i]-1;
			sacarCentrales(nodoInicial);
			nodo=buscarNodoMasCercano(nodoInicial);
			if(menorCosto>this.matrizAdyacencia[nodoInicial][nodo]){
				menorCosto=this.matrizAdyacencia[nodoInicial][nodo];
				inicio=nodoInicial;
			}
		}
		return inicio;
	}

	public void grabarTendido(String path) throws FileNotFoundException {

		PrintWriter salida = new PrintWriter(new File(path+".out"));
	
		if(this.cantidadCiudadesElectrificadas<=0||this.numeroCiudades<=0||this.cantidadCiudadesElectrificadas==this.numeroCiudades){
			salida.println(0);
			salida.close();
			return;
		}
		this.conjuntoW = generarConjuntoW();
		int nodoInicial=buscarNodoInicial();
		this.conjuntoW = generarConjuntoW();
		this.conjuntoW.remove(obtenerPosicionDelNodo(nodoInicial));
		this.resolver(nodoInicial);
		
		Collections.sort(this.arbolDeCostoMinimo, new Comparator<Nodo>() {
	        @Override public int compare(Nodo n1, Nodo n2) {
	            return  n2.getCosto()-n1.getCosto(); 
	        }
		});
	        
		salida.println(this.costoMinimo);
		for (Nodo nodo : this.getArbolDeCostoMinimo()) {
			salida.println(nodo);
		}
		salida.close();
	}



	public ArrayList<Integer> generarConjuntoW() {
		ArrayList<Integer> conjunto = new ArrayList<>();
		for (int i = 0; i < this.numeroCiudades; i++) {
				conjunto.add(i);
		}
		return conjunto;
	}

	private int buscarNodoMasCercano(int nodoInicial) {
		int costo;
		int costoMinimo = INFINITO;
		int nodoASacar = -1;
		for (int i = 0; i < this.numeroCiudades; i++) {
			if (nodoInicial != i && this.matrizAdyacencia[nodoInicial][i] != 0 && this.conjuntoW.contains(i) ) {
				costo = this.matrizAdyacencia[nodoInicial][i];
				if (costoMinimo > costo) {
					costoMinimo = costo;
					nodoASacar = i;
				}
			}
		}
		return nodoASacar;
	}

	public int obtenerPosicionDelNodo(int NodoASacar) {
		for (int i = 0; i < this.conjuntoW.size(); i++) {
			if (this.conjuntoW.get(i) == NodoASacar)
				return i;
		}
		return -1;
	}

	public void resolver(int nodoInicial) {
		this.conjuntoV = new ArrayList<>();
		this.arbolDeCostoMinimo=new ArrayList<>();
		this.conjuntoV.add(nodoInicial);
		sacarCentrales(nodoInicial);
		int nodoAUnir = 0;
		int nodoCandidato;
		int costoParcial;
		while (!this.conjuntoW.isEmpty()) {
			costoParcial = INFINITO;
			for (int i = 0; i < this.conjuntoV.size(); i++) {
				nodoCandidato = buscarNodoMasCercano(this.conjuntoV.get(i));
				if (nodoCandidato != -1
						&& costoParcial > this.matrizAdyacencia[this.conjuntoV.get(i)][nodoCandidato]) {
					nodoInicial = this.conjuntoV.get(i);
					nodoAUnir = nodoCandidato;
					costoParcial = this.matrizAdyacencia[nodoInicial][nodoAUnir];
				}
			}
			this.costoMinimo += this.matrizAdyacencia[nodoInicial][nodoAUnir];
			this.conjuntoV.add(nodoAUnir);
			this.conjuntoW.remove(obtenerPosicionDelNodo(nodoAUnir));
			this.arbolDeCostoMinimo
					.add(new Nodo(nodoInicial + 1, nodoAUnir + 1, this.matrizAdyacencia[nodoInicial][nodoAUnir]));
		}
	}

	public int[] getCiudadesElectrificadas() {
		return this.ciudadesElectrificadas;
	}
	
	public int getCantidadCiudadesElectrificadas() {
		return this.cantidadCiudadesElectrificadas;
	}

	public int[][] getMatrizDeAdyacencia() {
		return matrizAdyacencia;
	}

	public void setMatrizDeAdyacencia(int[][] matrizDeAdyacencia) {
		this.matrizAdyacencia = matrizDeAdyacencia;
	}

	public int getCostoMinimo() {
		return costoMinimo;
	}

	public void setCostoMinimo(int costoMinimo) {
		this.costoMinimo = costoMinimo;
	}

	public ArrayList<Integer> getConjuntoV() {
		return conjuntoV;
	}

	public void setConjuntoV(ArrayList<Integer> conjuntoV) {
		this.conjuntoV = conjuntoV;
	}

	public ArrayList<Integer> getConjuntoW() {
		return conjuntoW;
	}

	public void setConjuntoW(ArrayList<Integer> conjuntoW) {
		this.conjuntoW = conjuntoW;
	}

	public ArrayList<Nodo> getArbolDeCostoMinimo() {
		return this.arbolDeCostoMinimo;
	}

	}



