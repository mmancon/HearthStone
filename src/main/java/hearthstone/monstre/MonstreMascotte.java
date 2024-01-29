package hearthstone.monstre;

public class MonstreMascotte extends Monstre {
    private Monstre monstreBuffed;
    private int pourcentageBuff;

    public MonstreMascotte(int id, int pv, String nom, int pourcentageBuff) {
        super(id, pv, nom);
        this.pourcentageBuff = pourcentageBuff;
    }

    public void buffer(Monstre cible){ // La méthode rajoute un Buff en pourcentage, ce buff étant une variable,
        // le développeur peut choisir quelle fonctionnalité de son Monstre il buff
        // ex : un Classique peut buffer ses dégâts, un soigneur les pvs qu'il rend etc.
        if (!cible.getClass().equals(MonstreMascotte.class)) {
            if (!cible.isBuffed()) {
                setMonstreBuffed(cible);
                cible.setBuffed(true);
                cible.setMascotte(this);
                cible.setQuantiteBuff(this.getPourcentageBuff());
                printAndLog(getNom()+" buffe à "+getPourcentageBuff()+"% "+cible.getNom(), "info");
            } else printAndLog("Action interdite : "+cible.getNom()+" est déjà buffé par "+cible.getMascotte(), "warning");
        } else printAndLog("Action interdite : on ne peut pas buffer une Mascotte", "warning");
    }

    @Override
    protected void mourir(){
        Monstre cible = this.getMascotte();
        printAndLog(cible.getNom()+" n'est plus buffé.", "info");
        cible.setBuffed(false);
        cible.setMascotte(null);
    }

    protected void setMonstreBuffed(Monstre monstreBuffed) {
        this.monstreBuffed = monstreBuffed;
    }

    public Monstre getMonstreBuffed(){
        return monstreBuffed;
    }

    public int getPourcentageBuff() {
        return pourcentageBuff;
    }

    protected void setPourcentageBuff(int pourcentageBuff) {
        this.pourcentageBuff = pourcentageBuff;
    }

}
