package sg.nus.edu.iss.task01;

import java.util.Scanner;

//calculator accepts line input separated by single space and calculates based on number and "operator"/"symbol" given

        // Number and operators are separated by a single space. Else....?
        // 2. create function for each operator
        // all returned values should be assigned to $last
        // Add
        // Subtract 
        // Divide
        // Multiply
        // Number can be positive, negative, INTEGER or Decimal

public class Main 
{
    public static void main( String[] args )
    {
        String commandInput="";


        //Welcome message
        System.out.println("Welcome.");

        //scanner to take system.input
        Scanner scan = new Scanner(System.in);

        // while input is not exit
        while (!commandInput.equals("exit")){
            commandInput = scan.nextLine();
        }
        


        scan.close();
    }
}
