package cours;

public class PasAsseezDePlacesException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private Cours cours;
	private int nbPlaces;

	public PasAsseezDePlacesException(Cours cours, int nbPlaces) {
		this.cours = cours;
		this.nbPlaces = nbPlaces;
	}

	@Override
	public String toString() {
		return "Desole, il n'y a pas "+this.nbPlaces+" places pour le cours "+cours;
	}

}
