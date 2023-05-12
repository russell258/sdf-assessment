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
                
                //try take in number 1 and number 2, catch
                try {
                    num1 = Double.parseDouble(lineInput.get(0));
                    num2 = Double.parseDouble(lineInput.get(2));

                    //trim operator for whitespaces
                    op = lineInput.get(1).replaceAll(" +", "").charAt(0);
                    
                    //check correct operator used
                    switch (op){
                        // case for Add
                        case '+':
                            Calculator.Add(num1,num2); 
                            break;
                        
                        // case for Subtract
                        case '-':
                            Calculator.Subtract(num1, num2);
                            break;

                        // case for Multiply
                        case '*':
                            Calculator.Multiply(num1,num2);
                            break;

                        //case for Divide
                        case '/':
                            Calculator.Divide(num1,num2);
                            break;

                        default:
                            System.out.println("Likely error at operator. Please use + - * / for your operator. Valid Input Syntax: Number [Space] Operator [Space] Number");
                    }
                }catch (NumberFormatException ex){
                    System.out.println("Likely error at Number. Please use a valid number. Valid Input Syntax: Number [Space] Operator [Space] Number");
                }
            }
        }
        

        System.out.println("Bye bye");
        scan.close();
    }
}
