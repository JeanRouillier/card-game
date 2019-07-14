package fr.me.service;

import fr.me.dto.encounter.Encounter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Round {

    private Encounter activeEncounter;

    public boolean hasActiveEncounter = false;

    public boolean getHasActiveEncounter(){
        return activeEncounter != null;
    }
}
