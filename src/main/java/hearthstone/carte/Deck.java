package hearthstone.carte;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Deck {
    public ArrayList<Carte> deck = new ArrayList<>();

    private static String lireContenuFichier(String cheminFichier) {
        try {
            Path chemin = Paths.get(cheminFichier);
            return Files.readString(chemin);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
