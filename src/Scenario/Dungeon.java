package Scenario;
import Character.*;
import Item.*;


public class Dungeon {
    protected Characters player;
    private Enemy boss;

    public Dungeon(Characters player, int varianza, int lvlBoss, int vidaBoss, int strBoss, int defBoss, int agiBoss, int intelBoss, int manaBoss, int maxManaBoss, int expBoss, int goldBoss) {
        this.player = player;
        boss = new Enemy("Dragon", lvlBoss, vidaBoss, vidaBoss, strBoss, defBoss,agiBoss, intelBoss, manaBoss, maxManaBoss, expBoss, goldBoss, true, new BareKnucle());
    }

    public Enemy getBoss(){
        return boss;
    }


}