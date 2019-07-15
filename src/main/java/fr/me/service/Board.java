package fr.me.service;

import fr.me.dto.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
public class Board {

    private Person[][] board = new Person[2][3];

    public Board(){
        for(int i = 0; i <= board.length-1; i++){
            for(int j = 0; j <= board[i].length-1; j++){
                board[i][j] = null;
            }
        }

    }

    public boolean isOccupied(BoardPosition position){
        return board[position.getX()][position.getY()] != null;
    }

    public Optional<Person> getAtPosition(BoardPosition position){
        try{
            return Optional.ofNullable(board[position.getX()][position.getY()] );
        }catch(ArrayIndexOutOfBoundsException e){
            return Optional.empty();
        }
    }

    public boolean setAtPosition(BoardPosition position, Person person){
        Optional<Person> atPosition = getAtPosition(position);
        if(atPosition.isPresent()){
            System.out.println(atPosition.map(Person::getName)+" is already present on this position");
            return false;
        }else{
            person.setPosition(position);
            board[position.getX()][position.getY()] = person;
            return true;
        }
    }
}
