package paquete;

public class Maraton {

	public static void main(String[] args) {
		double[]maraton={4,2,3,5,6,7,1,10};
		int []podio=ordenMaraton(maraton,3);
		for(int i=0;i<3;i++)
			System.out.println("Puesto "+(i+1)+": Corredor "+podio[i]);
		

	}

	private static int[] ordenMaraton(double[] t, int m) {
		int[]p=new int[m];
		int n=t.length;
		int min_idx;
		for(int i=0;i<m;i++)
		{
			min_idx=i;
			for(int j=0;j<n;j++)
			{
				if(t[j]<t[min_idx])
					min_idx=j;
			}
			p[i]=min_idx;
			t[min_idx]=24;
		}
		return p;
	}

}
