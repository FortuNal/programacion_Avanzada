package paquete;

public class numerologo {

	public static void main(String[] args) {
		
		int numero=8;
		int resultado,aux = 0;
		resultado=factorear(numero);
		while(resultado!=numero&&resultado<10000){
			numero=resultado;
			aux=resultado;
			resultado=factorear(numero);
		}
		if(resultado>10000)
			resultado=aux;
		System.out.print(resultado);
	}
	
	public static int factorear(int numero){

		 int num = 2;
		 
	     String res = "0";
		while(numero!=1)
	     {
	          while(numero%num==0)
	          {
	        	   String Parcial=String.valueOf(num);
	        	   res+=Parcial;
	               numero /= num;
	          }
	          num++;
	     }
		 int resultado = Integer.parseInt(res); 
	     return resultado;
	}


}
