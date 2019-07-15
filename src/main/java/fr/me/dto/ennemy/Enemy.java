package fr.me.dto.ennemy;

import fr.me.dto.misc.AttackTypeEnum;
import fr.me.dto.misc.ConditionEnum;
import fr.me.dto.Person;
import fr.me.service.BoardPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Wither
public class Enemy extends Person {

    private String name;
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
    private BoardPosition effectivePosition;
}
