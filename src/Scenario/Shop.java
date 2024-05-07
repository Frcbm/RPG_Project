package Scenario;
import Character.Characters;
import Item.*;
import java.util.*;
public class Shop {
    private List<Weapon> weaponList;
    private List<Potions> potionList;
    public Shop(){
        createItems();
    }

    private void createItems(){

        Weapon sword = new Sword("Long Sword",10,10);
        Weapon staff = new Staff("Wooden Staff",6,1.1,10);
        Weapon dagger = new Dagger("Iron Dagger",8,10);
        Weapon bow = new Bow("Wood Bow",11,10);
        Weapon longSword = new Sword("Long Sword",12,15);

        Potions Hppotion1 = new HpPotion(1);
        Potions Hppotion2 = new HpPotion(1);
        Potions Hppotion3 = new HpPotion(1);
        Potions Hppotion4 = new HpPotion(2);
        Potions Hppotion5 = new HpPotion(3);
        Potions Hppotion6 = new HpPotion(4);

        weaponList.add(sword);
        weaponList.add(staff);
        weaponList.add(dagger);
        weaponList.add(bow);
        weaponList.add(longSword);

        potionList.add(Hppotion1);
        potionList.add(Hppotion2);
        potionList.add(Hppotion3);
        potionList.add(Hppotion4);
        potionList.add(Hppotion5);
        potionList.add(Hppotion6);
    }

    public void runShop(Character character){
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a mi tienda\n"+
                           "Que artículo quieres comprar?");

        showItems();
        int option = sc.nextInt();

    }
    public void showItems(){
        for(int i = 0; i < weaponList.size(); i++){
            System.out.println(i+". "+weaponList.get(i).getName());
        }
        for(int i = 0; i < potionList.size(); i++){
            System.out.println(i+". "+potionList.get(i).toString());
        }
    }
}
