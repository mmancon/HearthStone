package hearthstone.champion;

import hearthstone.monstre.Monstre;
import hearthstone.monstre.MonstreFactory;

public class ChampionSniper extends Champion {
    private int degats;

    public ChampionSniper(int id, String nom, String cheminVersLeDeck) {
            super(id, nom, cheminVersLeDeck);
    }

    @Override
    public void mourir() {

    }

    @Override
    public void utiliserCapacite(Champion cible) {

    }

    @Override
    public void utiliserCapacite(Monstre cible) {
      
    }

    @Override
    public void utiliserCapacite() {
        getListener().attaquerAdversaire(2);
        // Logique pour attaquer un champion
        printAndLog(this.getNom() + " attaque avec " + this.degats + " de dégâts.","info");
    }


    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }
}
