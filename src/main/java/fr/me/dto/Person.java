package fr.me.dto;

import fr.me.service.BoardPosition;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(of = "name")
public class Person {

    public String name;
    public BoardPosition position;

}
