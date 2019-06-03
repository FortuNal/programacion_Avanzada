package paquete;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class aCorrer {

	public int[] VC;
	public char[] VS;
	public int[] VM;
	public int[][] MCF;
	public int[][] MCM;
	public int[][] MPF;
	public int[][] MPM;

	public aCorrer(String path) throws IOException {

		int Meta;
		int Total;
		int cF;
		int cM;
		Scanner sc;
		sc = new Scanner(new File(path));
		
		sc.useLocale(Locale.ENGLISH);

		Total = sc.nextInt();
		cF = sc.nextInt();
		cM = sc.nextInt();
		Meta = sc.nextInt();
		MCF = new int[cF][2];
		MCM = new int[cM][2];
		
		VC = new int[Total];
		VS = new char[Total];
		VM = new int[Meta];
		MPF = new int[cF][3];
		MPM = new int[cM][3];
		
		for (int i = 0; i < cF; i++) {
			MCF[i][0] = sc.nextInt();
			MCF[i][1] = sc.nextInt();
		}

		for (int i = 0; i < cM; i++) {
			MCM[i][0] = sc.nextInt();
			MCM[i][1] = sc.nextInt();
		}
		for (int i = 0; i < Total; i++) {
			VC[i] = sc.nextInt();
			VS[i] = sc.next().charAt(0);
		}

		for (int i = 0; i < Meta; i++)
			VM[i] = sc.nextInt();
		
		sc.close();
		
		for(int j=0;j<cF;j++){
			int cant = 0;
			for(int i=0;i<Meta&&cant<3;i++){
				if(VS[VM[i]-1]=='F'&&(MCF[j][0]<=VC[VM[i]-1]&&MCF[j][1]>=VC[VM[i]-1])){
					MPF[j][cant]=VM[i];
					cant++;
				}
			}
		}
		
		for(int j=0;j<cM;j++){
			int cant = 0;
			for(int i=0;i<Meta&&cant<3;i++){
				if(VS[VM[i]-1]=='M'&&(MCM[j][0]<=VC[VM[i]-1]&&MCM[j][1]>=VC[VM[i]-1])){
					MPM[j][cant]=VM[i];
					cant++;
				}
			}
		}
		
		PrintWriter salida = new PrintWriter(new FileWriter("corredoresSalida.txt"));
		
		for(int i = 0; i < MPF.length; i++) {
			salida.print(i+1 + " ");
			for(int j = 0; j < 3; j++) {
				salida.print(MPF[i][j] + " ");
				
			}
			salida.println("");
		}
		

		for(int i = 0; i < MPM.length; i++) {
			salida.print(i+1 + " ");
			for(int j = 0; j < 3; j++) {
				salida.print(MPM[i][j] + " ");
				
			}
			salida.println("");
		}
		
		
		salida.close();
		}

}
