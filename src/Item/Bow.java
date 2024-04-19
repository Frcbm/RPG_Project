package Item;

public class Bow extends Weapon{

    public Bow(String name, int damage){
        super(name, damage, 2,2);
    }

    public int getDamage(){
        return damage;
    }
}
