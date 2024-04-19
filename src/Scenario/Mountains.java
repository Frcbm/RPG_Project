package Scenario;

import Exceptions.NotAllowedException;
import Item.Sword;
import Item.Weapon;
import Scenario.Maps;
import Character.*;

import java.util.Scanner;

public class Mountains extends Maps {
    private String M = new String(Character.toChars(0x1F9F1));
    private String G = new String(Character.toChars(0x1F7E9));
    private String[][] table = {
            {M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M},
            {M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,G,G,G,G,G,G,G,G,G,G,G,G,G,G,M},
            {M,M,G,G,G,G,M,M,M,M,M,M,M,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,G,M},
            {M,M,G,M,G,G,G,M,M,M,M,M,G,G,G,G,G,G,G,M,M,G,G,G,G,G,G,G,G,M},
            {M,M,G,M,M,G,G,G,M,M,G,G,G,G,G,G,G,G,G,M,M,M,G,G,G,G,G,G,G,M},
            {M,M,G,M,M,G,G,G,M,G,G,G,M,M,G,G,G,G,G,M,M,G,M,G,G,G,G,G,G,M},
            {M,M,G,M,M,G,M,M,M,G,M,M,M,M,G,G,G,G,G,M,M,G,M,M,G,G,G,G,G,M},
            {M,M,G,M,M,G,G,G,G,G,G,M,M,M,G,G,G,G,G,M,M,G,G,M,M,G,G,G,G,M},
            {M,M,G,M,M,M,G,G,M,M,M,M,M,M,M,G,G,G,G,M,M,G,M,M,M,G,G,G,G,M},
            {M,M,G,M,M,M,M,G,G,M,M,M,M,M,M,M,G,G,G,M,M,G,G,M,M,G,G,G,G,M},
            {M,M,G,M,M,M,M,M,G,G,G,G,G,G,G,G,G,G,G,M,M,G,M,M,M,G,G,G,G,M},
            {M,M,G,G,M,M,G,G,G,G,G,M,M,M,M,G,G,G,G,M,M,G,G,M,M,G,G,G,G,M},
            {M,M,M,G,G,M,G,G,G,G,M,M,G,G,G,G,G,G,G,M,M,G,M,M,M,M,M,G,G,M},
            {M,M,M,M,G,G,M,G,M,M,M,G,M,G,G,G,G,G,G,M,M,G,G,M,G,G,M,G,G,M},
            {M,G,M,M,M,G,M,G,G,M,G,G,G,M,G,G,G,G,G,M,M,G,M,M,G,G,G,G,G,M},
            {M,G,G,M,M,G,M,G,M,M,G,G,G,G,G,M,G,G,G,M,M,G,G,G,M,G,G,G,G,M},
            {M,G,G,G,M,G,M,G,M,G,G,G,G,G,G,M,G,G,G,M,M,G,G,M,G,G,G,G,G,M},
            {M,G,G,M,G,G,M,G,M,G,G,G,G,G,G,G,M,G,G,M,M,G,G,G,G,G,G,G,G,M},
            {M,G,M,G,G,G,M,G,M,G,G,G,G,G,G,G,G,M,G,M,M,G,G,G,G,G,G,G,G,M},
            {M,M,G,G,G,G,G,G,M,G,G,G,G,G,G,G,G,M,M,M,M,G,G,G,G,G,G,G,G,M},
            {M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M,M}
    };
    public Mountains(Characters player){
        super(player);

    }
    public void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige una accion:\n" +
                "W. Moverse arriba\n" +
                "S. Moverse abajo\n" +
                "A. Moverse a la izquierda\n" +
                "D. Moverse a la derecha\n"+
                "I. Inventario");
        switch (sc.nextLine().toUpperCase()) {
            case "W":
                positionY -= 1;
                //imprimirCuadrado(this.table);
                break;
            case "S":
                positionY += 1;
                //imprimirCuadrado(this.table);
                break;
            case "A":
                positionX -= 1;
                //imprimirCuadrado(this.table);
                break;
            case "D":
                positionX += 1;
                //imprimirCuadrado(this.table);
                break;
            case "I":

            default:
                break;
        }
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

                while (true) {

                    if(table[positionY][positionX].equals(M)) throw new NotAllowedException("No puedes salir del mapa");
                    imprimirCuadrado(this.table);
                    int rand = (int) (Math.random() * 7) + 1;
                    System.out.println("Encuentro: " + rand);
                    /*if (rand == 7) {
                        if (player.combat(player, enemigos.getEnemigo((int)(Math.random() * 5)))) {
                            System.out.println("Combate ganado!!");
                        } else {
                            System.out.println("Has perdido...");
                        }
                    }*/
                    x = positionX;
                    y = positionY;
                    menu();
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
        }while(true);

    }

    /*
        public void dibujarCuadrado(String[][] cuadrado) {
            for (int i = 0; i < 21; i++) {
                for (int j = 0; j < 30; j++) {
                    // Dibuja las líneas horizontales y verticales del cuadrado
                    if (i == 0 || i == 20) {
                        cuadrado[i][j] = "-";
                    } else if (j == 0 || j == 29) {
                        cuadrado[i][j] = "|";
                    } else {
                        // Llena el interior del cuadrado
                        cuadrado[i][j] = " ";
                    }
                    if(positionX == j && positionY == i){
                        cuadrado[i][j] = "J";
                    }
                }
            }
        }
    */
    private void imprimirCuadrado(String[][] cuadrado) {
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 30; j++) {
                if (positionX == j && positionY == i) {
                    cuadrado[i][j] = new String(Character.toChars(0x1F464));
                }
                System.out.print(cuadrado[i][j]);
                cuadrado[positionY][positionX] = G;
            }
            System.out.println();
        }
    }

}
