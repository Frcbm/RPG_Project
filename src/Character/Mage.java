package Character;

import Item.Weapon;

public class Mage extends Characters {

    public Mage(String name, int level, int hp, int maxHp, int str, int def, int agl, int intel, int mana, int maxMana, int exp, int gold, boolean condition, Weapon weapon){
        super(name, level,hp,maxHp,str,def,agl,intel,mana, maxMana,exp, gold, condition, weapon);
    }
    @Override
    public void lvlUp(){
        System.out.println("Has subido de nivel!");
        while(this.exp.getStats() >= 100){
            this.level.setStats(this.level.getStats() + 1);
            this.exp.setStats(this.exp.getStats() - 100);
            if(this.exp.getStats() <= 0)this.exp.setStats(0);
            this.maxHp.setStats(this.maxHp.getStats() + 10);
            this.maxMana.setStats(this.maxMana.getStats() + 20);
            setHp(this.maxHp.getStats());//Cuando sube de nivel se cura toda la vida
            assignPoints();
        }
    }

    public void Skill(Characters target){ //Bola de fuego del mago
        if(mana.getStats() >= 5 && weapon.getType() == 3 && target.isAlive()) {
            mana.setStats(mana.getStats() - 5);
            if (mana.getStats() <= 0) {
                mana.setStats(0);
            }
            System.out.println(name + " lanza una bola de fuego a " + target.name);
            int damage = (intel.getStats() * 3); //Calculo del daño total
            int damageTaken = damage - target.intel.getStats(); //Calculo del daño recibido
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
            }else if(weapon.getType() != 3){
                System.out.println("No tienes un bastón equipado");
            }else{
                System.out.println(target.getName()+" ya esta muerto");
            }
        }
    }

    public String toString(){
        return "Este mago se llama "+name+" es de nivel "+level.getStats()+" y su arma es "+weapon.getName();
    }



}
