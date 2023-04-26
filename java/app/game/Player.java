package game;

public class Player {
	
	int number = 0;
	String name;
	
	Player(String name) {
		this.name = name;
	}
	
	public void guess() {
		number = (int) (Math.random() * 10);
		this.message("I am guessing number " + number);
	}
	
	public void message(String msg) {
		System.out.println(this.name + " says: " + msg);
	}
}
