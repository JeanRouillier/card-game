package fr.me.dto.ennemy.one;

import fr.me.dto.ennemy.Enemy;
import fr.me.service.BoardPosition;
import lombok.Data;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static fr.me.dto.misc.AttackTypeEnum.MAGICAL;
import static fr.me.dto.misc.ConditionEnum.FROST;

@Data
public class IrithyllianBeastHound extends Enemy {

    public IrithyllianBeastHound(){
        this.setLevel(1);
        this.setSouls(1);
        this.setArmor(1);
        this.setHp(1);
        this.setSensibility(MAGICAL);
        this.setAttack(2);
        this.setAttackType(FROST);
        this.setAttackTarget(Stream.of(
                new BoardPosition(1,0 ))
                .collect(Collectors.toList()));
        this.setPosition(new BoardPosition(0, 2));
    }
}
