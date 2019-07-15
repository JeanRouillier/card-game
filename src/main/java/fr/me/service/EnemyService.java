package fr.me.service;

import fr.me.dto.encounter.EncounterRow;
import fr.me.dto.ennemy.Enemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
                .withName("irithyllianBeastHound-1")
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

        Enemy irithyllianBeastHound2 = new Enemy()
                .withName("irithyllianBeastHound-2")
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

        return Stream.of(
                irithyllianBeastHound,
                irithyllianBeastHound2,
                //TODO to remove
                irithyllianBeastHound
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
}
