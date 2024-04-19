package Scenario;

import Character.*;
import Exceptions.NotAllowedException;
import Item.*;

import java.sql.SQLOutput;
import java.util.*;

public class Maps {
    private EnemySet enemigos;
    private String M = new String(Character.toChars(0x1F9F1));
    private String G = new String(Character.toChars(0x1F7E9));
    protected String[][] table = {
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

    protected List<Weapon> LootWeapons;
    protected Characters player;
    protected int positionX;
    protected int positionY;


    public Maps(Characters player) {

        this.player = player;
        this.positionX = 28;
        this.positionY = 19;
        this.enemigos = new EnemySet(0);
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
                imprimirCuadrado(this.table, 1);
                break;
            case "S":
                positionY += 1;
                imprimirCuadrado(this.table, 2);
                break;
            case "A":
                positionX -= 1;
                imprimirCuadrado(this.table, 3);
                break;
            case "D":
                positionX += 1;
                imprimirCuadrado(this.table, 4);
                break;
            case "I":

            default:
                break;
        }
    }

    public void RunMap() {
        Weapon knife = new Sword("cuchillo", 5);
        boolean correcto = true;
        int x = 0;
        int y = 0;
        do{
            try{
                imprimirCuadrado(this.table, positionY);
                x = positionX;
                y = positionY;
                menu();

                boolean a = true;
                while (a) {
                    if(table[positionX][positionY].equals(M)){
                        throw new NotAllowedException();
                    }
                    correcto = true;
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
                correcto = false;
                System.out.println("No puedes salir del mapa");
                positionX = x;
                positionY = y;
            }catch(NotAllowedException ex){

            }
        }while(!correcto);

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
    private void imprimirCuadrado(String[][] cuadrado, int cardinal) {

        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 30; j++) {
                if(positionX == j && positionY == i){
                    cuadrado[i][j] = new String(Character.toChars(0x1F464));
                }
                System.out.print(cuadrado[i][j]);
                cuadrado[positionY][positionX] = G;
            }
            System.out.println();
        }
    }
}


