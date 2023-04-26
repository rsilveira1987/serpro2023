// https://www.qconcursos.com/questoes-de-concursos/questoes/bb926edc-8e
package qconcursos;

public class Q2020852 {
	
	private double fvalor;
	private String fnome;
	
	Q2020852(double fPreco, String fNome) {
		fvalor = fPreco;
		fnome = fNome;
	}
	
	Q2020852(Q2020852 f) {
		fvalor = f.fvalor;
		fnome = f.fnome;
	}
	
	void teste(Q2020852 f) {
		System.out.println(f.fvalor);
	}
	
	double showPreco() {
		return fvalor;
	}
	
	String showNome() {
		return fnome;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q2020852 f1 = new Q2020852(399,"Laranja Lima");
		System.out.println("Nome da fruta 1 " + f1.showNome());
		System.out.println("Preco da fruta 1 " + f1.showPreco());
		
		Q2020852 f2 = new Q2020852(f1);
		System.out.println("Nome da fruta 2 " + f2.showNome());
		System.out.println("Preco da fruta 2 " + f2.showPreco());		
		
	}

}
