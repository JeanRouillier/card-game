package fr.me.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Wither
public class BoardPosition {

    private int x;
    private int y;

    public BoardPosition offsetSameRow(){
        y = y + 1 % 3;
        return this;
    }
}
