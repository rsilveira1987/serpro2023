// https://www.qconcursos.com/questoes-de-concursos/questoes/020f714a-59
package qconcursos;

public class Q894025 {

	 static {
		 int a = 2;
	 } static int a, y;

	 public static void main(String args[]) {
		 a--;
		 minhaFuncao();
		 System.out.println(a + y + ++a);
	 }

	 public static void minhaFuncao() {
 		y = a++ + ++a;
	 }

}
