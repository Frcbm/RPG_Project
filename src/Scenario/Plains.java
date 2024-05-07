package Scenario;
import Exceptions.NotAllowedException;
import Item.Sword;
import Item.Weapon;
import Scenario.Maps;
import Character.*;

import java.util.Scanner;

public class Plains extends Maps{

    private String[][] table = {
            {M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M},
            {M,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,R,M},
            {M,G,G,G,G,G,G,S,G,G,G,G,G,G,G,G,G,G,G,G,S,G,G,G,G,G,G,R,R,M},
            {M,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,R,R,R,R,R,M},
            {M,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,R,R,R,R,R,R,M},
            {M,A,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,S,G,G,G,R,R,R,R,R,R,R,M},
            {M,G,G,G,S,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,R,R,R,R,R,R,R,G,M},
            {M,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,R,R,R,R,R,R,R,G,A,M},
            {M,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,R,R,R,R,R,G,G,G,G,G,M},
            {M,G,G,G,G,G,R,R,R,R,R,G,G,G,G,G,G,G,R,R,R,R,R,G,G,G,G,G,G,M},
            {M,G,G,G,G,R,R,R,R,R,R,R,G,G,G,G,G,R,R,R,R,R,G,G,G,G,G,G,G,M},
            {M,G,G,G,R,R,R,R,R,R,R,R,R,R,G,G,R,R,R,R,R,G,G,G,G,G,G,G,G,M},
            {M,G,G,R,R,R,R,R,R,R,R,R,R,R,G,G,R,R,R,R,G,G,G,G,G,G,G,G,G,M},
            {M,G,R,R,R,R,R,R,R,R,R,R,R,R,G,G,R,R,R,G,G,G,G,G,G,G,G,G,G,M},
            {M,R,R,R,R,R,G,G,G,G,G,R,R,R,G,G,R,R,G,G,G,G,G,G,G,G,G,G,G,M},
            {M,R,R,R,R,G,G,G,G,G,G,G,R,R,G,G,R,G,G,G,G,G,G,G,G,G,G,G,G,M},
            {M,R,R,R,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,M},
            {M,R,R,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,M},
            {M,R,G,G,S,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,M},
            {M,A,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,S,G,G,G,G,G,G,G,G,G,G,M},
            {M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M}
    };
    public Plains(Characters player){
        super(player);
        enemigos = new EnemySet(0);
    }

    public void RunMap() {
        Weapon knife = new Sword("cuchillo", 5);

        int x = 0;
        int y = 0;
        do{
            try{
                imprimirCuadrado(this.table);
                x = positionX;
                y = positionY;
                menu();

                while (player.isAlive()) {

                    if(table[positionY][positionX].equals(M)
                    || table[positionY][positionX].equals(S)
                    || table[positionY][positionX].equals(R)) throw new NotAllowedException("No puedes salir del mapa");
                    imprimirCuadrado(this.table);
                    int rand = (int) (Math.random() * 7) + 1;
                    System.out.println("Encuentro: " + rand);
                    if (rand == 7) {
                        if (player.combat(player, enemigos.getEnemigo((int)(Math.random() * 5)))) {
                            System.out.println("Combate ganado!!");
                        } else {
                            System.out.println("Has perdido...");
                        }
                    }
                    x = positionX;
                    y = positionY;
                    if(player.isAlive()){
                        menu();
                    }

                }

            }catch(IndexOutOfBoundsException e){
                System.out.println("No puedes salir del mapa");
                positionX = x;
                positionY = y;
            } catch(NotAllowedException ex){
                System.out.println(ex.getMessage());

                positionX = x;
                positionY = y;

            }
        }while(player.isAlive());

    }

}
