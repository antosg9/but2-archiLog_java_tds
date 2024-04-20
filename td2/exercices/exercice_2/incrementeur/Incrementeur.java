package incrementeur;
public final class Incrementeur implements Runnable {

	private static Object verrouCpt = new Object(); //Création d'un objet à utiliser pour synchronized
	private static int cpt = 1;

	private String name;
	public Incrementeur(String name) {
		this.name = name;
	}

	public static int getValeur() {
		return cpt;
	}

	public void run() {

		for (int i = 1; i <= 10; i++) {			
			synchronized (verrouCpt) { //Synchronisation de la section critique
				int c = cpt;
				System.out.println("valeur a incrementer (round " + i + ") : " + c + " par " + name);
				c = c + 1;
				System.out.println("valeur calcule" + "e (round " + i + ") par " + name + " est : " + cpt);
				cpt = c;
			}
		}
	}
}