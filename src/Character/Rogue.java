package Character;
import Item.*;

public class Rogue extends Characters {
    public Rogue(String name, int level, int hp, int maxHp, int str, int def, int agl, int intel, int mana, int maxMana, int exp, int gold, boolean condition, Weapon weapon){
        super(name, level,hp,maxHp,str,def,agl,intel,mana, maxMana,exp, gold, condition, weapon);
    }

    @Override
    public void lvlUp(){
        System.out.println("Has subido de nivel!");
        while(this.exp.getStats() >= 100){
            this.level.setStats(this.level.getStats() + 1);
            this.exp.setStats(this.exp.getStats() - 100);
            if(this.exp.getStats() <= 0)this.exp.setStats(0);
            this.maxHp.setStats(this.maxHp.getStats() + 20);
            this.maxMana.setStats(this.maxMana.getStats() + 10);
            setHp(this.maxHp.getStats());//Cuando sube de nivel se cura toda la vida
            assignPoints();
        }
    }
    public void attack(Characters target){ //Ataque básico cuerpo a cuerpo unico para el pícaro
        int accuracy = (int) (Math.random()*100) + 1; //Roll para acertar o fallar
        int critical = (int) (Math.random()*5) + 1; //Roll para golpe crítico (El pícaro tiene el doble de posiblidades)
        accuracy -= this.agl.getStats();
        System.out.println(name + " ataca a " + target.name);
        if(accuracy <= 75 && target.isAlive()) {
            int damage = ((int) (str.getStats() * 1.5)) + weapon.getDamage(); //Calculo del daño total
            if(critical == 5){
                damage *= 2; //El golpe crítico dobla el daño
                System.out.println("Golpe crítico!");
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
    public void Skill(Characters target){
        int accuracy = (int) (Math.random()*100) + 1; //Roll para acertar o fallar
        int critical = (int) (Math.random()*5) + 1; //Roll para golpe crítico (El pícaro tiene el doble de posiblidades)
        accuracy -= this.agl.getStats();
        System.out.println(name + " ataca a " + target.name);
        if(accuracy <= 75 && target.isAlive()) {
            int damage = ((int) (str.getStats() * 1.2)) + weapon.getDamage(); //Calculo del daño total
            if(critical == 5){
                damage *= 2; //El golpe crítico dobla el daño
                System.out.println("Golpe crítico!");
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
    public String toString(){
        return "Este pícaro se llama "+name+" es de nivel " + level.getStats() + " y su arma es "+weapon.getName();
    }
}
