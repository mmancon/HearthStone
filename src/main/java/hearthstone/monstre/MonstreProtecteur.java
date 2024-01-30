package hearthstone.monstre;

import hearthstone.champion.Champion;

public class MonstreProtecteur extends Monstre {
    private Monstre monstreProtege;
    private Champion championProtege;
    private boolean isProtecting = false;
    public MonstreProtecteur(int id, int pv, String nom) {
        super(id, pv, nom);
    }

    public void proteger(Monstre cible){
        if (!cible.getClass().equals(MonstreProtecteur.class) && !isProtecting) {
            setMonstreProtege(cible);
            setProtecting(true);
            cible.setProtected(true);
            cible.setProtecteur(this);
            printAndLog(getNom()+" protège "+cible.getNom(),"info");
        } else {
            if (isProtecting)
                printAndLog("Ce monstre protège déjà une cible", "info");
            else
                printAndLog("Action interdite, on ne peut pas protéger un protecteur", "warning");
        }
    }

    public void proteger(Champion cible) {
        if (isProtecting)
            printAndLog("Ce monstre protège déjà une cible", "info");
        else {
            setChampionProtege(cible);
            setProtecting(true);
            cible.setProtected(true);
            cible.setProtecteur(this);
            printAndLog(getNom() + " protège " + cible.getNom(), "info");
        }
    }

    @Override
    protected void mourir(){
        Monstre cible = this.getMonstreProtege();
        Champion cibleChamp = this.getChampionProtege();
        if (isProtecting) {
            if (cible != null){
                cible.setProtecteur(null);
                cible.setProtected(false);
                printAndLog(getNom()+" ne protège plus "+cible.getNom(), "info");
            } else if (cibleChamp != null) {
                cibleChamp.setProtecteur(null);
                cibleChamp.setProtected(false);
                printAndLog(getNom()+" ne protège plus "+cibleChamp.getNom(), "info");
            }
        }

        if (this.isBuffed()) { // Si le monstre était buffé, on précise au buffer qu'il ne buffe plus
            this.getMascotte().setBuffing(false);
            this.getMascotte().setMonstreBuffed(null);
        }
    }

    protected void setMonstreProtege(Monstre monstreProtege) {
        this.monstreProtege = monstreProtege;
    }

    public Monstre getMonstreProtege(){
        return monstreProtege;
    }

    public Champion getChampionProtege() {
        return championProtege;
    }

    protected void setChampionProtege(Champion championProtege) {
        this.championProtege = championProtege;
    }

    public boolean isProtecting() {
        return isProtecting;
    }

    private void setProtecting(boolean protecting) {
        isProtecting = protecting;
    }
}
