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
        DEVIDE;
    }

    public static void main(String args[]) {
        new Calc().start();
    }

    private void start() {
        while(true) {
            System.out.println("what you wanna do? (plus/minus/multi/devide)");
            String operation = userInput().toUpperCase();
            System.out.println("give me numbers, seperate them with space");
            String sNumbers[] = userInput().trim().split(" ");
            //List<Integer> iNumbers = new ArrayList<Integer>();
            int iNumber=0;
            for (String number : sNumbers) {
                System.out.println(number);
                //iNumbers.add(Integer.parseInt(number));
                if(operation.equals(operations.PLUS.toString())){
                    iNumber += Integer.parseInt(number);
                } else if(operation.equals(operations.MINUS.toString())) {
                    iNumber -= Integer.parseInt(number);
                } else if(operation.equals(operations.MULTI.toString())) {
                    iNumber *= Integer.parseInt(number);
                } else if(operation.equals(operations.DEVIDE.toString())) {
                    iNumber /= Integer.parseInt(number);
                } else {
                    System.out.println("Something went wrong");
                    return;
                }

            }
            System.out.println("Result is: " + iNumber);
            //int nr1 = (int) (numbers.substring(0, numbers.indexOf(" ")));
        }
    }

    private String userInput() {
        Scanner reader = new Scanner(System.in);
        String line = reader.nextLine();

        return line;
    }
}
