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

    public void drawBoardWithFieldNumbers() {
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
            System.out.print(cell.getActualStatus()+ " ");
            if(++row % 3 == 0){
                System.out.println();
            }
        }
    }

    public void setFieldWithStatus(int cellNumber, Status player) {
        cellNumber--;
        if(gameBoard.get(cellNumber).isStatus(Cell.Status.EMPTY)){
            gameBoard.get(cellNumber).setActualStatus(player);
        } else {
            System.out.println("Field is full, try again");
        }
    }

    public List<Cell> getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(List<Cell> gameBoard) {
        this.gameBoard = gameBoard;
    }
}
