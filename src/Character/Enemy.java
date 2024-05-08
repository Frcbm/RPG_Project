package Character;

import Item.Weapon;

public class Enemy extends Characters {
    public Enemy(String name, int level, int hp, int maxHp, int str, int def, int agl, int intel, int mana, int maxMana, int exp, int gold, boolean condition, Weapon weapon) {
        super(name, level, hp, maxHp, str, def, agl, intel, mana, maxMana, exp, gold, condition, weapon);
    }

    public stats getStr() {
        return this.str;
    }

    public stats getIntel() {
        return this.intel;
    }

    public stats getAgi() {
        return this.agl;
    }

    public void setStr(int str) {
        this.str.setStats(str);
    }

    public void setIntel(int intel) {
        this.intel.setStats(intel);
    }

    public void setAgi(int agi) {
        this.intel.setStats(agi);
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

}


