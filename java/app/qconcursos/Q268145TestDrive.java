// https://www.qconcursos.com/questoes-de-concursos/questoes/5d6876cc-17
package qconcursos;

class Q268145TestDrive {
	public static void main(String[] args) {
		Q268145 bike1 = new Q268145();
		Q268145 bike2 = new Q268145();
		bike1.changeCadence(50);
		bike1.speedUp(10);
		bike1.changeGear(2);
		bike1.printStates();
		bike2.changeCadence(50);
		bike2.speedUp(10);
		bike2.changeGear(2);
		bike2.changeCadence(40);
		bike2.speedUp(10);
		bike2.changeGear(3);
		bike2.printStates();
	}
}

//import javax.swing.JOptionPane;
//...
//bike1.changeCadence( Integer.parseInt(JOptionPane.showInputDialog("Digite um valor")) );
//...
