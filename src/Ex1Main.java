import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2 = "", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) 
        {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();
            if (!num1.equals(quit)) 
            {
                boolean isNum1Valid = Ex1.isNumber(num1);
                int value1 = Ex1.number2Int(num1);
                System.out.println("num1= " + num1 + " is number: " + isNum1Valid + " , value: " + value1);
                if (isNum1Valid) 
                {
                    System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                    num2 = sc.next();
                    if (!num2.equals(quit)) 
                    {
                        boolean isNum2Valid = Ex1.isNumber(num2);
                        int value2 = Ex1.number2Int(num2);
                        System.out.println("num2= " + num2 + " is number: " + isNum2Valid + " , value: " + value2);
                        if (isNum2Valid) 
                        {
                            System.out.println("Enter a base for output: (a number [2,16])");
                            int base = sc.nextInt();
                            String sum = Ex1.int2Number(value1 + value2, base);
                            String product = Ex1.int2Number(value1 * value2, base);
                            String[] arr = {num1, num2, sum, product};
                            int maxIdx = Ex1.maxIndex(arr);
                            if(base == 10)
                            {
                                //remove the base from the output as decimal numbers don't need to have bA at the end
                                sum = sum.substring(0, sum.length() - 2);
                                product = product.substring(0, product.length() - 2);
                                arr = new String[]{num1, num2, sum, product}; // updating the array to not have the base at the end for decimal numbers
                         
                            }
                            System.out.println(num1 + " + " + num2 + " = " + sum);
                            System.out.println(num1 + " * " + num2 + " = " + product);
                            System.out.println("Max number over [" + num1 + "," + num2 + "," + sum + "," + product + "] is: " + arr[maxIdx]);
                        } 
                        else 
                        {
                            System.out.println("ERR: num2 is in the wrong format! (" + num2 + ")");
                        }
                    }
                } 
                else 
                {
                    System.out.println("ERR: num1 is in the wrong format! (" + num1 + ")");
                }
            }
        }
        System.out.println("quitting now...");
    }
}