package Item;

public class Sword extends Weapon{
    public Sword(String name, int damage){
        super(name, damage, 1,1);
    }
    public int getDamage(){
        return damage;
    }

}
