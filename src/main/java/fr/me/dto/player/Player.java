package fr.me.dto.player;

import fr.me.dto.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player extends Person{

    public String name;
    public List<Object> hand = new ArrayList<>(5);
    public List<Object> deck = new ArrayList<>();

    public void defend(int hitValue){
        System.out.println("Position attacked "+position);
        System.out.println("ATTACKED ! hit point "+hitValue);
    }
}
