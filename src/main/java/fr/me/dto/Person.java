package fr.me.dto;

import fr.me.dto.board.BoardPosition;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(of = {"name"})
public class Person {

    public String name;
    public BoardPosition position;

}
