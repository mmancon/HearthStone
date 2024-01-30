package hearthstone.monstre;

import java.util.logging.Logger;

public interface MonstreBuilder {
        Logger logger = Logger.getLogger("hearthstone.game");
        Monstre build();

        MonstreBuilder setId(int id);

        MonstreBuilder setNom(String nom);

        MonstreBuilder setPv(int pv);


}
