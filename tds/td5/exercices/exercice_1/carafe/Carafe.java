package carafe;

public interface Carafe {

	  public void remplir();

	  public void retirer(int q) throws InterruptedException;

	  public boolean estVide();
	  
	  public String toString();

}
