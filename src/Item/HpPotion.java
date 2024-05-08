package Item;
import Character.*;

public class HpPotion extends Potions{
    public HpPotion(int level){
        super(level);
    }
    public void use(Characters character){
        character.setHp(character.getHp().getStats() + (50 * this.level));
        if(character.getHp().getStats() > character.getMaxHp().getStats()){
            character.setHp(character.getMaxHp().getStats());
        }
    }
    @Override
    public String toString(){
        return "Pocion de vida de nivel "+level;
    }
}
