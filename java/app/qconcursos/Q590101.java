// https://www.qconcursos.com/questoes-de-concursos/questoes/050736d1-ac
package qconcursos;

public class Q590101 {

	public static void main(String args [] ) {

		int [ ] vet = {13, 15, 10, 8, 6};
		int aux=0;
		int i=0;
		for (i=0; i<5; i++){
		for(int j = 0; j<4; j++) {
			if (vet[j] > vet[j + 1]) {
				aux=vet[j];
				vet[j]=vet[j+1];
				vet[j+1]=aux; }
			}
		}

		for (i = 0; i<5; i++) { 
			System.out.println(vet[i] + ", ");
		}
	}
}
