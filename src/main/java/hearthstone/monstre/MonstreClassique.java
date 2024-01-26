package hearthstone.monstre;

public class MonstreClassique extends Monstre {
    private int degats;
    public MonstreClassique(int id, int pv, String nom, int degats) {
        super(id, pv, nom);
        this.degats = degats;
    }

    public void attaquer(Monstre cible){
        cible.prendreDegats(degats);
    }

    public int getDegats(){
        return degats;
    }

    protected void setDegats(int degats){
        this.degats = degats;
    }
}
