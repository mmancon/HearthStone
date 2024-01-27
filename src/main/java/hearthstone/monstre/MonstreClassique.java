package hearthstone.monstre;

public class MonstreClassique extends Monstre {
    private int degats;
    public MonstreClassique(int id, int pv, String nom, int degats) {
        super(id, pv, nom);
        this.degats = degats;
    }

    public void attaquer(Monstre cible){
        if (this.isBuffed())
            cible.prendreDegats(getBuffedStat(degats));
        else cible.prendreDegats(degats);

    }

    public int getDegats(){
        if (this.isBuffed())
            return getBuffedStat(degats);
        else
            return degats;
    }

    protected void setDegats(int degats){
        this.degats = degats;
    }

    @Override
    protected void mourir() {
        // do smth
    }
}
