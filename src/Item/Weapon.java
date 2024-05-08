package Item;

public abstract class Weapon {
    protected int damage;
    protected String name;
    protected int range;//Todavia no se usa para nada
    protected int price;
    /*
       Leyenda de tipos de armas:
           0. Manos desnudas
           1. Espadas
           2. Arcos
           3. Bastones
    */
    protected int type; //Tipo de arma: espada, arco, baston....


    public Weapon(String name, int damage, int range, int type, int price){
        this.damage = damage;
        this.name = name;
        this.range = range;
        this.type = type;
        this.price = price;
    }
    public abstract int getDamage();
    public int getPrice(){
        return this.price;
    }
    public double getMagicMod(){
        return 1;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getType(){
        return this.type;
    }

    public String toString(){
        return "Este arma es "+name+" y su daño es"+damage;
    }
    public boolean isWeapon(){
        return true;
    }


}
