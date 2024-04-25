package Scenario;

import Exceptions.NotAllowedException;
import Item.Sword;
import Item.Weapon;
import Character.*;
public class Desert extends Maps {
    private String[][] table = {
            {M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M},
            {M, D, M, M, M, M, M, M, M, M, M, M, M, M, M, D, D, D, D, D, D, D, D, D, D, D, D, D, D, M},
            {M, M, D, D, D, D, M, M, M, M, M, M, M, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, M},
            {M, M, D, M, D, D, D, M, M, M, M, M, D, D, D, D, D, D, D, M, M, D, D, D, D, D, D, D, D, M},
            {M, M, D, M, M, D, D, D, M, M, D, D, D, D, D, D, D, D, D, M, M, M, D, D, D, D, D, D, D, M},
            {M, M, D, M, M, D, D, D, M, D, D, D, M, M, D, D, D, D, D, M, M, D, M, D, D, D, D, D, D, M},
            {M, M, D, M, M, D, M, M, M, D, M, M, M, M, D, D, D, D, D, M, M, D, M, M, D, D, D, D, D, M},
            {M, M, D, M, M, D, D, D, D, D, D, M, M, M, D, D, D, D, D, M, M, D, D, M, M, D, D, D, D, M},
            {M, M, D, M, M, M, D, D, M, M, M, M, M, M, M, D, D, D, D, M, M, D, M, M, M, D, D, D, D, M},
            {M, M, D, M, M, M, M, D, D, M, M, M, M, M, M, M, D, D, D, M, M, D, D, M, M, D, D, D, D, M},
            {M, M, D, M, M, M, M, M, D, D, D, D, D, D, D, D, D, D, D, M, M, D, M, M, M, D, D, D, D, M},
            {M, M, D, D, M, M, D, D, D, D, D, M, M, M, M, D, D, D, D, M, M, D, D, M, M, D, D, D, D, M},
            {M, M, M, D, D, M, D, D, D, D, M, M, D, D, D, D, D, D, D, M, M, D, M, M, M, M, M, D, D, M},
            {M, M, M, M, D, D, M, D, M, M, M, D, M, D, D, D, D, D, D, M, M, D, D, M, D, D, M, D, D, M},
            {M, D, M, M, M, D, M, D, D, M, D, D, D, M, D, D, D, D, D, M, M, D, M, M, D, D, D, D, D, M},
            {M, D, D, M, M, D, M, D, M, M, D, D, D, D, D, M, D, D, D, M, M, D, D, D, M, D, D, D, D, M},
            {M, D, D, D, M, D, M, D, M, D, D, D, D, D, D, M, D, D, D, M, M, D, D, M, D, D, D, D, D, M},
            {M, D, D, M, D, D, M, D, M, D, D, D, D, D, D, D, M, D, D, M, M, D, D, D, D, D, D, D, D, M},
            {M, D, M, D, D, D, M, D, M, D, D, D, D, D, D, D, D, M, D, M, M, D, D, D, D, D, D, D, D, M},
            {M, M, D, D, D, D, D, D, M, D, D, D, D, D, D, D, D, M, M, M, M, D, D, D, D, D, D, D, D, M},
            {M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M, M}
    };

    public Desert(Characters player) {
        super(player);

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
    protected void imprimirCuadrado(String[][] cuadrado) {
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 30; j++) {
                if (positionX == j && positionY == i) {
                    cuadrado[i][j] = new String(Character.toChars(0x1F464));
                }
                System.out.print(cuadrado[i][j]);
                cuadrado[positionY][positionX] = D;
            }
            System.out.println();
        }
    }
}
