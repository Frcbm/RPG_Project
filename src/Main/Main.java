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

        System.out.println("Elije un nombre de personaje");
        String nombre = sc.nextLine();
        System.out.println("Elige una clase");
        System.out.println("1. Guerrero\n" +
                            "2. Mago\n"+
                            "3. Picaro");
        int opcion = sc.nextInt();
        Characters Jugador;
        switch(opcion) {
            case 1:
                Jugador = new Warrior(nombre, 1, 100, 100, 9, 15, 16, 15, 50, 100, 0, 1000, true, new BareKnucle());
                break;
            case 2:
                Jugador = new Mage(nombre, 1, 100, 100, 9, 15, 16, 15, 50, 100, 0, 1000, true, new BareKnucle());
                break;
            case 3:
                Jugador = new Rogue(nombre, 1, 100, 100, 9, 15, 16, 15, 50, 100, 0, 1000, true, new BareKnucle());
                break;
            default:
                Jugador =  new Mage("Arturo", 1,100,100, 9, 15, 16, 15, 50, 100, 0, 1000, true, new BareKnucle());
        }





        Maps map = new Plains(Jugador);
        map.RunMap();
        map = new Mountains(Jugador);
        map.RunMap();
        map = new Desert(Jugador);
        map.RunMap();
        Jugador.getStats();

    }
}