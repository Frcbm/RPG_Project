package Character;
import Item.*;
import java.util.*;


public abstract class Characters implements CharacterAction {
    protected String name;
    protected stats level;
    protected stats hp;
    protected stats maxHp;
    protected stats str;
    protected stats def;
    protected stats intel;
    protected stats agl;
    protected stats mana;
    protected stats maxMana;
    protected stats exp;
    protected stats gold;

    protected Weapon weapon;
    protected List<Weapon> Inventory = new ArrayList<>();
    protected boolean condition; //True para vivo, false para muerto
    stats[] estadisticas = {level, hp, maxHp, str, def, intel, agl, mana, maxMana, exp, gold};

    public Characters(){

    }

    public Characters(String name, int level, int hp, int maxHp, int str, int def, int agl, int intel, int mana, int maxMana, int exp, int gold, boolean condition, Weapon weapon){
        this.level = new stats(level);;
        this.hp = new stats(hp);
        this.maxHp = new stats(maxHp);
        this.str = new stats(str);
        this.def = new stats(def);
        this.agl = new stats(agl);
        this.intel = new stats(intel);
        this.mana = new stats(mana);
        this.maxMana = new stats(maxMana);
        this.exp = new stats(exp);
        this.name = name;
        this.condition = condition;
        this.weapon = weapon;

    }

    public void getStats(){
        System.out.println("Fuerza: "+str.getStats()+
                " Agilidad: "+agl.getStats()+
                " Inteligencia: "+intel.getStats());
    }
    public void setHp(int hp){
        this.hp.setStats(hp);
    }
    public stats getExp(){
        return this.exp;
    }
    public stats getMaxHp(){return this.maxHp;}
    public stats getMaxMana(){return this.maxMana;}
    public stats getMana(){
        return this.mana;
    }
    public void setMana(int mana){this.mana.setStats(mana);}
    public void setExp(int exp){ //Setea la experiencia a un valor determinado
        this.exp.setStats(exp);
    }
    public stats getLvl(){
        return this.level;
    }
    public stats getHp(){
        return this.hp;
    }
    public String getName(){
        return this.name;
    }
    public boolean isAlive(){
        return this.condition;
    }
    public void defend(){/*No hace nada todavia*/};
    public void Skill(Characters enemy){}
    public void addToInvetory(Weapon weapon){
        Inventory.add(weapon);
    }
    public void changeWeapon(Weapon newWeapon){
        System.out.println(name+" se ha equipado "+newWeapon.getName());
        this.weapon = newWeapon;
    }

    public void attack(Characters target){ //Ataque básico cuerpo a cuerpo
        int accuracy = (int) (Math.random()*100) + 1; //Roll para acertar o fallar
        int critical = (int) (Math.random()*10) + 1; //Roll para golpe crítico
        accuracy -= this.agl.getStats();
        System.out.println(name + " ataca a " + target.name);
        if(accuracy <= 75 && target.isAlive()) {
            int damage = ((int) (str.getStats() * 1.5)) + weapon.getDamage(); //Calculo del daño total
            if(critical == 10){
                damage *= 2; //El golpe crítico dobla el daño
                System.out.println("Golpe crítico");
            }
            int damageTaken = damage - target.def.getStats();
            if (damageTaken <= 0) {
                damageTaken = 0;
            }
            target.takeDamage(damageTaken);
            System.out.println("El objetivo recibe " + damageTaken + " puntos de daño");
            if (!target.isAlive()) {
                System.out.println("El objetivo ha muerto!");
            }
        }else if(!target.isAlive()){
            System.out.println(target.getName()+" ya esta muerto");
        }else{
            System.out.println("El ataque ha fallado!");
        }
    }


