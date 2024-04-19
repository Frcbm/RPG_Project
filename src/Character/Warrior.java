package Character;
import Item.Weapon;

import java.util.Scanner;

public class Warrior extends Characters {
    public Warrior(String name, int level, int hp, int maxHp, int str, int def, int agl, int intel, int mana, int maxMana, int exp, int gold, boolean condition, Weapon weapon){
        super(name, level,hp,maxHp,str,def,agl,intel,mana, maxMana,exp, gold, condition, weapon);
    }

    @Override
    public void lvlUp(){
        System.out.println("Has subido de nivel!");
        while(this.exp.getStats() >= 100){
            this.level.setStats(this.level.getStats() + 1);
            this.exp.setStats(this.exp.getStats() - 100);
            if(this.exp.getStats() <= 0)this.exp.setStats(0);
            this.maxHp.setStats(this.maxHp.getStats() + 30);
            this.maxMana.setStats(this.maxMana.getStats() + 5);
            setHp(this.maxHp.getStats());//Cuando sube de nivel se cura toda la vida
            assignPoints();
        }
    }
    @Override
    public void Skill(Characters target){
        if(mana.getStats() >= 5 && weapon.getType() == 1 && target.isAlive()) {
            mana.setStats(mana.getStats() - 5);
            if (mana.getStats() <= 0) {
                mana.setStats(0);
            }
            System.out.println(name + " le asesta un tajo a " + target.name);
            int damage = (str.getStats() * 2) + weapon.getDamage(); //Calculo del daño total
            int damageTaken = damage - target.def.getStats(); //Calculo del daño recibido
            if (damageTaken <= 0) {
                damageTaken = 0;
            }
            target.takeDamage(damageTaken);
            System.out.println("El objetivo recibe " + damageTaken + " puntos de daño");
            if (!target.isAlive()) {
                System.out.println("El objetivo ha muerto!");
            }
        }else{
            if(mana.getStats() == 0) {
                System.out.println("No tienes suficiente maná");
            }else if(weapon.getType() != 1){
                System.out.println("No tienes una espada equipada");
            }else{
                System.out.println(target.getName()+" ya esta muerto");
            }
        }
    }

    public String toString(){
        return "Este guerrero se llama "+name+" es de nivel "+level.getStats()+" y su arma es "+weapon.getName();
    }
}
