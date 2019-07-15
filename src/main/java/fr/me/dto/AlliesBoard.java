package fr.me.dto;

import fr.me.dto.board.BoardPosition;
import fr.me.dto.player.Player;
import fr.me.dto.board.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlliesBoard extends Board {

    private Player wizard = new Player("wizard", null, null);
    private Player assassin = new Player("assassin", null, null);
    private Player knight = new Player("knight", null, null);
    private Player herald = new Player("herald", null, null);

    public void print(){
        System.out.println("Allies board");
        super.print();
    }
}
