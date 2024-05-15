package Scenario;
import Character.*;
import Item.*;
import java.util.*;
public class Shop {
    private List<Weapon> weaponList;
    private List<Potions> potionList;
    public Shop(){

        weaponList = new ArrayList<Weapon>();
        potionList = new ArrayList<Potions>();
        createItems();
    }

    private void createItems(){

        weaponList = new ArrayList<>();
        potionList = new ArrayList<>();
        Weapon sword = new Sword("Long Sword",10,10);
        Weapon staff = new Staff("Wooden Staff",6,1.1,10);
        Weapon staff2 = new Staff("Archmage Staff",10,2.0,20);
        Weapon dagger = new Dagger("Iron Dagger",8,10);
        Weapon bow = new Bow("Wood Bow",11,10);
        Weapon longSword = new Sword("Long Sword",12,15);

        Potions Hppotion1 = new HpPotion(1);
        Potions Hppotion2 = new HpPotion(1);
        Potions Hppotion3 = new HpPotion(1);
        Potions Hppotion4 = new HpPotion(2);
        Potions Hppotion5 = new HpPotion(3);
        Potions Hppotion6 = new HpPotion(4);

        this.weaponList.add(sword);
        this.weaponList.add(staff);
        this.weaponList.add(dagger);
        this.weaponList.add(bow);
        this.weaponList.add(longSword);
        this.weaponList.add(staff2);

        this.potionList.add(Hppotion1);
        this.potionList.add(Hppotion2);
        this.potionList.add(Hppotion3);
        this.potionList.add(Hppotion4);
        this.potionList.add(Hppotion5);
        this.potionList.add(Hppotion6);;
    }


    public void runShop(Characters player){
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a mi tienda\n"+
                           "Quieres comprar armas(1) o pociones(2)?");

        int option = sc.nextInt();
        switch(option){
            case 1:
                showWeapons();
                System.out.println("Que armas quieres comprar?");
                option = sc.nextInt();
                if(option > weaponList.size()) {
                    System.out.println("No es una opcion valida");
                }else{
                    if(player.getGold() >= weaponList.get(option).getPrice()){
                        player.buyItem(weaponList.get(option).getPrice());
                        player.addToInvetory(weaponList.get(option));
                        System.out.println(weaponList.get(option).getName()+" se ha añadido al inventario");
                        weaponList.remove(option);
                    }else{
                        System.out.println("No tienes suficiente oro");
                    }
                }
                break;
            case 2:
                showPotions();
                System.out.println("Que pocion quieres comprar?");
                option = sc.nextInt();
                if(option > potionList.size()) {
                    System.out.println("No es una opcion valida");
                }else{
                    if(player.getGold() >= potionList.get(option).getPrice()){
                        player.buyItem(potionList.get(option).getPrice());
                        player.addToAlchemy(potionList.get(option));
                        System.out.println(potionList.get(option).toString()+" se ha añadido al inventario");
                        potionList.remove(option);
                    }else{
                        System.out.println("No tienes suficiente oro");
                    }
                }
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }


    public void showWeapons(){
        for(int i = 0; i < weaponList.size(); i++){
            System.out.println(i+". "+weaponList.get(i).getName());
        }
    }

    public void showPotions(){
        for(int i = 0; i < potionList.size(); i++){
            System.out.println(i+". "+potionList.get(i).toString());
        }
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
