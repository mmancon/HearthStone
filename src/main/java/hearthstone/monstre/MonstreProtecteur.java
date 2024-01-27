package hearthstone.monstre;

public class MonstreProtecteur extends Monstre {
    private Monstre monstreProtege;
    public MonstreProtecteur(int id, int pv, String nom) {
        super(id, pv, nom);
    }

    public void proteger(Monstre cible){
        if (!cible.getClass().equals(MonstreProtecteur.class)) {
            setMonstreProtege(cible);
            cible.setProtected(true);
            cible.setProtecteur(this);
        } else System.out.println("Action interdite, on ne peut pas protéger un protecteur");
    }

    protected void setMonstreProtege(Monstre monstreProtege) {
        this.monstreProtege = monstreProtege;
    }

    public Monstre getMonstreProtege(){
        return monstreProtege;
    }

    @Override
    protected void mourir(){
        Monstre cible = this.getMonstreProtege();
        cible.setProtected(false);
        cible.setProtecteur(null);
    }

}
