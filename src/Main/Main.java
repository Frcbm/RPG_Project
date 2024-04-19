package Main;
import Character.*;
import Item.*;
import Scenario.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Weapon Puños = new BareKnucle();
        Weapon Excalibur = new Sword("Excalibur", 10);
        Weapon Clarent = new Sword("Clarent", 10);
        Weapon HacedorDeViudas = new Bow("Hacedor de Viudas", 12);
        Weapon Palitroque = new Staff("Palitroque",5);
        Weapon Pincho = new Dagger("Pincho", 5);


        Characters Jugador = new Warrior("Arturo", 1,100,100, 15, 20, 12, 7, 20, 100, 0, 0, true, new BareKnucle());
        Characters Enemigo = new Warrior("Mordred",1,100,100, 15, 20, 12, 7, 20, 100, 0, 0, true, new BareKnucle());

        //Dungeon dungeon = new Dungeon(Jugador);
        Mountains map = new Mountains(Jugador);

        System.out.println(Jugador.toString());

        map.RunMap();
        //dungeon.runMaze();
        Jugador.getStats();

        System.out.println("A "+Jugador.getName()+" le quedan "+Jugador.getHp().getStats() + " puntos de vida");
        System.out.println("A "+Enemigo.getName()+" le quedan "+Enemigo.getHp().getStats() + " puntos de vida");

    }
}