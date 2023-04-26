// https://www.qconcursos.com/questoes-de-concursos/questoes/5fa3c138-6d
package qconcursos;

public class Q1989564 {

	public static void main(String[] args) {
		int a = 5; // 0000 0101
		int b = 7; // 0000 0111
		int x = (~a & b);
		// 1111 1010  &
		// 0000 0111
		// ----------
		// 0000 0010 => 2
		System.out.println("x = " + x);
	}

}
