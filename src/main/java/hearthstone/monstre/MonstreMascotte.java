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
        // ex : un Classique peut buffer ses dégâts, un protecteur ses pvs etc.
        if (!cible.getClass().equals(MonstreMascotte.class)) {
            setMonstreBuffed(cible);
            cible.setBuffed(true);
            cible.setMascotte(this);
            cible.setQuantiteBuff(this.getPourcentageBuff());
        } else System.out.println("Action interdite, on ne peut pas buffer une Mascotte");
    }

    @Override
    protected void mourir(){
        Monstre cible = this.getMascotte();
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
