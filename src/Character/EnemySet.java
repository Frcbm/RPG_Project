package Character;

import Item.BareKnucle;

public class EnemySet {
    private Enemy[] enemySet;
    private int varianza;
    public EnemySet(int varianza){
        enemySet = new Enemy[5];
        this.varianza = varianza;
        enemySet[0] = new Enemy("Goblin", 1 + (varianza * 5 ), 1 + (varianza * 5 ), 1 + (varianza * 5 ), 1 + (varianza * 5 ), 1 + (varianza * 5 ), 1 + (varianza * 5 ), 1 + (varianza * 5 ), 1 + (varianza * 5 ), 1 + (varianza * 5 ), 0, 0, true, new BareKnucle() );
        enemySet[1] = new Enemy("Orc", 2 + (varianza * 5 ), 2 + (varianza * 5 ), 2 + (varianza * 5 ), 2 + (varianza * 5 ), 2 + (varianza * 5 ), 2 + (varianza * 5 ), 2 + (varianza * 5 ), 2 + (varianza * 5 ), 2 + (varianza * 5 ), 0, 0, true, new BareKnucle() );
        enemySet[2] = new Enemy("Harpy", 3 + (varianza * 5 ), 3 + (varianza * 5 ), 3 + (varianza * 5 ), 3 + (varianza * 5 ), 3 + (varianza * 5 ), 3 + (varianza * 5 ), 3 + (varianza * 5 ), 3 + (varianza * 5 ), 3 + (varianza * 5 ), 0, 0, true, new BareKnucle() );
        enemySet[3] = new Enemy("Griffin", 4 + (varianza * 5 ), 4 + (varianza * 5 ), 4 + (varianza * 5 ), 4 + (varianza * 5 ), 4 + (varianza * 5 ), 4 + (varianza * 5 ), 4 + (varianza * 5 ), 4 + (varianza * 5 ), 4 + (varianza * 5 ), 0, 0, true, new BareKnucle() );
        enemySet[4] = new Enemy("Dragon", 5 + (varianza * 5 ), 5 + (varianza * 5 ), 5 + (varianza * 5 ), 5 + (varianza * 5 ), 5 + (varianza * 5 ), 5 + (varianza * 5 ), 5 + (varianza * 5 ), 5 + (varianza * 5 ), 5 + (varianza * 5 ), 0, 0, true, new BareKnucle() );
    }
    public Enemy getEnemigo(int i){
        return enemySet[i];
    }


}
