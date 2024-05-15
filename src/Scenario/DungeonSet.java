package Scenario;

import Character.*;
import Item.BareKnucle;

public class DungeonSet {
    private final Dungeon dungeonSet[];

    public DungeonSet(int varianza, int dunLvl, Characters player){
        dungeonSet = new Dungeon[3];
        dungeonSet[0] = new Dungeon(player, varianza, 5 + (1 * varianza), 200 + (50* varianza) + (50 * dunLvl),20 + (5* varianza) + (5 * dunLvl),
                20 + (5* varianza) + (5 * dunLvl), 30 + (5* varianza) + (5 * dunLvl), 30 + (5* varianza) + (5 * dunLvl), 30 + (5 * varianza) + (5 * dunLvl), 30 + (5 * varianza) + (5 * dunLvl), 30 + (5 * varianza) + (5 * dunLvl), 30 + (5 * varianza) + (5 * dunLvl));
        dungeonSet[1] = new Dungeon(player, varianza, 5 + (1 * varianza), 200 + (50* varianza) + (50 * dunLvl),20 + (5* varianza) + (5 * dunLvl),
                20 + (5* varianza) + (5 * dunLvl), 30 + (5* varianza) + (5 * dunLvl), 30 + (5* varianza) + (5 * dunLvl), 30 + (5 * varianza) + (5 * dunLvl), 30 + (5 * varianza) + (5 * dunLvl), 30 + (5 * varianza) + (5 * dunLvl), 30 + (5 * varianza) + (5 * dunLvl));
        dungeonSet[2] = new Dungeon(player, varianza, 5 + (1 * varianza), 200 + (50* varianza) + (50 * dunLvl),20 + (5* varianza) + (5 * dunLvl),
                20 + (5* varianza) + (5 * dunLvl), 30 + (5* varianza) + (5 * dunLvl), 30 + (5* varianza) + (5 * dunLvl), 30 + (5 * varianza) + (5 * dunLvl), 30 + (5 * varianza) + (5 * dunLvl), 30 + (5 * varianza) + (5 * dunLvl), 30 + (5 * varianza) + (5 * dunLvl));
    }
    public Dungeon get(int i){
        return dungeonSet[i];
    }
}
