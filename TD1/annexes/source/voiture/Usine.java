package voiture;

import voiture.freins.FreinsPopulaires;
import voiture.freins.FreinsStandard;
import voiture.moteurs.MoteurPopulaire;
import voiture.moteurs.MoteurStandard;

public class Usine {
  public static enum Version {
    STANDARD, POPULAIRE, SUICIDAIRE;
  }

  public static Voiture construit(String nom, Version v) {
    switch (v) {
    case STANDARD:
      return new Voiture(nom, new FreinsStandard(), new MoteurStandard());
    case POPULAIRE:
      return new Voiture(nom, new FreinsPopulaires(), new MoteurPopulaire());
    case SUICIDAIRE:
      return new Voiture(nom, new FreinsPopulaires(), new MoteurStandard());
    }
    return null;
  }
}
