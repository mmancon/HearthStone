package hearthstone.champion;

import hearthstone.monstre.Monstre;
import hearthstone.monstre.MonstreClassique;
import hearthstone.monstre.MonstreFactory;

public class ChampionInvocateur extends Champion {
    private MonstreFactory monstreFactory;

    public ChampionInvocateur(int id, String nom, String cheminVersLeDeck, MonstreFactory monstreFactory) {
        super(id, nom, cheminVersLeDeck);
        this.monstreFactory = monstreFactory;
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
        // Ici, nous invoquons un MonstreClassique en utilisant MonstreFactory
        MonstreClassique monstreInvoque = monstreFactory.buildClassique(5,100,"m1",50);
        printAndLog(this.getNom() + " utilise sa capacité pour invoquer : " + monstreInvoque.getNom(),"info");

        // Ajoutez ici la logique pour ajouter le monstre au jeu, comme le placer sur le plateau.
    }

    // Getters et Setters
    public MonstreFactory getMonstreFactory() {
        return monstreFactory;
    }

    public void setMonstreFactory(MonstreFactory monstreFactory) {
        this.monstreFactory = monstreFactory;
    }
}
