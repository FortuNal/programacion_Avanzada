package paquetito;

public class McdRecursivo {
	
	public static void main(String[] args) {
		int a=8,b=12;
		
		System.out.print(mcdRecursivo(a,b));
		
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
