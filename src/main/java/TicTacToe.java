import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jakub on 25.03.2017.
 */
public class TicTacToe {

    private List<Integer> board;
    private List<Integer> chooseBoard;
    private int counter;

    public static void main(String args[]) {
        new TicTacToe().start();
    }

    TicTacToe() {
        counter = 0;

        board = new ArrayList<>();
        for(int x = 0; x<9; x++) {
            board.add(10);
        }

        chooseBoard = new ArrayList<>();
        for(int x = 1; x<10; x++) {
            chooseBoard.add(x);
        }
    }

    private void start() {
        //pytania do usera
        draw(chooseBoard);
        System.out.println("Podaj gdzie chcesz krzyżyk");
        //zbiedanie pól
        Integer userChoice = userInput();
        //dodawnie do tabeli
        setFieldOnBoard(board, userChoice);
        //rysowanie
        draw(board);
        //decyzja o wygranej/przegranej
    }

    private void draw(List<Integer> board) {
        System.out.println("Pola:");

        board.forEach(p -> {
            //rozpoznawanie znaku i rysowanie
            if(p.equals(10)){
                System.out.print("_");
            } else if(p.equals(11)) {
                System.out.print("X");
            } else if(p.equals(12)) {
                System.out.print("O");
            } else {
                System.out.print(p);
            }
            //co X zmiana linii
            if((++this.counter % 3) == 0) {
                System.out.println();
            }
        });
    }

    private void setFieldOnBoard(List<Integer> board, Integer userChoice) {
        Integer fieldValue = board.get(userChoice-1);
        if(fieldValue <10) {
            board.set(userChoice-1, 11);
        } else {
            System.out.println("Field already occupied, try again");
        }
    }

    private Integer userInput() {
        Scanner reader = new Scanner(System.in);
        Integer line = reader.nextInt();
        if(line > 12 || line <0) {
            System.out.println("Wrong number, try again");
        }
            return line;
    }
}
