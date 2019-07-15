package fr.me.dto.behaviour;

import fr.me.dto.Person;
import fr.me.dto.misc.ConditionEnum;

public interface Attacker {

    void attack(Person e, ConditionEnum conditionEnum);
}
