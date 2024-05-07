package Item;

public class Staff extends Weapon{
    private final double magicMod;
    public Staff(String name, int damage, double magicMod, int price){

        super(name, damage, 1,3, price);
        this.magicMod = magicMod;

    }
    public int getDamage(){
        return damage;
    }
    public double getMagicMod(){
        return this.magicMod;
    }
}
