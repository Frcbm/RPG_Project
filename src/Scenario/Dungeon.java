package Scenario;
import Character.*;
import Item.*;


public class Dungeon {
    protected Characters player;
    private EnemySet enemigos;
    private Enemy boss;
    private static int dunLvL = 2;

    public Dungeon(Characters player, int varianza, int lvlBoss, int vidaBoss, int strBoss, int defBoss, int agiBoss, int intelBoss, int manaBoss, int maxManaBoss, int expBoss, int goldBoss) {
        this.player = player;
        enemigos = new EnemySet(varianza);
        boss = new Enemy("Dragon", lvlBoss, vidaBoss, vidaBoss, strBoss, defBoss,agiBoss, intelBoss, manaBoss, maxManaBoss, expBoss, goldBoss, true, new BareKnucle());
    }
    public int getDunLvL(){
        return dunLvL;
    }
    public int aumentardunLvl(){


        
        if(dunLvL++ >= 6){
            dunLvL = 1;
        }
        return dunLvL++;
    }

    public void runMaze(){
        for(int i = 0 ; i < 4 ; i++){
            player.combat(player, enemigos.getEnemigo((int)(Math.random() * (getDunLvL()) - 1)));//
        }
        player.combat(player, boss);
        System.out.println("Enhorabuena, has terminado la mazmorra!");
        aumentardunLvl();
    }


}