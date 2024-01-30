package hearthstone.champion;

import hearthstone.monstre.Monstre;
import hearthstone.monstre.MonstreMascotte;
import hearthstone.monstre.MonstreProtecteur;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Champion {
    private int pv;
    private String nom;
    public boolean capaciteUtilisee;
    private int id;
    private String capacite;
    private ChampionListener listener;
    private ArrayList<Monstre> main;
    private ArrayList<Monstre> terrain;
    private boolean isProtected = false; // Lorsqu'un MonstreProtecteur protège cette entité : cette variable passe à vraie
    private MonstreProtecteur protecteur;
    private MonstreMascotte mascotte;

    public Champion(int id, int pv, String nom) {
        this.id = id;
        this.pv = pv;
        this.nom = nom;
        main = new ArrayList<>();
        terrain = new ArrayList<>();
    }

    public abstract void mourir();

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
    public boolean capaciteUtilisee() {
        return capaciteUtilisee;
    }
    public ArrayList<Monstre> getTerrain() {
        return terrain;
    }
    public ArrayList<Monstre> getMain(){
        return main;
    }
    public void setCapaciteUtilisee(boolean capaciteUtilisee) {
        this.capaciteUtilisee = capaciteUtilisee;
    }
    public abstract void utiliserCapacite(Champion cible);
    public abstract void utiliserCapacite(Monstre cible);

    protected void setId(int id) {
        this.id = id;
    }

    public void MortMonstre(Monstre m) {
        getTerrain().remove(m);
    }

    public void jouerMonstre(Monstre m){
        main.remove(m);
        terrain.add(m);
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
    public ChampionListener getListener() {
        return listener;
    }

    public void setListener(ChampionListener listener) {
        this.listener = listener;
    }

    protected void setProtected(boolean aProtected) {
        isProtected = aProtected;
    }

    public abstract void utiliserCapacite();
}