package packy;

public class MatrizCoprimos {
	
	public static void main(String[] args) {
		int n=5;
		int[][] mat=new int[n][n];
		completarMatriz(mat,n);
		for(int i = 0;i<n;i++){
			for(int j = 0;j<n;j++)
				System.out.print(""+mat[i][j]);
			System.out.println("");
		}
		
		}
	
	public static void completarMatriz(int[][] mat, int tam){
		
		for(int i = 0;i<tam;i++){
			for(int j = 0;j<tam;j++)
				if(mcdRecursivo(i,j)==1)
					mat[i][j]=1;
				else
					mat[i][j]=0;
		}
		
	}
	
	public static int mcdRecursivo(int a,int b){
		
		if(a<b)
			return mcdRecursivo(b,a);
		else
			if(b==0)
				return a;
			else
				return mcdRecursivo(b,a%b);
		
	}


}
