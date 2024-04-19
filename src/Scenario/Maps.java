package Scenario;

import Character.*;
import Exceptions.NotAllowedException;
import Item.*;

import java.sql.SQLOutput;
import java.util.*;

public abstract class Maps {
    private EnemySet enemigos;
    private String M = new String(Character.toChars(0x1F9F1));
    private String G = new String(Character.toChars(0x1F7E9));
    protected String[][] table = {};

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


}


