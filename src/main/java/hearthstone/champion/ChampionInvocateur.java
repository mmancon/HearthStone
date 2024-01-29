package hearthstone.champion;

import hearthstone.monstre.Monstre;
import hearthstone.monstre.MonstreClassique;
import hearthstone.monstre.MonstreFactory;

public abstract class ChampionInvocateur extends Champion {
    private MonstreFactory monstreFactory;

    public ChampionInvocateur(int id, int pv, String nom, MonstreFactory monstreFactory) {
        super(id, pv, nom);
        this.monstreFactory = monstreFactory;
    }

    @Override
    public void utiliserCapacite(Monstre monstre) {
        // Ici, nous invoquons un MonstreClassique en utilisant MonstreFactory
        MonstreClassique monstreInvoque = monstreFactory.buildClassique(5,100,"m1",50);
        System.out.println(this.getNom() + " utilise sa capacité pour invoquer : " + monstreInvoque.getNom());

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
