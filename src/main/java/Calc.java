import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by B0660864 on 2017-03-24.
 */
public class Calc {

    private enum operations {
        PLUS,
        MINUS,
        MULTI,
        DIVIDE
    }

    public static void main(String args[]) {
        new Calc().start();
    }

    private void start() {
        while(true) {
            System.out.println("what you wanna do? (plus/minus/multi/devide)");
            String operation = userInput().toUpperCase();
            System.out.println("give me numbers, seperate them with space");
            int sNumber;
            Integer.getInteger(userInput());
            int fNumber = Integer.getInteger(userInput());
            //List<Integer> iNumbers = new ArrayList<Integer>();

                //iNumbers.add(Integer.parseInt(number));
                /*if(operation.equals(operations.PLUS.toString())){
                    sNumber += fNumber;
                } else if(operation.equals(operations.MINUS.toString())) {
                    sNumber -= fNumber;
                } else if(operation.equals(operations.MULTI.toString())) {
                    sNumber *= fNumber;
                } else if(operation.equals(operations.DIVIDE.toString())) {
                    sNumber /= fNumber;
                } else {
                    System.out.println("Something went wrong");
                    return;
                }*/


            //System.out.println("Result is: " + sNumber);
            //int nr1 = (int) (numbers.substring(0, numbers.indexOf(" ")));
        }
    }

    private String userInput() {
        Scanner reader = new Scanner(System.in);
        String line = reader.nextLine();

        return line;
    }
}
