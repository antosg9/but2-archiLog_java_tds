package carafe;

public class ConcurrentCarafe implements Carafe{

	private CarafeSimple c;

	public ConcurrentCarafe(CarafeSimple c)
	{
		this.c=c;
	}

	@Override
	public void remplir() {
		synchronized (c) { //Thread-Safety dans le proxy
			c.remplir();
			c.notifyAll(); //Une fois que la carafe est remplie on réveille les convives
		}

	}

	@Override
	public void retirer(int q) throws InterruptedException {
		synchronized (c) { //Thread-Safety dans le proxy
			while(c.estVide()) {c.wait();} //Tant que la carafe est vide, les convives attendent que le serveur les réveillent
			c.retirer(q);
		}
	}

	@Override
	public boolean estVide() {
		synchronized (c) { //Thread-Safety dans le proxy
			return c.estVide();
		}
	}

}
