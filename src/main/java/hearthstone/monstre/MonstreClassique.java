package hearthstone.monstre;

import hearthstone.champion.Champion;

public class MonstreClassique extends Monstre {
    private int degats;
    public MonstreClassique(int id, int pv, String nom, int degats) {
        super(id, pv, nom);
        this.degats = degats;
    }

    public void attaquer(Monstre cible){
        if (this.isBuffed()) {
            printAndLog(getNom()+" attaque "+cible.getNom()+" et lui inflige "+(100+getQuantiteBuff())+"% de "+getDegats()+" ! Pour un total de : "+getBuffedStat(degats), "info");
            cible.prendreDegats(this.getBuffedStat(degats));
        }
        else {
            printAndLog(getNom()+" attaque "+cible.getNom()+" et lui inflige "+getDegats(), "info");
            cible.prendreDegats(degats);
        }

    }

    public void attaquer(Champion cible){
        if (this.isBuffed()) {
            printAndLog(getNom()+" attaque "+cible.getNom()+" et lui inflige "+(100+getQuantiteBuff())+"% de "+getDegats()+" ! Pour un total de : "+getBuffedStat(degats), "info");
            cible.prendreDegats(this.getBuffedStat(degats));
        }
        else {
            printAndLog(getNom()+" attaque "+cible.getNom()+" et lui inflige "+getDegats(), "info");
            cible.prendreDegats(degats);
        }

    }

    public int getDegats(){
            return degats;
    }


    protected void setDegats(int degats){
        this.degats = degats;
    }

    @Override
    protected void mourir() {
        if (this.isBuffed()) { // Si le monstre était buffé, on précise au buffer qu'il ne buffe plus
            this.getMascotte().setBuffing(false);
            this.getMascotte().setMonstreBuffed(null);
        }
    }
}
