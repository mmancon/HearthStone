package hearthstone.monstre;

public class MonstreProtecteur extends Monstre {
    private Monstre monstreProtege;
    public MonstreProtecteur(int id, int pv, String nom) {
        super(id, pv, nom);
    }

    public void proteger(Monstre cible){
        setMonstreProtege(cible);
        cible.setProtected(true);
        cible.setProtecteur(this);
    }

    protected void setMonstreProtege(Monstre monstreProtege) {
        this.monstreProtege = monstreProtege;
    }

    public Monstre getMonstreProtege(){
        return monstreProtege;
    }


}
