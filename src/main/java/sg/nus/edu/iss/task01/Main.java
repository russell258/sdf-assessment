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
        // test 3 + 4
        // test 3+ 4
        // test 3     ++++++++++++   4
        // test $last + $last
        // test 3 + 3 + 3 + 3 (should not return 6, should return error);
        // test exit

public class Main 
{
    public static void main( String[] args )
    {
        String commandInput="";
        List <String> lineInput = new ArrayList<String>();
        double num1;
        double num2;
        char op; 
        // assign 0 for first value
        double $last = 0;

        //Welcome message
        System.out.println("Welcome.");

        //scanner to take system.input
        Scanner scan = new Scanner(System.in);

        // while input is not exit.
        while (!commandInput.equals("exit")){
            System.out.print("> ");

            // take in input and remove all extra spaces
            commandInput = scan.nextLine().replaceAll(" +"," ");

            //split lineInput into arraylist
            lineInput = Arrays.asList(commandInput.split(" "));
            //check commandInput not exit, otherwise will get the else errors inside
            if (!commandInput.equals("exit")){
               // check lineInput length is 3, else return error
                if (lineInput.size()==3){
                    //try take in number 1 and number 2, check if is $last, otherwise catch
                    try {
                        if (lineInput.get(0).equals("$last".toLowerCase())){
                            num1 = $last;
                        }else{
                            num1 = Double.parseDouble(lineInput.get(0));
                        }
    
                        if (lineInput.get(2).equals("$last".toLowerCase())){
                            num2 = $last;
                        }else{
                            num2 = Double.parseDouble(lineInput.get(2));
                        }
    
                        //trim operator for whitespaces
                        String operator = lineInput.get(1).replaceAll(" +", "");
                        // check valid input, invalidate  ++++ ----- *** //// or +-*/ used together
                        if (operator.length()==1){
                            op = operator.charAt(0);
                            switch (op){
                                // case for Add
                                case '+':
                                    $last = Calculator.Add(num1,num2); 
                                    break;
                                
                                // case for Subtract
                                case '-':
                                    $last = Calculator.Subtract(num1, num2);
                                    break;
        
                                // case for Multiply
                                case '*':
                                    $last = Calculator.Multiply(num1,num2);
                                    break;
        
                                //case for Divide
                                case '/':
                                    $last = Calculator.Divide(num1,num2);
                                    break;
        
                                default:
                                    System.out.println("Likely error at operator. Please use + - * / for your operator. Valid Input Syntax: Number [Space] Operator [Space] Number");
                            }
                        }else{
                            System.out.println("Likely error at operator. Please use only 1 character, + - * / for your operator.");
                        }
                    }catch (NumberFormatException ex){
                        System.out.println("Likely error at Number. Please use a valid number. Valid Input Syntax: Number [Space] Operator [Space] Number");
                    }
                }else{
                    System.out.println("Invalid input. Please ensure only 2 numbers and single space between each number and operator. Valid Input Syntax: Number [Space] Operator [Space] Number");
                }
            }
        }
        

        System.out.println("Bye bye");
        scan.close();
    }
}
