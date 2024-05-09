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


        Characters Jugador = new Warrior("Arturo", 1,100,100, 15, 20, 12, 7, 20, 100, 0, 1000, true, new BareKnucle());
        Characters Enemigo = new Warrior("Mordred",1,100,100, 15, 20, 12, 7, 20, 100, 0, 0, true, new BareKnucle());

        //Dungeon dungeon = new Dungeon(Jugador);
        Maps map = new Plains(Jugador);

        map.RunMap();
        //dungeon.runMaze();
        Jugador.getStats();

    }
}