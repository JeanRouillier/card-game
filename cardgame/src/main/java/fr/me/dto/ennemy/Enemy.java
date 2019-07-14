package fr.me.dto.ennemy;

import fr.me.dto.misc.AttackTypeEnum;
import fr.me.dto.misc.ConditionEnum;
import fr.me.dto.Person;
import fr.me.service.BoardPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enemy extends Person {

    private int level;
    private int souls;
    private int armor;
    private int hp;
    private AttackTypeEnum sensibility;
    private int attack;
    private ConditionEnum attackType;
    private List<BoardPosition> attackTarget;
    private boolean isAreaAttack;
    private BoardPosition position;
}
