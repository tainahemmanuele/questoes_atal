package distance;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int testes = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < testes ; i++) {
			String palavra1 = sc.nextLine();
			String palavra2 = sc.nextLine();
			int [][] palavraNova = new int[palavra1.length()+1][palavra2.length()+1];
			for (int j = 0; j < palavra1.length()+1; j++) {
				for (int k = 0; k < palavra2.length()+1; k++) {
					if(j==0){
						palavraNova[j][k]=k;
					}else if(k==0){
						palavraNova[j][k]=j;
					}else if(palavra1.charAt(j-1) == palavra2.charAt(k-1)){
						palavraNova[j][k]=palavraNova[j-1][k-1];
					}else{
						int min = Math.min(palavraNova[j][k-1], palavraNova[j-1][k]);
						palavraNova[j][k]= 1+ Math.min(min, palavraNova[j-1][k-1]);
					}
				}
					
				}
			System.out.println(palavraNova[palavra1.length()][palavra2.length()]);
			}
				
			}

}