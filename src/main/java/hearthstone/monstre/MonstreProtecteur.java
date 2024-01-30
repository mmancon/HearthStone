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
            printAndLog(getNom()+" protège "+cible.getNom(),"info");
        } else printAndLog("Action interdite, on ne peut pas protéger un protecteur", "warning");
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
        printAndLog(cible.getNom()+" n'est plus protégé.", "info");
        cible.setProtected(false);
        cible.setProtecteur(null);
    }
}
