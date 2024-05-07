package Item;

public class Bow extends Weapon{

    public Bow(String name, int damage, int price){
        super(name, damage, 2,2,price);
    }

    public int getDamage(){
        return damage;
    }
}
