package hearthstone.monstre;

public abstract class Monstre {
    private int pv;
    private String nom;
    private int id;
    private boolean isProtected = false; // Lorsqu'un MonstreProtecteur protège cette entité : cette variable passe à vraie
    private MonstreProtecteur protecteur;
    private boolean isBuffed = false; // Lorsqu'un MonstreMascotte buff cette entité : cette variable passe à vraie
    private MonstreMascotte mascotte;

    public Monstre(int id, int pv, String nom) {
        this.id = id;
        this.pv = pv;
        this.nom = nom;
    }

    public void mourir() {
        // do smth
    }

    public void prendreDegats(int degats) {
        if (!this.isProtected || degats < 0) { // Si ce monstre n'est pas protégé OU s'il se fait soigner
            this.pv -= degats;
            if (this.pv <= 0) {
                this.mourir();
            }
        } else {
            protecteur.prendreDegats(degats);
        }
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
        if (!this.getClass().equals(MonstreProtecteur.class)) {
            this.protecteur = protecteur;
        }else System.out.println("Action interdite, on ne peut pas protéger un protecteur");
    }

    public MonstreMascotte getMascotte() {
        return mascotte;
    }

    protected void setMascotte(MonstreMascotte mascotte) {
        this.mascotte = mascotte;
    }
}
