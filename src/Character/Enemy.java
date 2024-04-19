package Character;

import Item.Weapon;

public class Enemy extends Characters {
    public Enemy(String name, int level, int hp, int maxHp, int str, int def, int agl, int intel, int mana, int maxMana, int exp, int gold, boolean condition, Weapon weapon){
        super(name, level,hp,maxHp,str,def,agl,intel,mana, maxMana,exp, gold, condition, weapon);
    }

}

