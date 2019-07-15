package fr.me.dto;

import fr.me.dto.ennemy.Enemy;
import fr.me.dto.board.Board;
import fr.me.dto.board.BoardPosition;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

@Log
public class EnemiesBoard extends Board {

    private List<Enemy> frontLineEnemyWaitingList = new ArrayList<>();
    private List<Enemy> backLineEnemyWaitingList = new ArrayList<>();

    public void placeEnemies(List<Enemy> enemies) {
        for (Enemy e: enemies){
            System.out.println(e.getName() + " " +e.getPosition());

            //si place pas dispo on offset jusqu'à dispo
            boolean isOccupied = isOccupied(e.getPosition());
            if(isOccupied){
                BoardPosition positiveEffective = e.getPosition().offsetSameRow();
                BoardPosition negativeEffective = e.getPosition().negativeOffsetSameRow();
                if(!isOccupied(e.getPosition().offsetSameRow())){
                    setAtPosition(positiveEffective, e);

                }else if (!isOccupied(e.getPosition().negativeOffsetSameRow())){
                    setAtPosition(negativeEffective, e);

                } else {
                    if ((e.getPosition().getX() % 1) != 0) {
                        backLineEnemyWaitingList.add(e);
                        System.out.println("Added to temp BACK");
                    } else {
                        frontLineEnemyWaitingList.add(e);
                        System.out.println("Added to temp FRONT");
                    }
                }
            }else {
                setAtPosition(e.getPosition(), e);
            }
        }
    }

    public void print(){
        System.out.println("Enemies board");
        super.print();
    }
}
