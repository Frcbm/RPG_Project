package Item;

public class BareKnucle extends Weapon{
    public BareKnucle(){
        super("Manos desnudas", 0, 1,0, 0);
    }
    public int getDamage(){
        return this.damage;
    }
}
