package ttt;

import java.util.InputMismatchException;
import java.util.Scanner;

import static ttt.Cell.Status;

/**
 * Created by B0660864 on 2017-03-27.
 */
public class TTT {

    private Board gameBoard;
    private Status actualPlayer;
    private boolean isWinner;


    public static void main(String args[]) {
        new TTT().start();
    }

    TTT() {
        gameBoard = new Board();
        gameBoard.fillGameBoard();
    }

    private void start() {
        actualPlayer = Status.CROSS;
        do {
            gameBoard.drawBoardWithFieldNumbers();
            System.out.println("Pick a field from 1 to 9:");
            gameBoard.setFieldWithStatus(getUserFieldNumberInput(), actualPlayer);
            gameBoard.drawBoardWithFieldStatus();
            System.out.println("-- -- -- --");
            changeActualPlayer();
            isWinner = isThereAWinner();
        } while(!isWinner);
        System.out.println(actualPlayer + " won!");
    }

    /**
     * Method of gathering input from user and validating its form and value
     * @return chosenNumber Validated input from user - a number from 1 to 9
     * @throws InputMismatchException
     */
    private int getUserFieldNumberInput()  {
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        do {
            input = gatherIntegerInput(input, scanner) - 1; //-1 cause array is from 0 to 8
        } while(!isInputInRange(input));
        return input;
    }

    private void changeActualPlayer() {
        actualPlayer = actualPlayer == Status.CIRCLE ? Status.CROSS : Status.CIRCLE;
    }

    private int gatherIntegerInput(int input, Scanner scanner) throws InputMismatchException {
        boolean isInputInteger = false;
        do {
            try {
                input = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong character, try again");
                scanner.nextLine();
                continue;
            }
            isInputInteger = true;
        } while(!isInputInteger);
        return input;
    }

    private boolean isInputInRange(int input) {
        if( input>=0 && input <= 8) {
            if (gameBoard.isFieldEmpty(input)) {
                return true;
            }
        } else {
            System.out.println("Input either too small or too high, try again");
        }
        return false;
    }

    private boolean isThereAWinner() {
        boolean isWinner = false;
        // TODO - anything here?
        return isWinner;
    }
}