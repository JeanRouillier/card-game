package fr.me.dto;

import fr.me.dto.ennemy.Enemy;
import fr.me.service.Board;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

@Log
public class EnemiesBoard extends Board {

    private List<Enemy> frontLineEnemyWaitingList = new ArrayList<>();
    private List<Enemy> backLineEnemyWaitingList = new ArrayList<>();

    public void placeEnemies(List<Enemy> enemies) {
        for (Enemy e: enemies){
            //si place pas dispo on offset jusqu'à dispo
            boolean isOccupied = isOccupied(e.getPosition());
            while(!setAtPosition(e.getPosition(), e)){
                e.setPosition(e.getPosition().offsetSameRow());
                setAtPosition(e.getPosition(), e);
            }
        }
    }
}
