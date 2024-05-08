package Item;
import Character.*;


public abstract class Potions{
    protected int level;
    protected int price;
    protected int type;
    public Potions(int level){
        this.level = level;
        this.price = 7*level;
    }
    public abstract void use(Characters player);
    public int getType(){
        return this.type;
    }

    public int getPrice(){
        return this.price;
    }
    public String toString(){
        return "Pocion de nivel "+level;
    }
}
