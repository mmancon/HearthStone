package hearthstone.champion;

import hearthstone.monstre.Monstre;
public abstract class ChampionAttaquant extends Champion {
    private int degats;

    public ChampionAttaquant(int id, int pv, String nom, String cheminVersLeDeck,int degats) {
        super(id, nom, cheminVersLeDeck);
        this.degats = degats;
    }

    @Override
    public void utiliserCapacite(Monstre cible) {
        if (!capaciteUtilisee) {
            capaciteUtilisee = true; // Marquer la capacité comme utilisée
            printAndLog(getNom() + " utilise sa capacité pour infliger "+degats+ " à "+cible.getNom(), "info");
            cible.prendreDegats(degats);
        } else {
            printAndLog("Impossible, la capacité a déjà été utilisée ce tour-ci.","info");
        }
    }
    @Override
    public void utiliserCapacite(Champion cible) {
        if (!capaciteUtilisee) {
            capaciteUtilisee = true; // Marquer la capacité comme utilisée
            printAndLog(getNom() + " utilise sa capacité pour infliger "+degats+ " à "+cible.getNom(), "info");
            cible.prendreDegats(degats);
        } else {
            printAndLog("Impossible, la capacité a déjà été utilisée ce tour-ci.","info");
        }
    }


    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }
}
