// https://www.qconcursos.com/questoes-de-concursos/questoes/a2f45e2e-d0
package qconcursos;

import java.util.ArrayList;
import java.util.List;

public class Q606815<T> implements Runnable {
	static String lock = "lock";
	private List<T> o;
	
	Q606815(T i) {
		o = new ArrayList<T>();
		o.add(i);
	}
	
	public void add(T t) {
		o.add(t);
	}
	
	public String toString() {
		return o.toString();
	}
	
	public void run() {
		System.out.println("Executando...");
		synchronized(lock) {
			while(!o.isEmpty()) {
				System.out.println(o.remove(o.size()-1));
			}
		}
	}
	
	public static void main(String[] args) {
		Q606815<String> t1 = new Q606815<String>("teste");
		Q606815<Q606815<String>> t2 = new Q606815<Q606815<String>>(t1);
		new Thread(t1).start();
		new Thread(t2).start();
	}
}
