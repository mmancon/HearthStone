package hearthstone.champion;

import hearthstone.monstre.Monstre;
import hearthstone.monstre.MonstreClassique;
import hearthstone.monstre.MonstreFactory;

public class ChampionInvocateur extends Champion {
    private MonstreFactory monstreFactory;

    public ChampionInvocateur(int id, String nom, String cheminVersLeDeck, MonstreFactory monstreFactory) {
        super(id, nom, cheminVersLeDeck);
        this.monstreFactory = monstreFactory;
        printAndLog("Création d'un Champion de type Invocateur du nom de "+this.getNom()+" et ayant "+this.getPv()+" PVs", "info");
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
        MonstreClassique monstreInvoque = monstreFactory.buildClassique(getMain().size(),100,"Monstre invoqué",50);
        printAndLog(this.getNom() + " utilise sa capacité pour invoquer : " + monstreInvoque.getNom(),"info");

    }

    // Getters et Setters
    public MonstreFactory getMonstreFactory() {
        return monstreFactory;
    }

    protected void setMonstreFactory(MonstreFactory monstreFactory) {
        this.monstreFactory = monstreFactory;
    }
}
