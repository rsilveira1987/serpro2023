// https://www.qconcursos.com/questoes-de-concursos/questoes/b424e68e-bb
package qconcursos;

public class Q596373 {

	public static void main(String[] args) {
		Q596373 x = new Q596373();
		System.out.println(x.abc(4.2, 2));
	}
	
	private int abc(int a, int b) {
		return a+b;
	}
	
	private double abc(double a, double b) {
		return (a+b)/2;
	}
	
	private String abc(String a, String b) {
		return a+b;
	}
	
	private int abc(char a, char b) {
		return a+b;
	}

}
