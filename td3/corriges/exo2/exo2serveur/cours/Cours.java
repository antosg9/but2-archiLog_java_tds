package cours;

public interface Cours {

	void inscription(int nbPlaces) throws PasAssezDePlacesException;

	int getNumeroCours();

}