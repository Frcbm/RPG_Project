package Character;
import Item.*;
import Scenario.Maps;
import Scenario.Plains;

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
    protected List<Potions> Alchemy = new ArrayList<>();

    protected boolean condition; //True para vivo, false para muerto
    private Maps actualMap;
    private String[] nombresStats ={"level", "hp", "maxHp", "str", "def", "intel", "agl", "mana", "maxMana", "exp","gold"};
    private stats[] estadisticas;
    private EnemySet enemigos;
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
        this.gold = new stats(gold);
        this.estadisticas = new stats[10];
        setStats();
        actualMap = new Plains();
        Alchemy.add(new HpPotion(1));
    }
    public Maps getActualMap(){
        return actualMap;
    }
    public void setStats(){
        this.estadisticas[0] = level;
        this.estadisticas[1] = hp;
        this.estadisticas[2] = maxHp;
        this.estadisticas[3] = str;
        this.estadisticas[4] = def;
        this.estadisticas[5] = agl;
        this.estadisticas[6] = intel;
        this.estadisticas[7] = mana;
        this.estadisticas[8] = maxMana;
        this.estadisticas[9] = exp;


    }
    public void getStats(){
        System.out.println("Fuerza: "+str.getStats()+
                " Agilidad: "+agl.getStats()+
                " Inteligencia: "+intel.getStats());
    }
    public void setHp(int hp){
        this.hp.setStats(hp);
    }

    public int getGold(){
        return this.gold.getStats();
    }
    public void buyItem(int gold){
        this.gold.setStats(this.gold.getStats() - gold);
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
    public void addToAlchemy(Potions potion){
        Alchemy.add(potion);
    }
    public void changeWeapon(int opcion){
        this.weapon = Inventory.get(opcion);
        System.out.println("Se ha equipado "+this.weapon.getName());
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
            System.out.println(i+" "+Inventory.get(i).toString());
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
        boolean correcto = true;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.println("Es tu turno");
                System.out.println("Elige una acción");
                System.out.println("1. Atacar\n" +
                        "2. Inventario\n" +
                        "3. Habilidad\n" +
                        "4. Analizar enemigo");
                int opcion = sc.nextInt();
                while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4) {
                    System.out.println("Introduce una de las posibles acciones");
                    opcion = sc.nextInt();
                }
                correcto = true;
                return opcion;
            } catch (InputMismatchException e) {
                correcto = false;
                sc.next();
            }

        }while(!correcto);
        return 0;
    }
    public boolean combat(Characters player, Characters enemy){
        Scanner sc = new Scanner(System.in);
        System.out.println(enemy.name+" te corta el paso!!");
        System.out.println(enemy.getHp().getStats());
        int opcion;
        while(player.isAlive() && enemy.isAlive()){
            System.out.println("Elige tu acción");
            opcion = menu();
            switch(opcion){
                case 1:
                    player.attack(enemy);
                    break;
                case 2:

                        manageInvent(player);

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
            System.out.println("Experiencia actual: "+player.getExp().getStats());
            if(player.exp.getStats() >= 100) {
                player.lvlUp();
            }
            System.out.println(enemy.getHp().getStats());
            enemy.setHp(enemy.getMaxHp().getStats());
            System.out.println(enemy.getHp().getStats());
            enemy.condition = true;
        } //Si el jugador sigue vivo al terminar el combate gana experiencia
        return player.isAlive();
    }
    public void manageInvent(Characters player){
        Scanner sc = new Scanner(System.in);
        int election;
        boolean used = false;
        System.out.println("Quieres:\n" +
                           "1. Usar una poción\n" +
                           "2. Cambiar de arma");

        int opcion = sc.nextInt();
        switch(opcion){
            case 1:
                if(!Alchemy.isEmpty()){
                    System.out.println("Que tipo de pocion quieres usar?\n" +
                            "1. Hp\n" +
                            "2. Mana");
                    election = sc.nextInt();
                    switch(election){
                        case 1:
                            for(int i = 0; i < Alchemy.size(); i++){
                                if(Alchemy.get(i).getType() == 1){
                                    Alchemy.get(i).use(player);
                                    Alchemy.remove(i);
                                    used = true;
                                    break;
                                }
                            }
                            if(!used)System.out.println("No te quedan pociones de vida");
                            break;
                        case 2:
                            for(int i = 0; i < Alchemy.size(); i++){
                                if(Alchemy.get(i).getType() == 2){
                                    Alchemy.get(i).use(player);
                                    used = true;
                                    Alchemy.remove(i);
                                    break;
                                }
                            }
                            if(!used)System.out.println("No te quedan pociones de mana");
                            break;
                        default:
                            System.out.println("No es una opcion valida");
                    }
                }else{
                    System.out.println("No te quedan pociones!");
                }
                break;
            case 2:
                if(!Inventory.isEmpty()){
                    System.out.println("Que armas quieres equipar?");
                    getInventory();
                    election = sc.nextInt();
                    player.changeWeapon(election);
                }else{
                    System.out.println("El inventario esta vacio");
                }
                break;
            default:
                System.out.println("No es una opcion valida");
        }
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
    public String getStatName(int i){
        return nombresStats[i];
    }
    public int getStat(int i){
        return estadisticas[i].getStats();
    }
    public int statsLength(){
        return estadisticas.length;
    }
}
