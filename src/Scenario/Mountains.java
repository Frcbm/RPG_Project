package Scenario;

import Exceptions.EnterDungeon;
import Exceptions.NotAllowedException;
import Item.Sword;
import Item.Weapon;
import Scenario.Maps;
import Character.*;

import java.util.Scanner;

public class Mountains extends Maps {

    private String[][] table = {
            {M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M},
            {M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, G, G, G, G, G, G, G, G, G, G, G, G, G, G, M},
            {M, M, G, G, G, G, M, M, M, M, M, M, M, G, G, G, G, G, G, G, G, G, G, G, G, G, G, G, G, M},
            {M, M, G, M, G, G, G, A, M, M, M, M, G, G, G, G, G, G, G, M, M, G, G, G, G, G, G, G, G, M},
            {M, M, G, M, M, G, G, G, M, M, G, G, G, G, G, G, G, G, G, M, M, M, G, G, G, G, G, G, G, M},
            {M, M, G, M, M, G, G, G, M, G, G, G, M, M, G, G, G, G, G, M, M, G, M, G, G, G, G, G, G, M},
            {M, M, G, M, M, G, M, M, M, G, M, M, M, M, G, G, G, G, G, M, M, G, M, M, G, G, G, G, G, M},
            {M, M, G, M, M, G, G, G, G, G, G, M, M, M, G, G, G, G, G, M, M, G, G, A, M, G, G, G, G, M},
            {M, M, G, M, M, M, G, G, M, M, M, M, M, M, M, G, G, G, G, M, M, G, M, M, M, G, G, G, G, M},
            {M, M, G, M, M, M, M, G, G, M, M, M, M, M, M, M, G, G, G, M, M, G, G, M, M, G, G, G, G, M},
            {M, M, G, M, M, M, M, M, G, G, G, G, G, G, G, G, G, G, G, M, M, G, M, M, M, G, G, G, G, M},
            {M, M, A, G, M, M, G, G, G, G, G, M, M, M, M, G, G, G, G, M, M, G, G, M, M, G, G, G, G, M},
            {M, M, M, G, G, M, G, G, G, G, M, M, G, G, G, G, G, G, G, M, M, G, M, M, M, M, M, G, G, M},
            {M, M, M, M, G, G, M, G, M, M, M, G, M, G, G, G, G, G, G, M, M, G, G, M, G, G, M, G, G, M},
            {M, G, M, M, M, G, M, G, G, M, G, G, G, M, G, G, G, G, G, M, M, G, M, M, G, G, G, G, G, M},
            {M, G, G, M, M, G, M, G, M, M, G, G, G, G, G, M, G, G, G, M, M, G, G, G, M, G, G, G, G, M},
            {M, G, G, G, M, G, M, G, M, G, G, G, G, G, G, M, G, G, G, M, M, G, G, M, G, G, G, G, G, M},
            {M, G, G, M, G, G, M, G, M, G, G, G, G, G, G, G, M, G, G, M, M, G, G, G, G, G, G, G, G, M},
            {M, G, M, G, G, G, M, G, M, G, G, G, G, G, G, G, G, M, G, M, M, G, G, G, G, G, G, G, G, M},
            {M, M, G, G, G, G, G, G, M, G, G, G, G, G, G, G, G, M, M, M, M, G, G, G, G, G, G, G, G, M},
            {M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M}
    };
    private int varianza;
    public Mountains(Characters player) {
        super(player);
        varianza = 1;
        enemigos = new EnemySet(varianza);
    }
    public int getVarianza(){
        return this.varianza;
    }
    public void RunMap() {
        Weapon knife = new Sword("cuchillo", 5, 10);

        int x = 0;
        int y = 0;
        do{
            try{
                imprimirCuadrado(this.table);
                x = positionX;
                y = positionY;
                menu();

                while (player.isAlive()) {
                    if(table[positionY][positionX].equals(A)) throw new EnterDungeon("Entras en la mazmorra");
                    if(table[positionY][positionX].equals(M)) throw new NotAllowedException("No puedes salir del mapa");
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
            } catch(EnterDungeon e){
                runMaze();
            }
        }while(player.isAlive());

    }


}