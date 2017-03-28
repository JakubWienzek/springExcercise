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


    public static void main(String args[]) {
        new TTT().start();
    }

    TTT() {
        gameBoard = new Board();
        gameBoard.fillGameBoard();
    }

    private void start() {
        actualPlayer = Status.CROSS;
        //gameBoard.getGameBoard().forEach(p-> System.out.println(p.getActualStatus() + " " + p.getCellID()));
        while(true) { //TODO - loop should have an end, possibly best to use recursion
            gameBoard.drawBoardWithFieldNumbers();
            System.out.println("Pick a field from 1 to 9:");
            gameBoard.setFieldWithStatus(getUserFieldNumberInput(), actualPlayer);
            gameBoard.drawBoardWithFieldStatus();
            System.out.println("-- -- -- --");
            changeActualPlayer(); //TODO - is there a reason for a method for 1 line?
            isThereAWinner();
        }
    }

    /**
     * Method of gathering input from user and validating its form and value
     * @return chosenNumber Validated input from user - a number from 1 to 9
     * @throws InputMismatchException
     */
    private int getUserFieldNumberInput() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        int chosenNumber = inputValidator(scanner);

        return chosenNumber;
    }

    private int inputValidator(Scanner scanner) throws InputMismatchException {
        boolean isInputOK = false;
        int input = 0;

        do {
            try {
                input = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong character, try again");
                scanner.nextLine();
                continue;
            }
            if( input>=1 && input <= 9) {
                input--; //fields are from 0 to 8
                if (gameBoard.isFieldEmpty(input)) {
                    isInputOK = true;
                }
            } else {
                System.out.println("Input either too small or too high, try again");
            }
        } while(!isInputOK);

        return input;
    }

    private void changeActualPlayer() {
        actualPlayer = actualPlayer == Status.CIRCLE ? Status.CROSS : Status.CIRCLE;
    }

    private boolean isThereAWinner() {
        boolean isWinner = false;



        return isWinner;
    }
}
