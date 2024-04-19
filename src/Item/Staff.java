package Item;

public class Staff extends Weapon{
    public Staff(String name, int damage){
        super(name, damage, 1,3);
    }
    public int getDamage(){
        return damage;
    }
}
