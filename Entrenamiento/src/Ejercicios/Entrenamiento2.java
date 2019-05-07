package Ejercicios;

public class Entrenamiento2 {

	public static void main(String[] args) {
		int [] losValores = new int[9];
		cargarVector(losValores,9);
		reordenar(losValores,9,6);
		mostrarVector(losValores,9);
	}
	
	public static void cargarVector(int[] vec, int tam) {
		int i;
		for(i=0;i<tam;i++)
			vec[i]=i+1;
	}
	public static void mostrarVector(int[] vec, int tam) {
		for(int i=0;i<tam;i++) {
	    	 System.out.println(vec[i]);
	     }
	}
	
	public static void reordenar(int []v,int n, int m) {
		int i,j=m,aux,tam=n-m;
		for(i=0;i<tam;i++) {
			aux=v[i];
			v[i]=v[j];
			v[j]=aux;
			j++;
		}
		
		j=m;
		for(;i<m;i++) {
			aux=v[i];
			v[i]=v[j];
			v[j]=aux;
			j++;
		}
		
	}

}
