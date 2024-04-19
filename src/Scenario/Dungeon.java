package Scenario;
import Character.*;
import Item.*;
import java.util.ArrayList;
import java.util.*;

public class Dungeon {
    private Weapon Puños = new BareKnucle();
    private Weapon Daga = new Dagger("Daga roma",1);
    private Weapon BusterSword = new Sword("Buster Sword",20);


    protected List<Weapon> LootWeapons;
    protected Characters player;

    private ArrayList<Characters> Enemies;


    public void runMaze(){
        while(!Enemies.isEmpty()){
            System.out.println("Te enfrentas a "+Enemies.getFirst().getName());
            if(player.combat(player,Enemies.getFirst())) {
                System.out.println("Combate ganado!!");
                //System.out.println("Has ganado: "+Enemies.getFirst().getExp()+" puntos de experiencia!");
                //System.out.println("----------------");
            }else{
                System.out.println("Has perddido...");
            }
            player.addToInvetory(BusterSword);
            Enemies.removeFirst();
            //player.setHp(100);
        }

        System.out.println("Enhorabuena, has terminado la mazmorra!");
    }


}
