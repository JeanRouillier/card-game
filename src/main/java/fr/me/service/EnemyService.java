package fr.me.service;

import fr.me.dto.AlliesBoard;
import fr.me.dto.Person;
import fr.me.dto.board.BoardPosition;
import fr.me.dto.encounter.EncounterRow;
import fr.me.dto.ennemy.Enemy;
import fr.me.dto.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static fr.me.dto.misc.AttackTypeEnum.HEAVY;
import static fr.me.dto.misc.AttackTypeEnum.MAGICAL;
import static fr.me.dto.misc.ConditionEnum.FROST;

public class EnemyService {

    static{
        one = initLevelOneEnemyList();
        two = initLevelTwoEnemyList();
        three = initLevelThreeEnemyList();
    }
    private static List<Enemy> one ;
    private static List<Enemy> two;
    private static List<Enemy> three;

    private static List<Enemy> initLevelOneEnemyList(){
        Enemy irithyllianBeastHound = new Enemy()
                .withName("irithyllianBeastHound")
                .withLevel(1)
                .withSouls(1)
                .withArmor(1)
                .withHp(1)
                .withSensibility(MAGICAL)
                .withAttack(2)
                .withAttackType(FROST)
                .withAttackTarget(Stream.of(
                        new BoardPosition(1,0 ))
                        .collect(Collectors.toList()))
                .withPosition(new BoardPosition(0, 2));

        Enemy hollowManservant = new Enemy()
                .withName("hollowManservant")
                .withLevel(1)
                .withSouls(2)
                .withArmor(0)
                .withHp(2)
                .withAttack(4)
                .withAttackTarget(Stream.of(
                        new BoardPosition(0,2 ))
                        .collect(Collectors.toList()))
                .withPosition(new BoardPosition(0, 0));

        Enemy flambergeHollowSlave = new Enemy()
                .withName("flambergeHollowSlave")
                .withLevel(1)
                .withSouls(3)
                .withArmor(2)
                .withHp(1)
                .withSensibility(HEAVY)
                .withAttack(2)
                .withAttackTarget(Stream.of(
                        new BoardPosition(0,1 ))
                        .collect(Collectors.toList()))
                .withPosition(new BoardPosition(0, 1));

        return Stream.of(
                irithyllianBeastHound,
                hollowManservant,
                flambergeHollowSlave
        ).collect(Collectors.toList());
    }

    private static List<Enemy> initLevelTwoEnemyList(){
        return new ArrayList<>();
    }

    private static List<Enemy> initLevelThreeEnemyList(){
        Enemy blackKnightUltraGreatSwordsman = new Enemy()
                .withLevel(3)
                .withSouls(11)
                .withArmor(3)
                .withHp(2)
                .withSensibility(MAGICAL)
                .withAttack(4)
                .withAttackTarget(Stream.of(
                        new BoardPosition(0,0),
                        new BoardPosition(0,1),
                        new BoardPosition(0,2))
                        .collect(Collectors.toList()))
                .withAreaAttack(true)
                .withPosition(new BoardPosition(0, 0));

        return Stream.of(blackKnightUltraGreatSwordsman).collect(Collectors.toList());
    }

    public static List<Enemy> pickEnemies(EncounterRow encounterRow){
        ArrayList<Enemy> result = new ArrayList<>();
        result.addAll(pickSpecificEnemy(1, encounterRow.getLevelOneNumber()));
        result.addAll(pickSpecificEnemy(2, encounterRow.getLevelTwoNumber()));
        result.addAll(pickSpecificEnemy(3, encounterRow.getLevelThreeNumber()));
        return result;

    }

    public static List<Enemy> pickSpecificEnemy(int level, int qty){
        Random rand = new Random();
        ArrayList<Enemy> enemyOneCopy = new ArrayList<>(one);
        ArrayList<Enemy> enemyTwoCopy = new ArrayList<>(two);
        ArrayList<Enemy> enemyThreeCopy = new ArrayList<>(three);

        ArrayList<Enemy> result = new ArrayList<>();
        for(int i = 0; i<= qty-1; i++){
            switch (level){
                case 1:
                    result.add(enemyOneCopy.remove(rand.nextInt(enemyOneCopy.size())));
                    break;
                case 2:
                    result.add(enemyTwoCopy.remove(rand.nextInt(enemyTwoCopy.size())));
                    break;
                case 3:
                    result.add(enemyThreeCopy.remove(rand.nextInt(enemyThreeCopy.size())));
                    break;
            }
        }
        return result;
    }

    public static void enemyAttack(List<Enemy> enemyList, AlliesBoard alliesBoard){
        alliesBoard.print();
        for (Enemy e : enemyList) {
            System.out.println(e.getName() + " attacks => "+e.getAttackTarget());
            if(!e.isAreaAttack()){
                alliesBoard.getAtPosition(e.getAttackTarget().get(0))
                        .ifPresent(p -> ((Player)p).defend(e.getAttack()));
                }else{

            }
        }

    }
}
