package Main;
import Character.*;
import Item.*;
import Scenario.*;

import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Weapon Puños = new BareKnucle();
        Weapon Excalibur = new Sword("Excalibur", 10,1);
        Weapon Clarent = new Sword("Clarent", 10,1);
        Weapon w = new Staff("Palitroque",5,1.2,1);
        Weapon Pincho = new Dagger("Pincho", 5,1);

        Characters Jugador = new Warrior("Arturo", 1,100,100, 15, 20, 12, 7, 20, 100, 0, 0, true, new BareKnucle());
        Characters Enemigo = new Warrior("Mordred",1,100,100, 15, 20, 12, 7, 20, 100, 0, 0, true, new BareKnucle());

        //Dungeon dungeon = new Dungeon(Jugador);
        Maps map = new Plains(Jugador);

        map.RunMap();
        //dungeon.runMaze();
        Jugador.getStats();

        System.out.println("A "+Jugador.getName()+" le quedan "+Jugador.getHp().getStats() + " puntos de vida");
        System.out.println("A "+Enemigo.getName()+" le quedan "+Enemigo.getHp().getStats() + " puntos de vida");

    }
}