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
        //as only 3 slots are available
        switch(x){
            case 0:
            case 1:
                y ++;
                break;
            case 2:
                y --;
                break;
        }
        return this;
    }
}
