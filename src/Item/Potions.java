package Item;


public abstract class Potions{
    protected int level;
    protected int price;
    public Potions(int level){
        this.level = level;
        this.price = 7*level;
    }

    public int getPrice(){
        return this.price;
    }
    public String toString(){
        return "Pocion de nivel "+level;
    }
}
