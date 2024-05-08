package Item;
import Character.*;

public class ManaPotion extends Potions{
    public ManaPotion(int level){
        super(level);
    }
    public int use(){
        return 10*this.level;
    }

    public void use(Characters character){
        character.setMana(character.getMana().getStats() + (50*this.level));
        if(character.getMana().getStats() > character.getMaxMana().getStats()){
            character.setHp(character.getMaxMana().getStats());
        }
    }
    @Override
    public String toString(){
        return "Pocion de mana de nivel "+level;
    }
}
