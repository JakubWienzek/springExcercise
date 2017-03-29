package ttt;

import java.util.ArrayList;
import java.util.List;
import static ttt.Cell.Status;

/**
 * Created by B0660864 on 2017-03-27.
 */
public class Board {

    private List<Cell> gameBoard;

    Board() {
        gameBoard = new ArrayList<>();
    }

    public void fillGameBoard() {
        for (int field=0; field<9; field++) {
            gameBoard.add(new Cell(field+1));
        }
    }

    public void drawBoardWithFieldNumbers() { //TODO - make one method - code repeated
        int row = 0;
        for(Cell cell : gameBoard){
            System.out.print(cell.getCellID() + " ");
            if(++row % 3 == 0){
                System.out.println();
            }
        }
    }

    public void drawBoardWithFieldStatus() {
        int row = 0;
        for(Cell cell : gameBoard){
            System.out.print(cell.getStatus()+ " ");
            if(++row % 3 == 0){
                System.out.println();
            }
        }
    }

    public boolean isFieldEmpty(int cellNumber) {
        if(gameBoard.get(cellNumber).isStatus(Status.EMPTY)){
            return true;
        } else {
            System.out.println("Field is full, try again");
            return false;
        }
    }

    public void setFieldWithStatus(int cellNumber, Status playerSign) {
            gameBoard.get(cellNumber).setStatus(playerSign);
    }

    public boolean isThreeInRow() {
        boolean isThree = false;
        //if(gameBoard.get(0).getStatus().equals()){
            //TODO - win mechanism
        //}
        return isThree;
    }

    public List<Cell> getGameBoard() {
        return gameBoard;
    }
}
