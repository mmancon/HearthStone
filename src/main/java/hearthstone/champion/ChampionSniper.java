package hearthstone.champion;

import hearthstone.monstre.MonstreFactory;

public abstract class ChampionSniper extends Champion {
    private int degats;

    public ChampionSniper(int id, String nom, String cheminVersLeDeck) {
            super(id, nom, cheminVersLeDeck);
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
