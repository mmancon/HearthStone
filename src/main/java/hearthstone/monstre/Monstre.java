package hearthstone.monstre;

import java.util.logging.Logger;

public abstract class Monstre {
    Logger logger = Logger.getLogger("hearthstone.game");
    private int pv;
    private String nom;
    private int id;
    private boolean isProtected = false; // Lorsqu'un MonstreProtecteur protège cette entité : cette variable passe à vraie
    private MonstreProtecteur protecteur;
    private boolean isBuffed = false; // Lorsqu'un MonstreMascotte buff cette entité : cette variable passe à vraie
    private MonstreMascotte mascotte;
    private int QuantiteBuff = 0; // Une valeur de buff modifiée par la Mascotte, cette valeur peut s'ajouter à une fonctionnalité quelconque

    public Monstre(int id, int pv, String nom) {
        this.id = id;
        this.pv = pv;
        this.nom = nom;
    }

    public void prendreDegats(int degats) {
        if (!this.isProtected || degats < 0) { // Si ce monstre n'est pas protégé OU s'il se fait soigner
            this.pv -= degats;
            printAndLog(getNom()+" a désormais "+getPv()+" PVs.", "info");
            if (this.pv <= 0) {
                printAndLog(getNom()+" est mort !", "info");
                this.mourir();
            }
        } else {
            protecteur.prendreDegats(degats);
        }
    }

    protected abstract void mourir();

    public int getBuffedStat(int stat){ // Permet de calculer la valeur d'une stat, si elle est buffée, sa valeur augmentera
        return (int) Math.round(stat+stat*this.getQuantiteBuff()*0.01);
    }

    public void printAndLog(String message, String level) {
        System.out.println(message);
        if (level.equals("info"))
            logger.info(message);
        else if (level.equals("warning"))
            logger.warning(message);
    }

    // Getters et Setters
    public String getNom() {
        return nom;
    }

    public int getPv() {
        return pv;
    }

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    protected void setPv(int pv) {
        this.pv = pv;
    }

    protected void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isProtected() {
        return isProtected;
    }

    protected void setProtected(boolean aProtected) {
        isProtected = aProtected;
    }

    public boolean isBuffed() {
        return isBuffed;
    }

    protected void setBuffed(boolean buffed) {
        isBuffed = buffed;
    }

    public MonstreProtecteur getProtecteur() {
        return protecteur;
    }

    protected void setProtecteur(MonstreProtecteur protecteur) {
        this.protecteur = protecteur;
    }

    public MonstreMascotte getMascotte() {
        return mascotte;
    }

    protected void setMascotte(MonstreMascotte mascotte) {
        this.mascotte = mascotte;
    }

    public int getQuantiteBuff() {
        return QuantiteBuff;
    }

    protected void setQuantiteBuff(int quantiteBuff) {
        QuantiteBuff = quantiteBuff;
    }
}
