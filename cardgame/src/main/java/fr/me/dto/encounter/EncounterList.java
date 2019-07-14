package fr.me.dto.encounter;

import lombok.Data;

import java.util.AbstractMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
public class EncounterList {

    private List<Encounter> one;
    private List<Encounter> two;
    private List<Encounter> three;

    public EncounterList(){
        this.one = initLevelOne();
    }

    public static List<Encounter> initLevelOne(){
        return Stream.of(
                new Encounter("Road of Sacrifices", Stream.of(
                        new AbstractMap.SimpleEntry<Integer, EncounterRow>(1, new EncounterRow(1, 2, 0, 0)),
                        new AbstractMap.SimpleEntry<Integer, EncounterRow>(2, new EncounterRow(1, 2, 0, 0)),
                        new AbstractMap.SimpleEntry<Integer, EncounterRow>(3, new EncounterRow(2, 2, 1, 0)),
                        new AbstractMap.SimpleEntry<Integer, EncounterRow>(4, new EncounterRow(2, 1, 2, 0)))
                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)),
                        true))
                .collect(Collectors.toList());
    }
}
