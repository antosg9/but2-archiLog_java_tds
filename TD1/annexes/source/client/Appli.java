// Appli.java
package client;

import voiture.Voiture;
import voiture.Usine;
import static voiture.Usine.Version;

public class Appli {

  public static int testMoteur(Voiture v) {
    int cpt = 0;
    v.setVitesse(0);
    while (v.getVitesse() < v.getVitesseMaximale()) {
      v.accélérer();
      System.out.println(v + "accélère");
      ++cpt;
    }
    while (v.getVitesse() > 0){
      v.freiner();
      System.out.println(v + "freine");  
    }
    
    return cpt;
  }

  public static void main(String[] args) {
    Voiture[] tab = { 
        Usine.construit("607", Version.STANDARD),
        Usine.construit("Clio", Version.POPULAIRE),
        Usine.construit("Clio sport", Version.SUICIDAIRE), 
    };
    for (Voiture v : tab) {
      int nb = testMoteur(v);
      System.out.println(v + " nb d'accélérations -> " + nb);
    }
  }
}
