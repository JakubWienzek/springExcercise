package ttt;

import java.util.InputMismatchException;
import java.util.Scanner;

import static ttt.Cell.Status;

/**
 * Created by B0660864 on 2017-03-27.
 */
public class TTT {

    private Board gameBoard;
    //private Player actualPlayer; //TODO - do another class for Player?
    private Status actualPlayer;
    private Scanner scanner;

    public static void main(String args[]) {
        new TTT().start();
    }

    TTT() {
        gameBoard = new Board();
        gameBoard.fillGameBoard();
        scanner = new Scanner(System.in);
    }

    private void start() {
        actualPlayer = Status.CROSS;
        //gameBoard.getGameBoard().forEach(p-> System.out.println(p.getActualStatus() + " " + p.getCellID()));
        while(true) {
            gameBoard.drawBoardWithFieldNumbers();
            System.out.println("Pick a field from 1 to 9:");
            changeActualPlayer(); //TODO - is there a reason for a method for 1 line?
            gameBoard.setFieldWithStatus(getUserFieldNumberInput(), actualPlayer);
            gameBoard.drawBoardWithFieldStatus();
            System.out.println("-- -- -- --");
            // TODO - winning condition
        }
    }

    /**
     * Method of gathering input from user and validating its form and value
     * @return
     * @throws InputMismatchException
     */
    private int getUserFieldNumberInput() throws InputMismatchException {

        int userLine = -1;
        try {
            while(scanner.hasNextInt()) {
                userLine = scanner.nextInt();
            }
        } catch (InputMismatchException e) {
            System.out.println("Wrong character, try again");
            getUserFieldNumberInput();
        }

        if(userLine < 0 || userLine > 8) {
            System.out.println("Number is either too high or too low, try again");
            getUserFieldNumberInput();
            //userLine = scanner.nextInt();
        }

        if(!gameBoard.getGameBoard().get(userLine-1).isStatus(Status.EMPTY)) {
            System.out.println("This field is already occupied, try again");
            getUserFieldNumberInput();
            //userLine = scanner.nextInt();
        }
        return userLine; //TODO ?
    }

    private void changeActualPlayer() {
        actualPlayer = actualPlayer == Status.CIRCLE ? Status.CROSS : Status.CIRCLE;
    }
}
