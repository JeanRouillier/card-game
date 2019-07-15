package fr.me.dto.behaviour;

import fr.me.dto.misc.AttackTypeEnum;

public interface EnemyDefend {

    void defend(int hitPoint, AttackTypeEnum type);
}
