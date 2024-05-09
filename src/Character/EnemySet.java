package Character;

import Item.BareKnucle;

public class EnemySet {
    private Enemy[] enemySet;
    public EnemySet(int varianza){
        enemySet = new Enemy[4];
        enemySet[0] = new Enemy("Goblin", 1 + (varianza * 5 ), 50 + (varianza * 5 ), 50 + (varianza * 5 ), 10 + (varianza * 5 ), 1 + (varianza * 5 ), 1 + (varianza * 5 ), 1 + (varianza * 5 ), 1 + (varianza * 5 ), 1 + (varianza * 5 ), 10, 0, true, new BareKnucle() );
        enemySet[1] = new Enemy("Orc", 2 + (varianza * 5 ), 150 + (varianza * 5 ), 150 + (varianza * 5 ), 15 + (varianza * 5 ), 2 + (varianza * 5 ), 2 + (varianza * 5 ), 2 + (varianza * 5 ), 2 + (varianza * 5 ), 2 + (varianza * 5 ), 15, 0, true, new BareKnucle() );
        enemySet[2] = new Enemy("Harpy", 3 + (varianza * 5 ), 250 + (varianza * 5 ), 250 + (varianza * 5 ), 25 + (varianza * 5 ), 3 + (varianza * 5 ), 3 + (varianza * 5 ), 3 + (varianza * 5 ), 3 + (varianza * 5 ), 3 + (varianza * 5 ), 20, 0, true, new BareKnucle() );
        enemySet[3] = new Enemy("Griffin", 4 + (varianza * 5 ), 400 + (varianza * 5 ), 400 + (varianza * 5 ), 35 + (varianza * 5 ), 4 + (varianza * 5 ), 4 + (varianza * 5 ), 4 + (varianza * 5 ), 4 + (varianza * 5 ), 4 + (varianza * 5 ), 40, 0, true, new BareKnucle() );
        //enemySet[4] = new Enemy("Dragon", 5 + (varianza * 5 ), 750 + (varianza * 5 ), 5 + (varianza * 5 ), 50 + (varianza * 5 ), 5 + (varianza * 5 ), 5 + (varianza * 5 ), 5 + (varianza * 5 ), 5 + (varianza * 5 ), 5 + (varianza * 5 ), 75, 0, true, new BareKnucle() );
    }
    public Enemy getEnemigo(int i){
        return enemySet[i];
    }
}
