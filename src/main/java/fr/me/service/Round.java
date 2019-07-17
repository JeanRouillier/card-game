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

    private boolean hasActiveEncounter = false;
    private boolean isEnded = false;

    public boolean getHasActiveEncounter(){
        return activeEncounter != null;
    }
}
