package Item;

public class Sword extends Weapon{
    public Sword(String name, int damage, int price){
        super(name, damage, 1,1,price);
    }
    public int getDamage(){
        return damage;
    }

}
