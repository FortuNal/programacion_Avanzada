package Ejercicios;

public class Entrenamiento1 {

	public static void main(String[] args) {
		 int [] losValores = new int[10];
		 int k=4, t=16;
	     cargarVector(losValores,10);
	     seleccion(losValores,10);
	     mostrarVector(losValores,10);
	     if(determinarSub(losValores,k,t)==1)
	    	 System.out.println("El subconjunto K, es a lo sumo T");
	     else
	    	 System.out.println("No existe subconjunto K, que sea a lo sumo T");
	     
	}
	
	public static void cargarVector(int[] vec, int tam) {
		vec[0]=10;
		vec[1]=7;
		vec[2]=5;
		vec[3]=4;
		vec[4]=6;
		vec[5]=1;
		vec[6]=8;
		vec[7]=2;
		vec[8]=3;
		vec[9]=9;
	}
	public static void mostrarVector(int[] vec, int tam) {
		for(int i=0;i<tam;i++) {
	    	 System.out.println(vec[i]);
	     }
	}
	public static void seleccion(int []A, int tam) {
        int i, j, menor, pos, tmp;
        for (i = 0; i < tam - 1; i++) { // tomamos como menor el primero
              menor = A[i]; // de los elementos que quedan por ordenar
              pos = i; // y guardamos su posición
              for (j = i + 1; j < tam; j++){ // buscamos en el resto
                    if (A[j] < menor) { // del array algún elemento
                        menor = A[j]; // menor que el actual
                        pos = j;
                    }
              }
              if (pos != i){ // si hay alguno menor se intercambia
                  tmp = A[i];
                  A[i] = A[pos];
                  A[pos] = tmp;
              }
        }
}
	public static int determinarSub(int []a, int tam, int t) {
		int i,acum=0;
		for(i=0;i<tam;i++) {
			acum+=a[i];
		}
		if(acum<=t)
			return 1;
		return 0;
	}
}
