package fr.me.dto.board;

import fr.me.dto.Person;
import fr.me.dto.board.BoardPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Data
@AllArgsConstructor
@Slf4j
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
            System.out.println(atPosition.map(Person::getName)+" is already present on this position " + position);
            return false;
        }else{
            person.setPosition(position);
            board[position.getX()][position.getY()] = person;
            return true;
        }
    }

    public void print() {
        String result ="";
        for(int i = 0; i <= board.length-1; i++){
            for(int j = 0; j <= board[i].length-1; j++){
                String value = board[i][j] != null ? board[i][j].getName() : "null";
                result += " | "+ value+" | ";
            }
            result += System.lineSeparator();
        }
        System.out.println(result);
    }
}
