package Scenario;

import Character.*;
import Item.BareKnucle;

public class DungeonSet {

    private final Dungeon dungeonSet[];

    public DungeonSet(int varianza, int dunLvl){
        dungeonSet = new Dungeon[3];
        dungeonSet[0] = new Dungeon(dungeonSet[0].player, varianza, 5 + (1 * varianza), 300 + (50* varianza) + (50 * dunLvl),40 + (5* varianza) + (5 * dunLvl),
                40 + (5* varianza) + (5 * dunLvl), 30 + (5* varianza) + (5 * dunLvl), 30 + (5* varianza) + (5 * dunLvl), 30 + (5 * varianza) + (5 * dunLvl), 30 + (5 * varianza) + (5 * dunLvl), 30 + (5 * varianza) + (5 * dunLvl), 30 + (5 * varianza) + (5 * dunLvl));
        dungeonSet[1] = new Dungeon(dungeonSet[1].player, varianza, 5 + (1 * varianza), 300 + (50* varianza) + (50 * dunLvl),40 + (5* varianza) + (5 * dunLvl),
                40 + (5* varianza) + (5 * dunLvl), 30 + (5* varianza) + (5 * dunLvl), 30 + (5* varianza) + (5 * dunLvl), 30 + (5 * varianza) + (5 * dunLvl), 30 + (5 * varianza) + (5 * dunLvl), 30 + (5 * varianza) + (5 * dunLvl), 30 + (5 * varianza) + (5 * dunLvl));
        dungeonSet[2] = new Dungeon(dungeonSet[2].player, varianza, 5 + (1 * varianza), 300 + (50* varianza) + (50 * dunLvl),40 + (5* varianza) + (5 * dunLvl),
                40 + (5* varianza) + (5 * dunLvl), 30 + (5* varianza) + (5 * dunLvl), 30 + (5* varianza) + (5 * dunLvl), 30 + (5 * varianza) + (5 * dunLvl), 30 + (5 * varianza) + (5 * dunLvl), 30 + (5 * varianza) + (5 * dunLvl), 30 + (5 * varianza) + (5 * dunLvl));
    }
    public Dungeon get(int i){
        return dungeonSet[i];
    }
}
