package Character;
import Item.Weapon;

public interface CharacterAction {
    public void attack(Characters target);
    public void defend();
    public void changeWeapon(Weapon newWeapon);
    public void unequipWeapon();

}
