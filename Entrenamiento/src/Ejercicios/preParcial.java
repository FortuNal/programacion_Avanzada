package paquete;

public class preParcial {
	public static void main(String[] args) {
	int posi;
	int[] vector={1,2,3,1,0,-2};
	
	posi= buscar(vector,0,5);
	System.out.print(vector[posi]);
	
	}
	
	public static int buscar(int[]vec,int ini, int fin){
		int medio = 0;
		if(ini<fin)
			medio = (ini+fin)/2;
		if((vec[medio]>vec[medio+1])&&(vec[medio]>vec[medio-1]))
				return medio;
		if((vec[medio]>vec[medio+1])&&(vec[medio]<vec[medio-1]))
				return buscar(vec,ini,medio-1);
		return buscar(vec,medio+1,fin-1);
	}

}