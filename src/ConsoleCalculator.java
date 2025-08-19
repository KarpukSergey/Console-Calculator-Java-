import java.util.Scanner;

public class ConsoleCalculator {

    static Scanner scaner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Calculator");
        int num1 = getInt("Enter first number: ");
        char symbol = getSymbol("Enter operation:");
        int num2 = getInt("Enter second number: ");
        calc(num1, num2, symbol);
    }

    public static int getInt(String text){
        System.out.print(text);
        int num;
        if(scaner.hasNextInt()){
            num = scaner.nextInt();
        } else{
            System.out.println("Enter a number, not a string");
            scaner.next();
            num = getInt(text);
        }
        return num;
    }

    public static char getSymbol(String text){
        System.out.print(text);
        char symbol;
        if(scaner.hasNext()){
            symbol = scaner.next().charAt(0);
        } else {
            System.out.println("Invalid input");
            scaner.next();
            symbol = getSymbol(text);
        }
        return symbol;
    }

    public static void calc(int num1, int num2, char symbol){
        switch (symbol) {
            case '+':
                System.out.println(num1 + num2);
                break;
            case '-':
                System.out.println(num1 - num2);
                break;
            case '*':
                System.out.println(num1 * num2);
                break;
            case '/':
                if(num2 != 0){
                    System.out.println((double) num1 / num2);
                } else {
                    System.out.println("You can't divide by zero!");
                }

                break;
            default:
                System.out.println("such an operation does not exist");
                calc(num1, num2, getSymbol("Enter operation: "));
                scaner.close();
        }
    }

}
