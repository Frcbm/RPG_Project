package Scenario;

import Character.*;
import Exceptions.NotAllowedException;
import Item.*;

import java.sql.SQLOutput;
import java.util.*;

public abstract class Maps {
    protected EnemySet enemigos;
    protected String A = new String(Character.toChars(0x1F480));
    protected String S = new String(Character.toChars(0x1F9F1));
    protected String M = new String(Character.toChars(0x1F9F1));
    protected String G = new String(Character.toChars(0x1F7E9));
    protected String R = new String(Character.toChars(0x1F7E6));
    protected String D = new String(Character.toChars(0x1F7E8));
    protected String P = new String(Character.toChars(0x1F38D));
    protected String[][] table;
    protected Dungeon[] dungeons;
    protected List<Weapon> LootWeapons;
    protected Characters player;
    protected int positionX;
    protected int positionY;
    protected int dunLvl;

    public Maps(Characters player) {
        dungeons = new Dungeon[3];
        this.dunLvl = 2;
        this.player = player;
        this.positionX = 28;
        this.positionY = 19;
        this.enemigos = new EnemySet(0);
    }
    public abstract int getVarianza();
    public void runMaze(){
        for(int i = 0 ; i < 4 ; i++){
            player.combat(player, enemigos.getEnemigo((int)(Math.random() * (getDunLvL()) - 1)));//
        }
        player.combat(player, dungeons[dunLvl- 2].getBoss());
        System.out.println("Enhorabuena, has terminado la mazmorra!");
        aumentardunLvl();

    }
    public void setEnemigos(EnemySet enemigos){
        this.enemigos = enemigos;
    }
    public int getDunLvL(){
        return this.dunLvl;
    }
    public int aumentardunLvl(){
        return dunLvl >= 4 ? dunLvl : dunLvl++;
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
    public abstract void RunMap();

    protected void imprimirCuadrado(String[][] cuadrado) {
        for(int i = 0; i < player.statsLength() ; i++){
            System.out.print(player.getStatName(i) + ": " + player.getStat(i) + " ");
        }
        System.out.println("\n");
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


