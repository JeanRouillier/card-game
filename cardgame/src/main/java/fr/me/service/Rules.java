package fr.me.service;

import fr.me.dto.AlliesBoard;
import fr.me.dto.Person;
import fr.me.dto.encounter.Encounter;
import fr.me.dto.encounter.EncounterList;
import fr.me.dto.player.Player;

import java.util.List;
import java.util.Random;
import java.util.WeakHashMap;

public class Rules {

    public static Encounter selectEncounter(EncounterList list, int level){
        Encounter result = new Encounter();
        Random rand = new Random();
        switch (level){
            case 1:
                List<Encounter> one = list.getOne();
                result = one.get(rand.nextInt(one.size()));
                break;
            case 2:
                List<Encounter> two = list.getTwo();
                result = two.get(rand.nextInt(two.size()));
                break;
            case 3:
                List<Encounter> three = list.getThree();
                result = three.get(rand.nextInt(three.size()));
                break;
        }
        return result;
    }

    public static void placePlayers(AlliesBoard alliesBoard, Player player, BoardPosition wishedPosition){
        boolean b = alliesBoard.setAtPosition(wishedPosition, player);
    }
}
