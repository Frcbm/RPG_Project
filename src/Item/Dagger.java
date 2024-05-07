package Item;

public class Dagger extends Weapon{
    public Dagger(String name, int damage, int price){
        super(name, damage, 1,4, price);
    }
    public int getDamage(){
        return damage;
    }
}
