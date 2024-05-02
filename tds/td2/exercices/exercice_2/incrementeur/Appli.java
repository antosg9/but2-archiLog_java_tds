package incrementeur;

public class Appli {
	public static void main(String args[]) throws InterruptedException {
		System.out.println("VALEUR " + Incrementeur.getValeur());

		Thread t1 = new Thread(new Incrementeur("Thread1"));
		Thread t2 = new Thread(new Incrementeur("Thread2"));

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {}

		System.out.println("VALEUR FINALE " + Incrementeur.getValeur());
	}
}