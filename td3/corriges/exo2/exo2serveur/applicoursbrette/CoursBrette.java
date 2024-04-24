package applicoursbrette;

import cours.Cours;
import cours.PasAssezDePlacesException;

public class CoursBrette implements Cours {

	public CoursBrette(int numeroCours, String intitulé, int nbPlacesMax) {
		this.numeroCours = numeroCours;
		this.intitulé = intitulé;
		this.nbPlacesMax = nbPlacesMax;
		this.nbInscrits = 0;
	}

	private final int nbPlacesMax;
	private final int numeroCours;
	private final String intitulé;
	private int nbInscrits;
	
	@Override
	public void inscription(int nbPlaces) throws PasAssezDePlacesException {
			if (this.nombrePlacesRestant() < nbPlaces)
				throw new PasAssezDePlacesException(this, nbPlaces);
			int n = this.nbInscrits;
			n += nbPlaces;
			this.nbInscrits = n;
	}

	private int nombrePlacesRestant() {
		return (this.nbPlacesMax - this.nbInscrits);
	}

	@Override
	public String toString() {
		return String.valueOf(this.numeroCours) + " : " + intitulé + " " + this.nombrePlacesRestant() + " places restants";
	}

	@Override
	public int getNumeroCours() {
		return numeroCours;
	}

}
