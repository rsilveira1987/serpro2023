/*
 * ***** Teste para a classe Dog *****
 * O metodo main pode ser utilizado para:
 *  - Testar uma classe
 *  - Iniciar uma aplicacao JAVA
 */
package models;

public class DogTestDrive {
	
	public static void main(String[] args) {
		Dog d = new Dog();
		d.size = 40;
		d.bark();
		
		Dog[] dogs = new Dog[3];
		
		dogs[0] = d;
		dogs[1] = new Dog();
		dogs[2] = new Dog();
		
		for(int i=0;i<dogs.length;i++) {
			if (dogs[i] == null)
				continue;
			
			dogs[i].bark();
		}
	}
	
}
