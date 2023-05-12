package sg.nus.edu.iss.task01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        List <String> lineInput = new ArrayList<String>();
        double num1;
        double num2;
        char op; 

        //Welcome message
        System.out.println("Welcome.");

        //scanner to take system.input
        Scanner scan = new Scanner(System.in);

        // while input is not exit.
        while (!commandInput.equals("exit")){
            System.out.print("> ");

            // take in input and remove all extra spaces
            commandInput = scan.nextLine().replaceAll(" +"," ");

            // check is not exit before splitting to arraylist
            if (!commandInput.equals("exit")){
                lineInput = Arrays.asList(commandInput.split(" "));
                
                //take in number 1 and number 2, trim operator for whitespaces
                num1 = Double.parseDouble(lineInput.get(0));
                op = lineInput.get(1).replaceAll(" +", "").charAt(0);
                System.out.println(op);
                num2 = Double.parseDouble(lineInput.get(2));

                //check correct operator used
                if (op == '*' || op=='+' || op=='/' || op== '-'){
                    
                }else{
                    System.out.println("Likely error at operator. Please use + - * / for your operator. Valid Input Syntax: Number [Space] Operator [Space] Number");
                }
            }


        }
        

        System.out.println("Bye bye");
        scan.close();
    }
}