    private void getInventory(){
        for(int i = 0; i < Inventory.size(); i++){
            System.out.println(Inventory.get(i).toString());
        }
    }
    public void unequipWeapon(){
        if(this.weapon.getType() != 0) {
            System.out.println(name + " se ha desequipado " + this.weapon.getName());
            this.weapon = new BareKnucle();
        } else {
            System.out.println(name+" no tiene un arma equipada");
        }
    }
    public void takeDamage(int damage){
        hp.setStats(hp.getStats() - damage);
        if(hp.getStats() <= 0){
            hp.setStats(0);
            condition = false;
        }
    }
    private int menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Es tu turno");
        System.out.println("Elige una acción");
        System.out.println("1. Atacar\n" +
                "2. Cambiar de arma\n" +
                "3. Habilidad\n" +
                "4. Analizar enemigo");
        int opcion = sc.nextInt();
        while(opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4){
            System.out.println("Introduce una de las posibles acciones");
            opcion = sc.nextInt();
        }
        return opcion;
    }
    public boolean combat(Characters player, Characters enemy){
        Scanner sc = new Scanner(System.in);
        System.out.println(enemy.name+" te corta el paso!!");
        int opcion;
        while(player.isAlive() && enemy.isAlive()){
            System.out.println("Elige tu acción");
            opcion = menu();
            switch(opcion){
                case 1:
                    player.attack(enemy);
                    break;
                case 2:
                    if(Inventory.isEmpty()){
                        System.out.println("El inventario esta vacio!");
                    }else{
                        System.out.println("Que arma quieres equipar?");
                        getInventory();
                        System.out.println("Elige que arma quieres usar");
                        player.changeWeapon(Inventory.get(sc.nextInt()));
                    }
                    break;
                case 3:
                    player.Skill(enemy);
                    break;
                case 4:
                    System.out.println(enemy.toString());
                    break;
                default:
                    break;
            }
            if(enemy.isAlive()){
                enemy.attack(player);
            }
        }
        if(player.isAlive()){
            player.gainExp(enemy);
            System.out.println("Experiencia actual: "+player.getExp());
            if(player.exp.getStats() >= 100) {
                player.lvlUp();
            }
        } //Si el jugador sigue vivo al terminar el combate gana experiencia
        return player.isAlive();
    }
    public void gainExp(Characters enemy){
        int lvlDiff = level.getStats() - enemy.level.getStats();
        switch(lvlDiff){
            case 0:
                exp.setStats(exp.getStats() + enemy.exp.getStats());
                break;
            case -1,-2:
                exp.setStats((int)(exp.getStats() + enemy.exp.getStats() * 1.5));
                break;
            case -3,-4,-5,-6:
                exp.setStats(exp.getStats() + enemy.exp.getStats()* (int)(Math.pow(lvlDiff,2)));
                break;
            case 1,2:
                exp.setStats(exp.getStats() + enemy.exp.getStats() / 2);
                break;
            default:
                exp.setStats(exp.getStats());
                break;
        }
    }
    public void lvlUp(){
        System.out.println("Has subido de nivel!");
        while(this.exp.getStats() >= 100){
            this.level.setStats(this.level.getStats() + 1);
            this.level.setStats(this.level.getStats() - 100);
            if(this.exp.getStats() <= 0)this.exp.setStats(0);
            assignPoints();
        }
    }
    protected void assignPoints(){
        Scanner sc = new Scanner(System.in);
        int points = 5;
        while(points > 0) {
            System.out.println("Que estadística quieres aumentar?");
            System.out.println("1. Fuerza\n" +
                    "2. Agilidad\n" +
                    "3. Inteligencia");

            switch (sc.nextInt()) {
                case 1:
                    this.str.setStats(this.str.getStats() + 1);
                    points--;
                    break;
                case 2:
                    this.agl.setStats(this.agl.getStats() + 1);
                    points--;
                    break;
                case 3:
                    this.intel.setStats(this.intel.getStats() + 1);
                    points--;
                    break;
                default:
                    System.out.println("No es una opción válida");
                    break;
            }
        }
    }


}
