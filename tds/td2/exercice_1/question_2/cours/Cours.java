package cours;

public class Cours {

	public Cours(int numeroCours, String intitule, int nbPlacesMax) {
		this.numeroCours = numeroCours;
		this.intitule = intitule;
		this.nbPlacesMax = nbPlacesMax;
		this.nbInscrits = 0;
	}

	private final int nbPlacesMax;
	private final int numeroCours;
	private final String intitule;
	private int nbInscrits;

	public void inscription(int nbPlaces) throws PasAsseezDePlacesException {			
		if (this.nombrePlacesRestant() < nbPlaces)
			throw new PasAsseezDePlacesException(this, nbPlaces);

		try {
			Thread.sleep(2); // Ralentisseur qui permet de démontrer où les threads posent problèmes
		} catch (InterruptedException e) {}

		this.nbInscrits += nbPlaces;

		System.out.println(nbPlaces+ " inscriptions reussies au cours "+this);
	}

	private int nombrePlacesRestant() {
		return (this.nbPlacesMax - this.nbInscrits);
	}

	@Override
	public String toString() {
		return String.valueOf(this.numeroCours) + " : " + intitule + " " + this.nombrePlacesRestant() + " places restants";
	}

}
