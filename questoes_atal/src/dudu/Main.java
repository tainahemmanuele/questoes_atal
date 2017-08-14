package dudu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<List<Integer>> lista;
		int t = sc.nextInt();
		sc.nextLine();
		boolean[] status;
		String result = "SIM";
		while (t > 0) {

			String valor = sc.nextLine();
			lista = new ArrayList<List<Integer>>();
			int n = Integer.parseInt(valor.split(" ")[0]);
			int m = Integer.parseInt(valor.split(" ")[1]);
			status = new boolean[n];
			Arrays.fill(status, false);
			for (int i = 0; i < n; i++) {
				lista.add(new ArrayList<>());

			}
			for (int i = 0; i < m; i++) {
				String v = sc.nextLine();
				int value1 = Integer.parseInt(v.split(" ")[0]);
				int value2 = Integer.parseInt(v.split(" ")[1]);
				if(value1 != value2){
				if (1 <= value1 && value2 <= n ) {
					lista.get(value1 - 1).add(value2);
				}
				}
			}

			Queue<Integer> fila = new LinkedList<>();
			for (int j = 1; j <= lista.size(); j++) {
				if (!status[j - 1]) {
					fila.add(j);
				}
			}
			while (!fila.isEmpty()) {
				Integer v = fila.poll();
				if (v != null) {
					status[v - 1] = true;
					List<Integer> adj = lista.get(v - 1);
					for (Integer integer : adj) {
						if (status[integer - 1]) {
							result = "SIM";
							break;
						} else {
							result = "NAO";
						}
						status[integer - 1] = true;
						fila.add(integer);

					}
				}

			}
			System.out.println(result);
			t--;
		}

	}

}