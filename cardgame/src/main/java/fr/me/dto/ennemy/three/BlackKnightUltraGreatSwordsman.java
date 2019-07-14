package fr.me.dto.ennemy.three;

import fr.me.dto.ennemy.Enemy;
import fr.me.service.BoardPosition;
import lombok.Data;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static fr.me.dto.misc.AttackTypeEnum.MAGICAL;

@Data
public class BlackKnightUltraGreatSwordsman extends Enemy {

    public BlackKnightUltraGreatSwordsman(){
        this.setLevel(3);
        this.setSouls(11);
        this.setArmor(3);
        this.setHp(2);
        this.setSensibility(MAGICAL);
        this.setAttack(4);
        this.setAttackTarget(Stream.of(
                new BoardPosition(0,0),
                new BoardPosition(0,1),
                new BoardPosition(0,2))
                .collect(Collectors.toList()));
        this.setAreaAttack(true);
        this.setPosition(new BoardPosition(0, 0));
    }
}
