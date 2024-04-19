package Item;

public class Dagger extends Weapon{
    public Dagger(String name, int damage){
        super(name, damage, 1,4);
    }
    public int getDamage(){
        return damage;
    }
}
