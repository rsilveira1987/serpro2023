// https://www.qconcursos.com/questoes-de-concursos/questoes/ec5f4661-9e
package qconcursos;

public class Q585716 {

	public static void main(String[] args) {
		int f=1;
		// A
		// int n=1; do (n<=5) {f=f*n; n++;} while();
		
		// B
		for (int n=1;n<=5;n++){ f=f*n; }
		
		// C
		// int n=1; do {f=f*n; n++} while (n<=5)
		
		// D
		// for (n=1;n<=5;n=n+1){ f=f*n; }
		
		// E
		// int n=1; while (n<=5){f=f*n;}
		
		System.out.print ("O resultado da operação é " + f);
	}

}
